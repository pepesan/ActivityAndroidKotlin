package com.cursosdedesarrollo.activityandroidkotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_segunda.*
import kotlinx.android.synthetic.main.content_segunda.*

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        setSupportActionBar(toolbar)

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
            //Toast.makeText(this,"Mensaje: $mensaje, identificativo: $identificativo",Toast.LENGTH_LONG)
            //        .show()
            val dato=(application as Aplicacion).dato
            Toast.makeText(this,"Dato: $dato",Toast.LENGTH_LONG)
                    .show()
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
