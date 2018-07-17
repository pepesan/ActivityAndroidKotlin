package com.cursosdedesarrollo.activityandroidkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //TextView textoPrincipal=(TextView)findViewById(R.id.textoPrincipal)
        //textoPrincipal.setText("Texto Cambiado")
        textoPrincipal.text=getString(R.string.texto_cambiado)
        boton.setOnClickListener({
            //Toast.makeText(this,"Me han pulsado el botonsito!",Toast.LENGTH_LONG).show()
            presentaSnackBar(it)
        })
    }
    fun clickado(view: View): Unit{
        Log.d("app:","Pulsado")
        presentaSnackBar(view)
    }

    private fun presentaSnackBar(view: View) {
        Snackbar.make(view, "Texto de la snackbar", Snackbar.LENGTH_LONG)
                .setAction("Botón de Acción", {
                    Log.d("app:", "Pulsado")
                }).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
