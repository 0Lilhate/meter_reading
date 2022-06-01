package com.example.my_movie_app.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_movie_app.R
import com.example.my_movie_app.data.NoteData

class NoteAdapter(private val noteList: List<NoteData>): RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {




    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name_txt: TextView = itemView.findViewById(R.id.item_note_name)
        val text: TextView = itemView.findViewById(R.id.item_note_text)

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.note_item, p0, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name_txt.text = noteList[p1].getElectricity()
        p0.text.text = noteList[p1].getGAS()

    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}