package com.parser.posts.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(posts: List<PostEntity>)

    /**
     * we don't need to use suspend couroutine modifier because we are returning
     * a LiveData object which ensures task will run from background thread.
     */
    @Query("SELECT * FROM post_table")
    suspend fun getAllPosts(): List<PostEntity>

    @Query("SELECT * FROM post_table WHERE id >= 25 and id <= 100")
    suspend fun getPostsBetween25and100(): List<PostEntity>

    @Query("SELECT * FROM post_table WHERE id <= 45")
    suspend fun getPostsBellow45(): List<PostEntity>

    @Query("DELETE FROM post_table")
    suspend fun deleteAllPosts()
}