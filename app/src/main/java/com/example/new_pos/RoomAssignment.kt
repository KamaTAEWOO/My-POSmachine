package com.example.new_pos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.new_pos.RoomOne.RoomOne_MenuSelect
import com.example.new_pos.Shared.MyApplication
import com.example.new_pos.Shared.PreferenceUtil
import kotlinx.android.synthetic.main.activity_room_assignment.*

class RoomAssignment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_assignment)

        //1번방누르면 메뉴 선택창으로 이동함!
        first_btn.setOnClickListener {
            val firstIntent = Intent(this, RoomOne_MenuSelect::class.java)
            firstIntent.putExtra("Room_One", "1")
            PreferenceUtil.setString("RoomOne", "1")
            startActivity(firstIntent)
            finish()
        }

        //2번방누르면 메뉴 선택창으로 이동함!
        second_btn.setOnClickListener {
            val secondIntend = Intent(this, RoomOne_MenuSelect::class.java)
            secondIntend.putExtra("Room_One", "2")
            PreferenceUtil.setString("RoomOne", "2")
            startActivity(secondIntend)
            finish()
        }

        //3번방누르면 메뉴 선택창으로 이동함!
        three_btn.setOnClickListener {
            val threeIntend = Intent(this, RoomOne_MenuSelect::class.java)
            threeIntend.putExtra("Room_One", "3")
            PreferenceUtil.setString("RoomOne", "3")
            startActivity(threeIntend)
            finish()
        }

        //특실누르면 메뉴 선택창으로 이동함!
        seven_btn.setOnClickListener {
            val sevenIntend = Intent(this, RoomOne_MenuSelect::class.java)
            sevenIntend.putExtra("Room_One", "7")
            PreferenceUtil.setString("RoomOne", "7")
            startActivity(sevenIntend)
            finish()
        }

        //5번누르면 메뉴 선택창으로 이동함!
        five_btn.setOnClickListener {
            val fiveIntend = Intent(this, RoomOne_MenuSelect::class.java)
            fiveIntend.putExtra("Room_One", "5")
            PreferenceUtil.setString("RoomOne", "5")
            startActivity(fiveIntend)
            finish()
        }

        //6번누르면 메뉴 선택창으로 이동함!
        sixth_btn.setOnClickListener {
            val sixthIntend = Intent(this, RoomOne_MenuSelect::class.java)
            sixthIntend.putExtra("Room_One", "6")
            PreferenceUtil.setString("RoomOne", "6")
            startActivity(sixthIntend)
            finish()
        }





        back_calender_btn.setOnClickListener{
            val BackCalender = Intent(this, Calender::class.java)
            startActivity(BackCalender)
            finish()
        }


        //날짜 받아서 띄우주기
        if (intent.hasExtra("today")) {
            today.text = intent.getStringExtra("today")


            //만약 전달할 데이터가 없다면
        } else {
            Toast.makeText(this, "잘못된 만남 입니다.", Toast.LENGTH_SHORT).show()
        }

    }
}