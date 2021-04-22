package co.edu.udea.compumovil.labscm20211_gr01.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.*
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ContactDataActivity : AppCompatActivity() {
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        var autoCompleteTextViewCountries = findViewById<AutoCompleteTextView>(R.id.acPais)
        var adapterCountries = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.countries))
        autoCompleteTextViewCountries.setAdapter(adapterCountries)
        findViewById<AutoCompleteTextView>(R.id.acCiudad).setOnFocusChangeListener(View.OnFocusChangeListener { view, hasFocus ->
            run {
                if (hasFocus) {
                    var actualText = autoCompleteTextViewCountries.text.toString()
                    if (actualText == "Colombia" || actualText == "colombia") {
                        setArrayAdapterCities()
                    }
                    else{
                        if(flag){
                            var autoCompleteTextViewCities = findViewById<AutoCompleteTextView>(R.id.acCiudad)
                            autoCompleteTextViewCities.setAdapter(null)
                            flag = false
                        }
                    }
                }
            }
        })
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
            var tilTelefono = findViewById<TextInputLayout>(R.id.tilTelefono);
            var tilCorreo = findViewById<TextInputLayout>(R.id.tilCorreo)
            var tilPais = findViewById<TextInputLayout>(R.id.tilPais)
            var tilCiudad = findViewById<TextInputLayout>(R.id.tilCiudad)
            var tilDireccion = findViewById<TextInputLayout>(R.id.tilDireccion)
            var titulo = findViewById<TextView>(R.id.tvInfoContacto).text.toString()
            var infoContacto = " " +"\n"+ titulo +": "+ "\n" + tilTelefono.hint.toString() + ": " + textTelefono.toString() +"\n" +
                    tilCorreo.hint.toString() + ": " + textCorreo.toString() + "\n" +
                    tilPais.hint.toString() + ": " + textPais.toString() + "\n"

            if(!textCiudad.toString().isEmpty()){
                infoContacto = infoContacto + tilCiudad.hint.toString() + ": " + textCiudad.toString()+ "\n"
            }
            if(!textDireccion.toString().isEmpty()){
                infoContacto = infoContacto + tilDireccion.hint.toString() + ": " + textDireccion.toString() + "\n"
            }
            Log.i("Datos obtenidos" ,"\n" + infoContacto)
            Toast.makeText(this, "Datos obtenidos", Toast.LENGTH_SHORT).show()
            return
        }
    }

    private fun setArrayAdapterCities(){
        flag = true
        var autoCompleteTextViewCities = findViewById<AutoCompleteTextView>(R.id.acCiudad)
        var adapterCities = ArrayAdapter(this,android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.cities))
        autoCompleteTextViewCities.setAdapter(adapterCities)
    }
}