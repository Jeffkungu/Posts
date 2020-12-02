package com.parser.posts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostEntity::class], version = 1)
abstract class PostDatabase : RoomDatabase() {
    abstract fun postDao(): PostDAO

    // companion modifier creates a singleton
    companion object {
        @Volatile // This makes the variable visible to all threads
        private var INSTANCE:PostDatabase? = null
        fun getInstnce(context: Context): PostDatabase {

            /**
             * synchronised means that this method will be blocked from concurrent threads
             * hence making sure only one instance is created.
             */
            synchronized(this){
                var instance:PostDatabase? = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PostDatabase::class.java,
                        "post_database"
                    ).build()
                }

                return instance;
            }


        }
    }
}