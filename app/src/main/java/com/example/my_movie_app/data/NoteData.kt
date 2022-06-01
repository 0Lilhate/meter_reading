package com.example.my_movie_app.data

class NoteData(_electricity: String, _XBC: String, _GBC: String, _GAS: String) {

    private lateinit var electricity: String
    private lateinit var XBC: String
    private lateinit var GBC: String
    private lateinit var GAS: String

    init {
        electricity = _electricity
        XBC = _XBC
        GBC = _GBC
        GAS = _GAS
    }

    fun setElectricity(electr: String){
        electricity = electr
    }
    fun setXBC(xbc: String){
        XBC = xbc
    }
    fun setGBC(gbc: String){
        GBC = gbc
    }
    fun setGAS(gas: String){
        GAS = gas
    }

    fun getElectricity(): String {
        return electricity
    }
    fun getXBC(): String {
        return XBC
    }
    fun getGBC(): String {
        return GBC
    }
    fun getGAS(): String {
        return GAS
    }
}