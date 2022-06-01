package com.example.my_movie_app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.my_movie_app.Adapter.NoteAdapter
import com.example.my_movie_app.R
import com.example.my_movie_app.data.NoteData

class MainFragment: Fragment() {
    private lateinit var myView: View
    private lateinit var noteList: List<NoteData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)
        myView = inflater.inflate(R.layout.main_fragment, container,false)
        fillList()
        val recyclerView: RecyclerView = myView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(myView.context)
        recyclerView.adapter = NoteAdapter(noteList)
        return myView

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    private fun fillList(): List<NoteData> {
        //должен считать с сервера данные счетчиков пользователя по квартире
        //Заполнения спика для проверки

        var numbers2: MutableList<NoteData> = mutableListOf()

        for (i in 0..20){
            val noteDate = NoteData("$i","$i","$i","$i")
            numbers2.add(noteDate)
        }

        noteList = numbers2
        return noteList

    }

}