package com.example.new_pos.RoomOne

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.new_pos.Calender
import com.example.new_pos.R
import com.example.new_pos.RoomAssignment
import com.example.new_pos.Shared.PreferenceUtil
import kotlinx.android.synthetic.main.activity_room_one__menu_select.*

class RoomOne_MenuSelect : AppCompatActivity() {

    var isLiked: Boolean = true
    var orderLiked: Boolean = true
    val TAG: String = "로그"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_one__menu_select)

        isLiked = true
        orderLiked = true




        //1번방
        //방번호를 전달해준다!
        if (intent.hasExtra("Room_One")) {
            number_One_tv.text = intent.getStringExtra("Room_One")

        }










//처음에 주문버튼은 무조건 눌려야함
        order_One_btn.setOnClickListener {
            val orderOneIntent = Intent(this, RoomOne_OrderSelect::class.java)
            startActivity(orderOneIntent)
            finish()
        }

        //예약버튼을 한번 누르면 예약되었습니다. 주문버튼 불가능
        reservation_One_btn.setOnClickListener {
            //예약방 눌렀을때!
            if (isLiked == true) {

                Log.d(TAG, "MenuSelect - 예약방변경됨!")
                Toast.makeText(this, "예약방으로 변경되었습니다.", Toast.LENGTH_SHORT).show()
                reservation_One_btn.setBackgroundColor(Color.RED);
                order_One_btn.setOnClickListener {
                    Toast.makeText(this, "죄송합니다. 예약방입니다.", Toast.LENGTH_SHORT).show()
                }
                isLiked = false
                Log.d(TAG, "MenuSelect - ${isLiked}")

                //예약방 해제했을때! 한번더 눌렀을때!
            } else {
                Log.d(TAG, "MenuSelect - 예약방이 해제됨")
                reservation_One_btn.setBackgroundResource(R.drawable.gray)
                isLiked = true
                Toast.makeText(this, "예약방이 해제되었습니다.", Toast.LENGTH_SHORT).show()
                order_One_btn.setOnClickListener {
                    val orderOneIntent = Intent(this, RoomOne_OrderSelect::class.java)
                    startActivity(orderOneIntent)
                    Log.d(TAG, "MenuSelect - ${isLiked}")
                }
            }
        }






        //결산창이동!
        settlement_One_btn.setOnClickListener{
            val settlementOne = Intent(this, RoomOne_Settlement::class.java)

            //방번호를 번호로 보내준다!
            val roomNumber =  intent.getStringExtra("Room_One").toInt()
            Log.d(TAG, "RoomOne_MenuSelect - $roomNumber")


            val today =PreferenceUtil.getString("today", "해당날짜")


            //방번호가 무엇인지 전달하면 해당 방번호를 보내준다.
            settlementOne.putExtra("roomNumber", roomNumber)


            settlementOne.putExtra("today", today)


            startActivity(settlementOne)
            finish()
        }


        //뒤로가기 눌렀을때 방선택창으로 가기
        back_One_btn.setOnClickListener {
            val RoomOneIntent = Intent(this, Calender::class.java)
            startActivity(RoomOneIntent)
            finish()
        }

    }
}
