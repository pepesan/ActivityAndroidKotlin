package com.cursosdedesarrollo.activityandroidkotlin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class SegundaActivity : AppCompatActivity() {
    var buttonLlamada : Button? = null

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
            //String mensaje = getIntent().getExtras().getStringExtra("Mensaje")
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
        buttonLlamada= findViewById(R.id.button_llamada)
        buttonLlamada?.setOnClickListener{
            Log.d("app","Intenta llamada")
            intentaLlamada()
        }
    }
    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.CALL_PHONE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        42)
            }
        } else {
            // Permission has already been granted
            callPhone()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == 42) {
            // If request is cancelled, the result arrays are empty.
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // permission was granted, yay!
                callPhone()
            } else {
                // permission denied, boo! Disable the
                // functionality
            }
            return
        }
    }

    fun callPhone(){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+34 656 66 14 78"))
        startActivity(intent)
    }
    private fun intentaLlamada() {
        checkPermission()
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
