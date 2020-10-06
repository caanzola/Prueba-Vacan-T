package com.example.pruebavacan_t.HomePage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.net.HttpURLConnection
import java.net.URL
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.gson.Gson
import org.json.JSONObject
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TableLayout
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TableRow
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R
import com.google.gson.JsonArray
import org.json.JSONArray
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.view.setPadding


class HomeActivity: AppCompatActivity(){

    class Establecimiento(idEstablecimiento: Int, idAsociado: Int, nombre: String, razonSocial: String, direccion: String, lat: String, long:String, status: String,
                          tarifaVehiculo: String, tarifaMoto: String, fechaCreacion: String, fechaActualizacion: String, imageUrl: String, horario: String,
                          telefono: String, ciudadEstablecimiento: String, splitReceivers: String, splitRule: String, color: String, nit: String, codigoEDS: String,
                          code: String) {
        val idEstablecimiento = idEstablecimiento
        val idAsociado = idAsociado
        val nombre = nombre
        val razonSocial = razonSocial
        val direccion = direccion
        val lat = lat
        val long = long
        val status = status
        val tarifaVehiculo = tarifaVehiculo
        val tarifaMoto = tarifaMoto
        val fechaCreacion = fechaCreacion
        val fechaActualizacion = fechaActualizacion
        val imageUrl = imageUrl
        val horario = horario
        val telefono = telefono
        val ciudadEstablecimiento = ciudadEstablecimiento
        val splitReceivers = splitReceivers
        val splitRule = splitRule
        val color = color
        val nit = nit
        val codigoEDS = codigoEDS
        val code = code
    }

