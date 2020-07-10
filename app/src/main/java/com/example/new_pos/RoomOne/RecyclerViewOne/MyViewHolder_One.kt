package com.example.new_pos.RoomOne.RecyclerViewOne

import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.new_pos.RoomRecyclerViewInterface
import com.example.new_pos.Shared.MyApplication
import com.example.new_pos.Shared.PreferenceUtil
import kotlinx.android.synthetic.main.layout_recycler_receipt.view.*


//커스텀
class MyViewHolder_One(itemView: View , roomRecyclerViewInterface: RoomRecyclerViewInterface):
    RecyclerView.ViewHolder(itemView), View.OnClickListener

{

    val TAG: String = "로그"
    var isClick : Boolean = false
    var number : Int = 0





    private var roomRecyclerViewInterface : RoomRecyclerViewInterface

    init {
        this.roomRecyclerViewInterface = roomRecyclerViewInterface
        //쓰레기통 클릭시!
        itemView.delete_room_btn.setOnClickListener(this)
    }

    val RecyclerRoomNumber = itemView.recycler_room_number
    val recycler_room_price = itemView.recycler_room_price
    val recycler_room_method = itemView.recycler_room_method
    val recycler_room_date = itemView.recycler_room_date



    //데이터와 뷰를 묶는다. -> 뷰랑 데이터 연결부분 , => 앱 종료시에 다시 들어왔을때에도 저장이 되어있음!
    fun bind(myModelOne: Myreceipt_One){
        //Log.d(TAG, "MyViewHolder - bind() called")
        recycler_room_date.text=myModelOne.dateroom
        RecyclerRoomNumber.text = myModelOne.roomnameOne + "번 방입니다."
        recycler_room_price.text=myModelOne.roomtotalOne
        recycler_room_method.text=myModelOne.roommethodOne

    }


    override fun onClick(v: View?) {
        isClick=true
        number = adapterPosition
        Log.d(TAG, "MyViewHolder_One - onClick() called ====> $number 번입니다.")

        this.roomRecyclerViewInterface.onRoomItemRemove(adapterPosition)

    }

}