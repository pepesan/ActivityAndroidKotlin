package com.cursosdedesarrollo.activityandroidkotlin

import android.os.Bundle

import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Log.d("app:SegundaActivity","onCreate")
        try {
            //String mensaje = getIntent.getExtras().getStringExtra("Mensaje")
            val mensaje=intent.getStringExtra("Mensaje")
            val identificativo = intent.getLongExtra("id",0L)
            Toast.makeText(this,"Mensaje: $mensaje, identificativo: $identificativo",Toast.LENGTH_LONG).show()
            val dato=(application as Aplicacion).dato
            Toast.makeText(this,"Dato: $dato",Toast.LENGTH_LONG)
                    .show()
            val textView = findViewById<View>(R.id.textView) as TextView
            textView.text=dato
        }catch (e:Exception){
            println("por si acaso")
        }
    }

    fun volver(view: View):Unit{
        finish()
    }
    override fun onPause() {
        super.onPause()
        Log.d("app:SegundaActivity","onPause")
        //Guardar el dato
    }

    override fun onStop() {
        super.onStop()
        Log.d("app:SegundaActivity","onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d("app:SegundaActivity","onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d("app:SegundaActivity","onStart")
    }

}
