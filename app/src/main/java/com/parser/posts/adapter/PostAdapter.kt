package com.parser.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.parser.posts.R
import com.parser.posts.database.PostEntity
import com.parser.posts.databinding.ItemPostBinding

class PostAdapter: RecyclerView.Adapter<MyViewHolder>() {
    private val postList = ArrayList<PostEntity>()

    fun setPosts(posts: List<PostEntity>){
        postList.clear()
        postList.addAll(posts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflator: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemPostBinding = DataBindingUtil.inflate(
            layoutInflator,
            R.layout.item_post,
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}

class MyViewHolder(val itemPostBinding: ItemPostBinding):
    RecyclerView.ViewHolder(itemPostBinding.root){

    fun bind(postEntity: PostEntity){
        itemPostBinding.tvTitle.text = postEntity.name
        itemPostBinding.tvBody.text = postEntity.body
        itemPostBinding.tvEmail.text = postEntity.email
    }
}