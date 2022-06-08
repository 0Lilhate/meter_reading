package com.example.my_movie_app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.my_movie_app.R
import com.example.my_movie_app.data.NoteData
import com.example.my_movie_app.database.DataViewModel
import com.google.android.material.snackbar.Snackbar


class AddNote : Fragment() {
    private lateinit var OkButton: Button
    private lateinit var electricity: EditText
    private lateinit var xbc: EditText
    private lateinit var GBC: EditText
    private lateinit var Gas: EditText
    private lateinit var myView:View
    private lateinit var mViewModel: DataViewModel

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
        mViewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        electricity = myView.findViewById(R.id.electricity_ET)
        xbc = myView.findViewById(R.id.XBC_ET)
        GBC = myView.findViewById(R.id.GBC_ET)
        Gas = myView.findViewById(R.id.gas_ET)
        OkButton = myView.findViewById(R.id.buttonOk)

        val _electricity = electricity.text.toString()
        val _xbc = xbc.text.toString()
        val _GBC = GBC.text.toString()
        val _Gas = Gas.text.toString()


        OkButton.setOnClickListener {
            if (!_electricity.equals("") and !_xbc.equals("") and !_GBC.equals("") and _Gas.equals("")){
                Snackbar.make(myView, "Nice", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()

                //Здесь ошибка
                mViewModel.addNode(NoteData(id = 1, electricity = _electricity, XBC = _xbc, GBC = _GBC, GAS = _Gas ))
            }
            else{
                Snackbar.make(myView, "Error", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
            }
        }
    }
}