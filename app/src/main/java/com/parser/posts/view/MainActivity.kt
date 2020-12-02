package com.parser.posts.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.parser.posts.R
import com.parser.posts.databinding.ActivityMainBinding
import com.parser.posts.utils.ConstantValues
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this

        activityMainBinding.viewAll.setOnClickListener {
            val intent = Intent(this@MainActivity, PostsActivity::class.java)
            intent.putExtra(ConstantValues.POSTS_INTENT_KEY, ConstantValues.DISPLAY_ALL_POSTS)
            startActivity(intent)
        }

        activityMainBinding.poststBellowId45.setOnClickListener {
            val intent = Intent(this@MainActivity, PostsActivity::class.java)
            intent.putExtra(ConstantValues.POSTS_INTENT_KEY, ConstantValues.DISPLAY_POSTS_BELLLOW45)
            startActivity(intent)
        }

        activityMainBinding.poststBetween30And90.setOnClickListener {
            val intent = Intent(this@MainActivity, PostsActivity::class.java)
            intent.putExtra(ConstantValues.POSTS_INTENT_KEY, ConstantValues.DISPLAY_POSTS_BETWEEN_30_AND_90)
            startActivity(intent)
        }

    }
}
