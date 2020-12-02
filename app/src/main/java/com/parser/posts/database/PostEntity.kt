package com.parser.posts.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * We use @data class and declare the variables in the constructor.
 * @Entity annotation creates a table.
 */
@Entity(tableName = "post_table")
data class PostEntity (

    // Its best practice to give columns separate names from member variables
    @SerializedName("body")
    @ColumnInfo(name = "post_body")
    val body: String,

    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "post_id")
    val id: Int,

    @SerializedName("title")
    @ColumnInfo(name = "post_title")
    val title: String,

    @SerializedName("userId")
    @ColumnInfo(name = "post_user_id")
    val userId: Int







)