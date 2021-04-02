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
    @SerializedName("postId")
    @ColumnInfo(name = "post_id")
    val postId: Int,

    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @SerializedName("name")
    @ColumnInfo(name = "post_name")
    val name: String,

    @SerializedName("email")
    @ColumnInfo(name = "post_email")
    val email: String,

    @SerializedName("body")
    @ColumnInfo(name = "post_body")
    val body: String

)