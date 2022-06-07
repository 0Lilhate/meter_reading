package com.example.my_movie_app.database.room

import androidx.lifecycle.LiveData
import com.example.my_movie_app.data.NoteData

class AppRoomRepository(private val appRoomDao: AppRoomDao){
    val allNotes: LiveData<List<NoteData>> get() = appRoomDao.getAllNotes()

    suspend fun insert(note: NoteData, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess() //коллбэк, что задача была выполнена
    }

    suspend fun delete(note: NoteData, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
    }
}