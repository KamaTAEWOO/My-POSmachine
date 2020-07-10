package com.example.new_pos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.new_pos.Shared.PreferenceUtil
import kotlinx.android.synthetic.main.activity_calender.*
import ru.cleverpumpkin.calendar.CalendarDate
import ru.cleverpumpkin.calendar.CalendarView
import java.text.SimpleDateFormat
import java.util.*

class Calender : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

        Log.d(TAG, "Calender - main")

        val calendar = Calendar.getInstance()
        Log.d(TAG, "Calender - $calendar")

//현재시간
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val currentMonth = Calendar.getInstance().get(Calendar.MONTH)
        val currentDay = Calendar.getInstance().get(Calendar.DATE)

        Log.d(TAG, "Calender - currentYear : $currentYear")
        Log.d(TAG, "Calender - currentMonth : ${currentMonth+1}")
        Log.d(TAG, "Calender - currentDay : $currentDay")


        // Initial date
        calendar.set(currentYear, currentMonth, currentDay)
        val initialDate = CalendarDate(calendar.time)


        //// Minimum available date
//        calendar.set(2018, Calendar.MAY, 15)
//        val minDate = CalendarDate(calendar.time)

//// Maximum available date
//        calendar.set(2018, Calendar.JULY, 15)
//        val maxDate = CalendarDate(calendar.time)

// List of preselected dates that will be initially selected
//        val preselectedDates: List<CalendarDate> = getPreselectedDates()

// The first day of week
        val firstDayOfWeek = java.util.Calendar.MONDAY
// Set up calendar with all available parameters
        simpleCalendarView.setupCalendar(
            initialDate = initialDate,
//            minDate = minDate,
//            maxDate = maxDate,ß
            selectionMode = CalendarView.SelectionMode.SINGLE,
            firstDayOfWeek = firstDayOfWeek,
            showYearSelectionView = true
        )
        Log.d(TAG, "initialDate - $initialDate")
        Log.d(TAG, "firstDayOfWeek - $firstDayOfWeek")




        // Set date click callback
        simpleCalendarView.onDateClickListener = { date ->
//            //원하는 날짜로 출력
            val pattern = "yyyy-MM-dd"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.format(date.timeInMillis)


            //Log.d(TAG, "Calender - date 값 ====> $date")
            //val selectedDates = simpleCalendarView.selectedDates
            val selectedDates = Intent(this, RoomAssignment::class.java)
            selectedDates.putExtra("today", "$date")
            Log.d(TAG, "date 값 ====> $date")

            //날짜를 저장한다.
            PreferenceUtil.setString("today", "$date")
            startActivity(selectedDates)
            finish()
        }



// Set date long click callback
//        simpleCalendarView.onDateLongClickListener = { date ->
//            Log.d(TAG, "Calender - 길게 클릭")
//           // Do something ...
//        }

//        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            val calendardate = Intent(this, RoomAssignment::class.java)
//            calendardate.putExtra("date", "$year" +"년"+ "${(month + 1)}"+"월"+"$dayOfMonth"+"일")
//            startActivity(calendardate)
//        }



    }
}