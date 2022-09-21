package edu.tcu.tanmaykejriwal.ageinminutes

import java.time.temporal.ChronoUnit
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.xml.datatype.DatatypeConstants.DAYS
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateBtn=findViewById<Button>(R.id.button)
        dateBtn.setOnClickListener{ handleDatePicker()}
    }

    private fun handleDatePicker(){
        val calendar= Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(this@MainActivity,
        { view, yearPicked, monthOfYear, dayOfMonth ->
            val minuteText = findViewById<TextView>(R.id.textView7)
            var currDate = calendar.time
            calendar.set(yearPicked,monthOfYear,dayOfMonth)
            var Bdate = calendar.time
            val diff: Long = abs(currDate.time - Bdate.time)
            val MinDiff:Long = diff/(1000*60)
            minuteText.text = MinDiff.toString()
            //displaying the data selected
            val dateSelected = findViewById<TextView>(R.id.textView5)
            var displayMonth=monthOfYear+1
            println(currDate)
            println(Bdate)
            println(MinDiff)
            dateSelected.text= "$displayMonth/$dayOfMonth/$yearPicked"

        }, year, month, day)
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show()


    }

}