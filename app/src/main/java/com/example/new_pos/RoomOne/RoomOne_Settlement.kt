package com.example.new_pos.RoomOne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.new_pos.Calender
import com.example.new_pos.R
import com.example.new_pos.RoomOne.RecyclerViewOne.MyRecyclerAdapter_One
import com.example.new_pos.RoomOne.RecyclerViewOne.MyViewHolder_One
import com.example.new_pos.RoomOne.RecyclerViewOne.Myreceipt_One
import com.example.new_pos.RoomRecyclerViewInterface
import com.example.new_pos.Shared.MyApplication
import com.example.new_pos.Shared.PreferenceUtil
import com.example.new_pos.Shared.PreferenceUtil.KEY_RECEIPT_REMOVE
import com.example.new_pos.Shared.PreferenceUtil.adapter
import kotlinx.android.synthetic.main.activity_room_one__settlement.*
import kotlin.collections.ArrayList

class RoomOne_Settlement : AppCompatActivity(), RoomRecyclerViewInterface {

    //데이터를 담을 그릇 즉 배열
    var modelListOne = ArrayList<Myreceipt_One>()
    val TAG: String = "로그"

    lateinit var myRecyclyerViewAdapter : MyRecyclerAdapter_One


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



        Log.d(TAG, "$receivedRoomnumber    <------receivedRoomnumber-")

        Log.d(TAG, "$room_date    <------room_date-")



//방향 설정 등등 -> reverseLayout:true 하면 최신이 위로 올라온다!.
        val linearLayoutManager = LinearLayoutManager(this@RoomOne_Settlement, LinearLayoutManager.VERTICAL, true)
        linearLayoutManager.stackFromEnd = true


        this.myRecyclyerViewAdapter = MyRecyclerAdapter_One(modelListOne,this)

        //리사이클러뷰 설정
        recycler_view_settlement.apply {


            //리사이클러뷰 어답터 준비!
//            adapter = MyRecyclerAdapter_One(modelListOne,this@RoomOne_Settlement)
            adapter = myRecyclyerViewAdapter

            //총알 장전.
            layoutManager = linearLayoutManager

        }

        //캘린더로가
        back_calender_btn.setOnClickListener {
            val backcaleder = Intent(this, Calender::class.java)
            startActivity(backcaleder)
            finish()
        }

    }


    //아이템을 지울때!
    override fun onRoomItemRemove(position: Int) {

//      KEY_RECEIPT_REMOVE=position

        Log.d(TAG, "RoomListActivity - onRoomItemRemove() called / position: $position ")

//      this.modelListOne[position].isDone = isClick

        this.modelListOne.removeAt(position)

        this.myRecyclyerViewAdapter.notifyDataSetChanged()

//        MyRecyclerAdapter_One(this.modelListOne,this@RoomOne_Settlement).RoomremoveAt(KEY_RECEIPT_REMOVE)

        // 변경된 배열을 저장한다
        PreferenceUtil.setReceiptList(this.modelListOne)


    }

}