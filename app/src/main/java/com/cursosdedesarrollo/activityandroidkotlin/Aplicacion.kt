package com.cursosdedesarrollo.activityandroidkotlin

import android.app.Application

class  Aplicacion :Application {
    lateinit var dato: String

    constructor(): super(){
        this.dato=""
    }

}