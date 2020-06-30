package com.example.new_pos.RoomOne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.new_pos.Calender
import com.example.new_pos.R
import com.example.new_pos.RoomAssignment
import com.example.new_pos.RoomOne.RecyclerViewOne.MyRecyclerAdapter_One
import com.example.new_pos.RoomOne.RecyclerViewOne.Myreceipt_One
import com.example.new_pos.Shared.MyApplication
import com.example.new_pos.Shared.PreferenceUtil
import kotlinx.android.synthetic.main.activity_room_one__menu_select.*
import kotlinx.android.synthetic.main.activity_room_one__receipt.*
import kotlinx.android.synthetic.main.activity_room_one__settlement.*
import java.util.*
import kotlin.collections.ArrayList

class RoomOne_Settlement : AppCompatActivity() {
    //데이터를 담을 그릇 즉 배열
    var modelListOne = ArrayList<Myreceipt_One>()
    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_one__settlement)

        //날짜를 변수에 담는다.
        var room_date =""



        //방번호를 변수에 담기
        var receivedRoomnumber = 0

        // 방번호마다 영수증을 저장한다.
        if (intent.hasExtra("roomNumber") && intent.hasExtra("today")) {
            room_date = intent.getStringExtra("today")
            receivedRoomnumber = intent.getIntExtra("roomNumber", 0)
            //쉐어드로 저장한 영수증을 가지고온다.
            var tempModelList = PreferenceUtil.getReceiptList() as ArrayList<Myreceipt_One>
            //방마다 해당하는 영수증을 걸러준다.
            var filteredList = ArrayList<Myreceipt_One>()


            //해당 영수증만 가지고온다!
            tempModelList.forEach {

                if (it.roomnameOne?.toInt() == receivedRoomnumber && it.dateroom?.toString() == room_date){
                    filteredList.add(it)
                }
            }



            this.modelListOne = filteredList
        } else {
            this.modelListOne = PreferenceUtil.getReceiptList() as ArrayList<Myreceipt_One>
        }









//        // 날짜마다 영수증을 저장한다.
//        if (intent.hasExtra("today")) {
//            room_date = intent.getStringExtra("today")
//            Log.d(TAG, "$room_date    <-------")
//            //쉐어드로 저장한 영수증을 가지고온다.
//            var tempModelList_date = PreferenceUtil.getReceiptList() as ArrayList<Myreceipt_One>
//            //방마다 해당하는 영수증을 걸러준다.
//            var filteredList_date = ArrayList<Myreceipt_One>()
//            //해당 영수증만 가지고온다.
//            tempModelList_date.forEach {
//
//                if (it.dateroom?.toString() == room_date) {
//                    filteredList_date.add(it)
//                }
//            }
//
//            this.modelListOne = filteredList_date
//        } else {
//            this.modelListOne = PreferenceUtil.getReceiptList() as ArrayList<Myreceipt_One>
//        }










        Log.d(TAG, "$receivedRoomnumber    <------receivedRoomnumber-")

        Log.d(TAG, "$room_date    <------room_date-")



//방향 설정 등등 -> reverseLayout:true 하면 최신이 위로 올라온다!.
        val linearLayoutManager = LinearLayoutManager(this@RoomOne_Settlement, LinearLayoutManager.VERTICAL, true)
        linearLayoutManager.stackFromEnd = true


        //리사이클러뷰 설정
        recycler_view_settlement.apply {

            adapter = MyRecyclerAdapter_One(modelListOne)

            layoutManager = linearLayoutManager

        }

        //캘린더로가
        back_calender_btn.setOnClickListener {
            val backcaleder = Intent(this, Calender::class.java)
            startActivity(backcaleder)
            finish()
        }

    }
}