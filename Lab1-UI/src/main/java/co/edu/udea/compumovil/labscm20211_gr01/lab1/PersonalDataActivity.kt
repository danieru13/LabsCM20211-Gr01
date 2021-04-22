package co.edu.udea.compumovil.labscm20211_gr01.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class PersonalDataActivity : AppCompatActivity() {

    lateinit var name_input: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        name_input = findViewById<EditText>(R.id.name_input)
        /*val button: Button = findViewById<Button>(R.id.to_contact_data_activity_button)
        button.setOnClickListener { view ->
            nextButtonClickHandler(view)
        }*/
    }

    /*private fun nextButtonClickHandler(view: View) {
        Log.i("name", name_input.getText().toString())
    }*/
}