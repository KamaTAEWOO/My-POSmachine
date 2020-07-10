package com.example.new_pos.RoomOne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.new_pos.R
import com.example.new_pos.RoomOne.RecyclerViewOne.Myreceipt_One
import com.example.new_pos.Shared.PreferenceUtil
import kotlinx.android.synthetic.main.activity_room_one__receipt.*

class RoomOne_Receipt : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_one__receipt)


        //SharedPreferences 사용하기 조회
        //방번호 저장불러오기
        RoomNumber_One_tv.text =
            PreferenceUtil.getString("RoomOne", "???") + "번 방입니다."
        //총금액 저장값 불러오기
        total_One_tv.text =PreferenceUtil.getString("total_One", "총금액")






        //결제방법!버튼 누르면 어떻게 결제했다! 전달
        //현금
        money_One_btn.setOnClickListener {
            method_One_tv.text="현금입니다."
            PreferenceUtil.setString("methodOne", "현금으로 계산했습니다.")
        }

        //카드
        card_One_btn.setOnClickListener {
            method_One_tv.text="카드입니다."
            PreferenceUtil.setString("methodOne", "카드로 계산했습니다.")
        }


        //상품권
        gift_card_One_btn.setOnClickListener {
            method_One_tv.text="상품권입니다."
            PreferenceUtil.setString("methodOne", "상품권으로 계산했습니다.")
        }




        back_order_btn.setOnClickListener{
            val backorder = Intent(this, RoomOne_OrderSelect::class.java)
            startActivity(backorder)
            finish()
        }


        //결산창이동!
        //계산완료버튼을 누를시! 결산창에 영수증이 적립된다.!
        //모든데이터를 여기 안에 모두 넣어서 버튼을 클릭시 해당내용이 나오도록 해야한다.
        //버튼 클릭시 리사이클러뷰가 발사!!된다는
        receipt_settlement_One_btn.setOnClickListener{

            //새로운 영수증을 추가한다.
            //add는 사용하지 않는다. -> add는 뒤에 추가하는것 ! 같은값이 계속 추가된다. -> 우리가 원하는 것은 새로운 값.
            val newReceipt = Myreceipt_One(PreferenceUtil.getString("RoomOne", "방번호"),
                PreferenceUtil.getString("total_One", "총금액"),
                PreferenceUtil.getString("methodOne", "결제방법"),
                PreferenceUtil.getString("today", "해당날짜"))

            //방번호에 따라 결산창이 달라진다.
            var roomNumber = 0

            if (newReceipt.roomnameOne != null) {
                roomNumber = newReceipt.roomnameOne!!.toInt()
            }


            //날짜마다 결산창이 달라진다.
            var today =PreferenceUtil.getString("today", "해당날짜")

            if (newReceipt.dateroom != null) {
                today = newReceipt.dateroom!!.toString()
            }


            //1.기존 데이터를 가지고 와야한다. 기존에 어떤 데이터가 있었는지 기억을 하고 다시 주문창에서 주문을 하고 들어와도 데이터가 남아 있을 수 있도록 해야한다.
            //저장한 영수증을 가지고 온다.
            val storedReceiptList =  PreferenceUtil.getReceiptList() as ArrayList<Myreceipt_One>


            //2.새 데이터를 추가한다.
            //방금 내가 설정한 데이터를 newReceipt뒤에  add한다.
            storedReceiptList.add(newReceipt)

            //3.모두 저장해버린다.
            PreferenceUtil.setReceiptList(storedReceiptList)




            //결산창으로 넘어가는 곳
            val settlementOne = Intent(this, RoomOne_Settlement::class.java)
            //방번호에 맞게 방마다 영수증의 리스트를 가지고온다.
            settlementOne.putExtra("roomNumber", roomNumber)
            settlementOne.putExtra("today", today)
            startActivity(settlementOne)
            finish()
        }




    }
}