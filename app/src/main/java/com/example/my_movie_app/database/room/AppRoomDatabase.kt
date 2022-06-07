package com.example.my_movie_app.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.my_movie_app.data.NoteData


@Database(entities = [NoteData::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getAppRoomDao(): AppRoomDao

    //привет синглтон, давно не виделись
    companion object {

        @Volatile //означает, что база данных не должна кэшироватсья
        private var database: AppRoomDatabase? = null

        @Synchronized //запрещаем обращаться к функции нескольким экземплярам класса одновременно
        fun getInstance(context: Context): AppRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "note_tables"
                ).build()
                database as AppRoomDatabase
            } else database as AppRoomDatabase
        }
    }
}