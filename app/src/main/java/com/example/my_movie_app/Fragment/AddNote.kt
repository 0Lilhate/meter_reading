package com.example.my_movie_app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.fragment.app.Fragment

import com.example.my_movie_app.R
import com.google.android.material.snackbar.Snackbar


class AddNote : Fragment() {
    private lateinit var OkButton: Button
    private lateinit var electricity: EditText
    private lateinit var xbc: EditText
    private lateinit var GBC: EditText
    private lateinit var Gas: EditText
    private lateinit var myView:View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        myView = inflater.inflate(R.layout.add_note, container, false)
        return myView

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        initFields()
    }

    private fun initFields() {
        electricity = myView.findViewById(R.id.electricity_ET)
        xbc = myView.findViewById(R.id.XBC_ET)
        GBC = myView.findViewById(R.id.GBC_ET)
        Gas = myView.findViewById(R.id.gas_ET)
        OkButton = myView.findViewById(R.id.buttonOk)
        OkButton.setOnClickListener {
            if (!electricity.text.toString().equals("") and !xbc.text.toString().equals("") and !GBC.text.toString().equals("")
            and !Gas.text.toString().equals("")){
                Snackbar.make(myView, "Nice", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
            }
            else{
                Snackbar.make(myView, "Error", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
            }
        }
    }
}