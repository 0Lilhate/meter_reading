package com.example.my_movie_app.entrance

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.my_movie_app.MainActivity
import com.example.my_movie_app.R

class Entry: AppCompatActivity() {
    private var toCome: Button? = null
    private var creatAcc: TextView? = null
    private var skip: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entry)

        toCome = findViewById(R.id.toCome)
        creatAcc = findViewById(R.id.haveRegist)
        skip = findViewById(R.id.skip)

        toCome?.setOnClickListener {
            //проверка аккаунта с бд
            // переход в главную страницу активити, если прошло проверку
            // Иначе переход на содать аккаунт

        }

        creatAcc?.setOnClickListener {
            val entryIntent = Intent(this, CreateAccount::class.java)
            startActivity(entryIntent)
        }

        skip?.setOnClickListener{
            val MainIntent = Intent(this, MainActivity::class.java)
            startActivity(MainIntent)
        }


    }
}