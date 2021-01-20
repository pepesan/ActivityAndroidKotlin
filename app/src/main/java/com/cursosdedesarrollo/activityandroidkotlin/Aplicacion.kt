package com.cursosdedesarrollo.activityandroidkotlin

import android.app.Application
import android.util.Log

class  Aplicacion() : Application() {
    var dato: String

    init {
        Log.d("app:Aplicacion","constructor")
        this.dato=""
    }

}