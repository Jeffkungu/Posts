package com.parser.posts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.parser.posts.R
import com.parser.posts.adapter.PostAdapter
import com.parser.posts.database.PostEntity
import com.parser.posts.databinding.ActivityPostsBinding
import com.parser.posts.dependencyinjection.Injector
import com.parser.posts.utils.ConstantValues
import com.parser.posts.viewmodel.PostsViewModel
import com.parser.posts.viewmodel.PostsViewModelFactory
import javax.inject.Inject

class PostsActivity : AppCompatActivity() {
    private lateinit var activityPostBinding : ActivityPostsBinding

    @Inject
    lateinit var postsViewModelFactory: PostsViewModelFactory

    private lateinit var postsViewModel: PostsViewModel
    private lateinit var postsAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        activityPostBinding = DataBindingUtil.setContentView(this, R.layout.activity_posts)
        activityPostBinding.lifecycleOwner = this

        setSupportActionBar(activityPostBinding.toolbarPosts)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = getString(R.string.posts_toolbar_title)
        }

        // Inject dependency to activity
        (application as Injector).createPostSubComponent().inject(this)

        postsViewModel = ViewModelProvider(this, postsViewModelFactory)
            .get(PostsViewModel::class.java)

        initialiseRecyclerView()

        val postType : Int = intent.getIntExtra(ConstantValues.POSTS_INTENT_KEY, -1)


        when(postType) {
            ConstantValues.DISPLAY_ALL_POSTS -> displayAllPosts()
            ConstantValues.DISPLAY_POSTS_BETWEEN_25_AND_100 -> displayPostsBeteen25and100()
        }
    }

    private fun initialiseRecyclerView(){
        activityPostBinding.rvPosts.layoutManager = LinearLayoutManager(this)
        postsAdapter = PostAdapter()
        activityPostBinding.rvPosts.adapter = postsAdapter
    }

    private fun displayAllPosts(){
        val resposnseLiveData: LiveData<List<PostEntity>?> = postsViewModel.getAllPosts()
        resposnseLiveData.observe(this, Observer {
            if (it != null) {
                Log.i("RESULTS", it.size.toString())
                supportActionBar!!.title = it.size.toString() + " Posts"
                postsAdapter.setPosts(it)
                postsAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun displayPostsBeteen25and100() {
        val resposnseLiveData: LiveData<List<PostEntity>?> = postsViewModel.getPostsBetwen25and100()
        resposnseLiveData.observe(this, Observer {
            if (it != null) {
                Log.i("RESULTS", it.size.toString())
                supportActionBar!!.title = it.size.toString() + " Posts"
                postsAdapter.setPosts(it)
                postsAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (android.R.id.home == item.itemId) {
            onBackPressed()
        }
        return true
    }

}
