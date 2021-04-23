package co.edu.udea.compumovil.labscm20211_gr01.lab1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.get
import java.util.*

class PersonalDataActivity : AppCompatActivity() {

    lateinit var name_input: EditText
    lateinit var last_name_input: EditText
    lateinit var gender: String
    var day: Int = 0
    var month: Int = 0
    var year: Int = 0
    lateinit var education_level_input: Spinner
    var education_level_selected: Boolean = false
    lateinit var education_level: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

        name_input = findViewById<EditText>(R.id.name_input)
        last_name_input = findViewById<EditText>(R.id.last_name_input)
        education_level_input = findViewById<Spinner>(R.id.education_level_input)
        /*val button: Button = findViewById<Button>(R.id.to_contact_data_activity_button)
        button.setOnClickListener { view ->
            nextButtonClickHandler(view)
        }*/

        ArrayAdapter.createFromResource(
                this,
                R.array.education_level_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            education_level_input.adapter = adapter
        }


        education_level_input.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                education_level_selected = false
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                education_level = education_level_input.selectedItem.toString()
                education_level_selected = position != 0
                Log.i("education", education_level)

            }
        }

    }

    fun onGenderInputRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_male ->
                    if (checked) {
                        Log.i("gender", "Male")
                        gender = "Masculino"
                    }
                R.id.radio_female ->
                    if (checked) {
                        Log.i("gender", "Female")
                        gender = "Femenino"
                    }
            }
        }
    }

    fun onDateInputButtonClick(view: View) {
        val calendar: Calendar = Calendar.getInstance()
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month = calendar.get(Calendar.MONTH)
        year = calendar.get(Calendar.YEAR)
        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selected_year, selected_month, selected_day ->
            year = selected_year
            month = selected_month
            day = selected_day
            Log.i("date", day.toString() +"/"+month.toString()+"/"+year.toString())
        }, year, month, day)
        datePickerDialog.show()

    }

    /*private fun nextButtonClickHandler(view: View) {
        Log.i("name", name_input.getText().toString())
    }*/
}