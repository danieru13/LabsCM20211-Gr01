package co.edu.udea.compumovil.labscm20211_gr01.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText

class ContactDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        var autoCompleteTextViewCountries = findViewById<AutoCompleteTextView>(R.id.acPais)
        var adapterCountries = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.countries))
        autoCompleteTextViewCountries.setAdapter(adapterCountries)
        findViewById<Button>(R.id.btnSiguienteCDA).setOnClickListener{comprobarInfo(it)}
    }

    private fun comprobarInfo(view: View){
        val telefono = findViewById<TextInputEditText>(R.id.tiTelefono)
        val correo= findViewById<TextInputEditText>(R.id.tiCorreo)
        val pais = findViewById<AutoCompleteTextView>(R.id.acPais)
        val ciudad = findViewById<AutoCompleteTextView>(R.id.acCiudad)
        val direccion = findViewById<TextInputEditText>(R.id.tiDireccion)
        val textTelefono = telefono.text
        val textCorreo = correo.text
        val textPais = pais.text
        val textCiudad = ciudad.text
        val textDireccion = direccion.text
        if(textTelefono.toString().isEmpty() || textCorreo.toString().isEmpty() ||
                textPais.toString().isEmpty()){
            Toast.makeText(this, "Se deben ingresar los campos obligatorios", Toast.LENGTH_SHORT).show()
            return
        }else{
            Log.i("Información de contacto", " ")
            Log.i("Teléfono", textTelefono.toString())
            Log.i("Correo", textCorreo.toString())
            Log.i("Pais",textPais.toString())
            if(!textCiudad.toString().isEmpty()){
                Log.i("Ciudad",textCiudad.toString())
            }
            if(!textDireccion.toString().isEmpty()){
                Log.i("Dirección: ", textDireccion.toString())
            }
        }
    }
    private fun setArrayAdapterCities(){
        var autoCompleteTextViewCities = findViewById<AutoCompleteTextView>(R.id.acCiudad)
        var adapterCities = ArrayAdapter(this,android.R.layout.simple_list_item_1,
        resources.getStringArray(R.array.cities))
        autoCompleteTextViewCities.setAdapter(adapterCities)
    }
}