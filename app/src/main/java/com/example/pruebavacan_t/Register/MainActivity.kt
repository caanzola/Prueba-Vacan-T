package com.example.pruebavacan_t.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.pruebavacan_t.HomePage.HomeActivity
import com.example.pruebavacan_t.R
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T







class MainActivity : AppCompatActivity() {

    /**
     * Id type of the user
     */
    var idType: String = ""

    /**
     * Id number of the user
     */
    var idNumber: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val spinner = findViewById(R.id.types_spinner) as Spinner
        val valores = arrayOf("T.I", "C.C", "C.E")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, valores)



        var registerBut = findViewById<TextView>(R.id.register_button)
        registerBut.setOnClickListener {

            val text = findViewById(R.id.last_name_register_value) as EditText
            val lastName = text.text.toString()

            val text2 = findViewById(R.id.name_register_value) as EditText
            val name = text2.text.toString()

            val text3 = findViewById(R.id.email_register_value) as EditText
            val email = text3.text.toString()

            val text4 = findViewById(R.id.passwrd_value) as EditText
            val pass = text4.text.toString()

            val text5 = findViewById(R.id.numid_value) as EditText
            val numId = text5.text.toString()

            val type = spinner.selectedItem.toString()



            val intent = Intent(this, idRegister::class.java)


            intent.putExtra("name", name)
            intent.putExtra("lastName", lastName)
            intent.putExtra("email", email)
            intent.putExtra("pass", pass)
            intent.putExtra("numid", numId)
            intent.putExtra("type", type)
            startActivity(intent)

        }
    }
}