    var data: List<Establecimiento>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.pruebavacan_t.R.layout.activity_home)



        val thread = Thread(Runnable {
            try {
                val connection = URL("https://apiprueba.gopass.com.co/establishment/getAllEstablishment").openConnection() as HttpURLConnection
                connection.connect()
                println(connection.responseCode)
                println(connection.getHeaderField("Content-Type"))
                val text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }

                val jsonObj = JSONObject(text.substring(text.indexOf("{"), text.lastIndexOf("}") + 1))
                val dataJson = jsonObj.getJSONArray("data")

                println(dataJson)
                for (i in 0..dataJson!!.length() - 1) {
                    val idEstablecimiento = dataJson.getJSONObject(i).getString("idestablecimiento").toInt()
                    val idAsociado = dataJson.getJSONObject(i).getString("idasociado").toInt()
                    val nombre = dataJson.getJSONObject(i).getString("nombre")
                    val razonsocial = dataJson.getJSONObject(i).getString("razonsocial")
                    val direccion = dataJson.getJSONObject(i).getString("direccion")
                    val lat = dataJson.getJSONObject(i).getString("latitud")
                    val long = dataJson.getJSONObject(i).getString("longitud")
                    val status = dataJson.getJSONObject(i).getString("status")
                    val tarifaVehiculo = dataJson.getJSONObject(i).getString("tarifaVehiculo")
                    val tarifaMoto = dataJson.getJSONObject(i).getString("tarifaMoto")
                    val fechaCreacion = dataJson.getJSONObject(i).getString("fechaCreacion")
                    val fechaActualizacion = dataJson.getJSONObject(i).getString("fechaActualizacion")
                    val imageUrl = dataJson.getJSONObject(i).getString("imageurl")
                    val horario = dataJson.getJSONObject(i).getString("horario")
                    val telefono = dataJson.getJSONObject(i).getString("telefono")
                    val ciudadEstablecimiento = dataJson.getJSONObject(i).getString("ciudadestablecimiento")
                    val splitReceivers = dataJson.getJSONObject(i).getString("splitReceivers")
                    val splitRule = dataJson.getJSONObject(i).getString("splitRule")
                    val color = dataJson.getJSONObject(i).getString("color")
                    val codigoEDS = dataJson.getJSONObject(i).getString("codigoEDS")
                    val code = dataJson.getJSONObject(i).getString("code")
                    val nit = dataJson.getJSONObject(i).getString("nit")

                    val establecimiento = Establecimiento(idEstablecimiento = idEstablecimiento, idAsociado = idAsociado, nombre = nombre, razonSocial = razonsocial,
                        direccion = direccion, lat = lat, long = long, status = status, tarifaVehiculo = tarifaVehiculo, tarifaMoto = tarifaMoto, fechaCreacion = fechaCreacion,
                        fechaActualizacion = fechaActualizacion, imageUrl = imageUrl, horario = horario, telefono = telefono, ciudadEstablecimiento = ciudadEstablecimiento,
                        splitReceivers = splitReceivers, splitRule = splitRule, color = color, nit = nit, codigoEDS = codigoEDS, code = code)

                    println(establecimiento.nombre)
                    data?.toMutableList()?.add(establecimiento)

                    runOnUiThread {
                        //Do something on UiThread
                        val t1 = findViewById(com.example.pruebavacan_t.R.id.t1) as TableLayout
                        val row = TableRow(this)
                        val tv1 = TextView(this) as TextView
                        tv1.setPadding(10, 10, 10, 10)
                        tv1.setText(""+idEstablecimiento)
                        val tv2 = TextView(this)  as TextView
                        tv2.setText(""+idAsociado)
                        tv2.setPadding(10, 10, 10, 10)
                        val tv3 = TextView(this) as TextView
                        tv3.setText(nombre)
                        tv3.setPadding(10, 10, 10, 10)
                        val tv4 = TextView(this) as TextView
                        tv4.setText(razonsocial)
                        tv4.setPadding(10, 10, 10, 10)
                        val tv5 = TextView(this) as TextView
                        tv5.setText(direccion)
                        tv5.setPadding(10, 10, 10, 10)
                        val tv6 = TextView(this) as TextView
                        tv6.setText(lat)
                        tv6.setPadding(10, 10, 10, 10)
                        val tv7 = TextView(this) as TextView
                        tv7.setText(long)
                        tv7.setPadding(10, 10, 10, 10)
                        val tv8 = TextView(this) as TextView
                        tv8.setText(status)
                        tv8.setPadding(10, 10, 10, 10)
                        val tv9 = TextView(this) as TextView
                        tv9.setText(tarifaVehiculo)
                        tv9.setPadding(10, 10, 10, 10)
                        val tv10 = TextView(this) as TextView
                        tv10.setText(tarifaMoto)
                        tv10.setPadding(10, 10, 10, 10)
                        val tv11 = TextView(this) as TextView
                        tv11.setText(fechaCreacion)
                        tv11.setPadding(10, 10, 10, 10)
                        val tv12 = TextView(this) as TextView
                        tv12.setText(fechaActualizacion)
                        tv12.setPadding(10, 10, 10, 10)
                        val tv13 = TextView(this) as TextView
                        tv13.setText(imageUrl)
                        tv13.setPadding(10, 10, 10, 10)
                        val tv14 = TextView(this) as TextView
                        tv14.setText(horario)
                        tv14.setPadding(10, 10, 10, 10)
                        val tv15 = TextView(this) as TextView
                        tv15.setText(telefono)
                        tv15.setPadding(10, 10, 10, 10)
                        val tv16 = TextView(this) as TextView
                        tv16.setText(ciudadEstablecimiento)
                        tv16.setPadding(10, 10, 10, 10)
                        val tv17 = TextView(this) as TextView
                        tv17.setText(splitReceivers)
                        tv17.setPadding(10, 10, 10, 10)
                        val tv18 = TextView(this) as TextView
                        tv18.setText(splitRule)
                        tv18.setPadding(10, 10, 10, 10)
                        val tv19 = TextView(this) as TextView
                        tv19.setText(color)
                        tv19.setPadding(10, 10, 10, 10)
                        val tv20 = TextView(this) as TextView
                        tv20.setText(nit)
                        tv20.setPadding(10, 10, 10, 10)
                        val tv21 = TextView(this) as TextView
                        tv21.setText(codigoEDS)
                        tv21.setPadding(10, 10, 10, 10)
                        val tv22 = TextView(this) as TextView
                        tv22.setText(code)
                        tv22.setPadding(10, 10, 10, 10)


                        row.addView(tv1)
                        row.addView(tv2)
                        row.addView(tv3)
                        row.addView(tv4)
                        row.addView(tv5)
                        row.addView(tv6)
                        row.addView(tv7)
                        row.addView(tv8)
                        row.addView(tv9)
                        row.addView(tv10)
                        row.addView(tv11)
                        row.addView(tv12)
                        row.addView(tv13)
                        row.addView(tv14)
                        row.addView(tv15)
                        row.addView(tv16)
                        row.addView(tv17)
                        row.addView(tv18)
                        row.addView(tv19)
                        row.addView(tv20)
                        row.addView(tv21)
                        row.addView(tv22)

                        t1.addView(row)
                    }




                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })

        thread.start()

    }

}