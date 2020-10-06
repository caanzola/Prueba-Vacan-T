package com.example.pruebavacan_t.Register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.example.pruebavacan_t.R

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



        var idTypeText = findViewById<TextView>(R.id.id_type_register_value)
        idTypeText.text = idType
        var idNumberText = findViewById<TextView>(R.id.id_number_register_value)
        idNumberText.text = idNumber
    }
}
