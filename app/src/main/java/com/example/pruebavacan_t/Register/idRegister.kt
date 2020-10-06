package com.example.pruebavacan_t.Register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.R
import android.content.Intent
import android.widget.Spinner
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.EditText
import android.widget.TextView
import com.example.pruebavacan_t.HomePage.HomeActivity
import java.net.HttpURLConnection
import java.net.URL
import android.os.AsyncTask.execute
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.IOException
import org.json.JSONObject
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.io.DataOutputStream
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class idRegister: AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.pruebavacan_t.R.layout.idregister_activity)
        var name = getIntent().getStringExtra("name")
        var lastname = getIntent().getStringExtra("lastName")
        var email = getIntent().getStringExtra("email")
        var pass = getIntent().getStringExtra("pass")
        var numId = getIntent().getStringExtra("numid")
        var type = getIntent().getStringExtra("type")



        var registerBut = findViewById<TextView>(com.example.pruebavacan_t.R.id.register_button)
        registerBut.setOnClickListener {
            val text = findViewById(com.example.pruebavacan_t.R.id.email_register_value) as EditText
            val phone = text.text.toString()


            val thread = Thread(Runnable {
                try {
                    val url = URL("https://apiprueba.gopass.com.co/client/registre")

                    with(url.openConnection() as HttpURLConnection) {
                        requestMethod = "POST"
                        var connection = url.openConnection() as HttpURLConnection
                        connection.requestMethod = "POST"
                        val wr = DataOutputStream(connection.outputStream)


                        val jsonParam = JSONObject()
                        jsonParam.put("nombres", name)
                        jsonParam.put("apellidos", lastname)
                        jsonParam.put("correo", email)
                        jsonParam.put("password", pass)
                        jsonParam.put("telefonoMovil", phone)
                        jsonParam.put("tipoDocumento", type)
                        jsonParam.put("numeroIdentificacion", numId)

                        wr.writeBytes(jsonParam.toString())
                        wr.flush()
                        wr.close()

                        println("\nResponse Code : $responseCode")

                        inputStream.bufferedReader().use {
                            it.lines().forEach { line ->
                                println(line)
                            }
                        }
                    }

                }
                catch (e: Exception) {
                    e.printStackTrace()
                }
            })

            thread.start()


            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}