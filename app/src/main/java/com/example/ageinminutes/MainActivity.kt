package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button= findViewById(R.id.btnDatePicker)
        var tvSelectedDate : TextView?=null
         tvSelectedDate =findViewById(R.id.tvSelectedDate)
        var tvAgeInMinutes : TextView? =null
        tvAgeInMinutes=findViewById(R.id.tvAgeInMinutes)
         fun clickDatePicker()
        {
            val myCalendar = Calendar.getInstance()
            val year =myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day =myCalendar.get(Calendar.DAY_OF_MONTH)

            var x = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view,year,month,dayOfMonth->
                Toast.makeText(
                    this,"Button is pressed" , Toast.LENGTH_LONG).show()
                var selectedDate = "${year}/${month+1}/${dayOfMonth}"
                tvSelectedDate?.text=selectedDate

                var sdf = SimpleDateFormat("dd/MM/yyyyy", Locale.ENGLISH)

                var date = sdf.parse(selectedDate)
                date?.let{
                var selectedDateInMinutes = date.time/6000

                var currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentDate?.let {
                var currentDateInMinutes = currentDate.time/6000


                var ans = currentDateInMinutes-selectedDateInMinutes

                tvAgeInMinutes?.text= ans.toString()
                }
                }

            },
            year,
            month,
            day)

            x.datePicker.maxDate = System.currentTimeMillis()-86400000
            x.show()


        }


        btnDatePicker.setOnClickListener {
            clickDatePicker()


        }
    }
}