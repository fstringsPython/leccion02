package com.cursokotlin.a02leccion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cursokotlin.a02leccion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var vBind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        vBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vBind.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        vBind.btnIngresar.setOnClickListener { verificar() }

    }//cierre método onCreate

    fun verificar(){

        val nota = vBind.ingresoCalificacion.text.toString().toInt()
        if(nota >= 70){
            val aprueba = "Felicidades has aprobado!"
            vBind.tVrespuesta.setText(aprueba)
        }
        if(nota < 70){
            val reprueba = "Has reprobado la nota mínima es 70"
            vBind.tVrespuesta.setText(reprueba)
        }

    }

}