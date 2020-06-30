package com.example.new_pos.RoomOne.RecyclerViewOne

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.new_pos.R
import kotlinx.android.synthetic.main.layout_recycler_receipt.view.*

class MyRecyclerAdapter_One(var modelListOne: ArrayList<Myreceipt_One>) : RecyclerView.Adapter<MyViewHolder_One>(){


    val TAG: String = "로그"


    //생성자
    init {

    }

    //뷰홀더 생성 되었을때, !!->꼭 값이 있다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder_One {
        return MyViewHolder_One(itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_receipt,parent,false))
    }



    //item갯수
    override fun getItemCount(): Int {
        return this.modelListOne.size
    }

    //뷰와 뷰 홀더가 묶였을때
    override fun onBindViewHolder(holderOne: MyViewHolder_One, position: Int) {
        //holderOne.bind(this.modelListOne[position])
        Log.d(TAG, "ListRecyclerViewAdapter - onBindViewHolder() called  position: $position")

        //
        val myModelOne = this.modelListOne[position]

//        val todoItem = this.todoList[0]
        holderOne.itemView.recycler_room_number.text= myModelOne.dateroom
        holderOne.itemView.recycler_room_number.text= myModelOne.roomnameOne
        holderOne.itemView.recycler_room_price.text= myModelOne.roomtotalOne
        holderOne.itemView.recycler_room_method.text= myModelOne.roommethodOne


        holderOne.bind(myModelOne)

    }
    //외부에서 넘어오는애와 연결시킨다.(총알장전) ,액티비티에서도 배열가지고 어답터에서도 배열을 가지게 하려고!
    fun submitList (modelListOne: ArrayList<Myreceipt_One>){
        this.modelListOne = modelListOne

    }

}