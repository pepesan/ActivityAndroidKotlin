package com.cursosdedesarrollo.activityandroidkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var snackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textoPrincipal = findViewById<View>(R.id.textoPrincipal) as TextView
        val boton = findViewById<View>(R.id.boton) as Button
        textoPrincipal.text=getString(R.string.texto_cambiado)
        boton.setOnClickListener ({
            //Toast.makeText(this,"Me han pulsado el botonsito!",Toast.LENGTH_LONG).show()
            presentaSnackBar(it)
        })
        snackbar= Snackbar.make(boton, "Texto de la snackbar", Snackbar.LENGTH_LONG)
                .setAction("Botón de Acción") {
                    Log.d("app:", "Pulsado")
                }
        Log.d("app:MainActivity","onCreate")
    }
    fun clickado(view: View): Unit{
        Log.d("app:","Pulsado")
        presentaSnackBar(view)
    }

    private fun presentaSnackBar(view: View) {

        snackbar?.show()
    }
    fun salta(view : View){
        /* Salto sin datos
        val intent = Intent(this,SegundaActivity::class.java)
        startActivity(intent)
        */
        //paso de datos por la aplicación
        (application as Aplicacion).dato ="Mi Dato"
        //Salto con datos
        val intent = Intent(this,SegundaActivity::class.java)
        intent.putExtra("Mensaje", "Mi Mensaje")
        intent.putExtra("id", 22L)
        this.startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
    /*
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

     */

    override fun onPause() {
        super.onPause()
        Log.d("app:MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("app:MainActivity","onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d("app:MainActivity","onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.d("app:MainActivity","onStart")
    }
}
