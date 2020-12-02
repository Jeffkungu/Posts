package com.parser.posts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Toast
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

        // Inject dependency to activity
        (application as Injector).createPostSubComponent().inject(this)

        postsViewModel = ViewModelProvider(this, postsViewModelFactory)
            .get(PostsViewModel::class.java)

        initialiseRecyclerView()

        val postType : Int = intent.getIntExtra(ConstantValues.POSTS_INTENT_KEY, -1)


        when(postType) {
            ConstantValues.DISPLAY_ALL_POSTS -> displayAllPosts()
            ConstantValues.DISPLAY_POSTS_BELLLOW45 -> displayPostsBellow45()
            ConstantValues.DISPLAY_POSTS_BETWEEN_30_AND_90 -> displayPostsBeteen30and90()
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
                activityPostBinding.tvTitle.text = it.size.toString() + " Posts"
                postsAdapter.setPosts(it)
                postsAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun displayPostsBellow45() {
        val resposnseLiveData: LiveData<List<PostEntity>?> = postsViewModel.getPostsBellow45()
        resposnseLiveData.observe(this, Observer {
            if (it != null) {
                Log.i("RESULTS", it.size.toString())
                activityPostBinding.tvTitle.text = it.size.toString() + " Posts"
                postsAdapter.setPosts(it)
                postsAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun displayPostsBeteen30and90() {
        val resposnseLiveData: LiveData<List<PostEntity>?> = postsViewModel.getPostsBetwen30and90()
        resposnseLiveData.observe(this, Observer {
            if (it != null) {
                Log.i("RESULTS", it.size.toString())
                activityPostBinding.tvTitle.text = it.size.toString() + " Posts"
                postsAdapter.setPosts(it)
                postsAdapter.notifyDataSetChanged()
            }
        })
    }

}
