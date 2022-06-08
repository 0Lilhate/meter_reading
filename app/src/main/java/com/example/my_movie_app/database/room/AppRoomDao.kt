package com.example.my_movie_app.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.my_movie_app.data.NoteData

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM note_tables")
    fun getAllNotes(): LiveData<List<NoteData>>

    //в случае, если будут какие то конфликты, то мы будем игнорировать эту операцию
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg note: NoteData)

    @Query("DELETE FROM note_tables")
    suspend fun delete(note: NoteData)

    @Update
    fun updateTodo(vararg todos: NoteData)
}