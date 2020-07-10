package com.example.new_pos.Shared

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.new_pos.RoomOne.RecyclerViewOne.MyRecyclerAdapter_One
import com.example.new_pos.RoomOne.RecyclerViewOne.Myreceipt_One
import com.example.new_pos.Shared.PreferenceUtil.adapter
import com.google.gson.Gson

//SharedPreferences 사용하기
//1.모두가 사용할수 있도록 object로 사용한다.
object PreferenceUtil {

    //영수증 담는 리스트의 변수를 만들어준다.
    private const val RECEIPT_LIST = "shared_receipt_list"

    //해당 키가 있어야  그키에 맞게 저장을 하여 각각 저장이 가능하다.
    private const val KEY_RECEIPT_LIST = "key_receipt_list"

    //삭제할 키를 만든다.
    var KEY_RECEIPT_REMOVE = 0

    var adapter: MyRecyclerAdapter_One? = null


    //로그를 찍기 위해 사용한다.
    val TAG: String = "로그"


    //context는 사용불가!
    val prefs: SharedPreferences =
        MyApplication.instance.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    //데이터 조회할때!
    fun getString(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }

    //데이터 저장올때
    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }

    // 데이터를 영수증 리스트에 저장할때 사용하는 함수!
    fun setReceiptList(receiptList: ArrayList<Myreceipt_One>) {
        Log.d(TAG, "PreferenceUtil - setReceiptList() called")

        // 문자열로 만들어서 저장한다.
        val listStringToBeStored = Gson().toJson(receiptList)

        //영수증 리스트에 저장한다.
        val receiptListPrefs: SharedPreferences =
            MyApplication.instance.getSharedPreferences(RECEIPT_LIST, Context.MODE_PRIVATE)

        //키값을 설정해서 저장한 값의 키값을 설정
        receiptListPrefs.edit().putString(KEY_RECEIPT_LIST, listStringToBeStored).apply()
    }


    // 저장한 영수증을 가지고오기 비었으면 빈것이라도 가지고 온다.
    fun getReceiptList(): MutableList<Myreceipt_One> {
        Log.d(TAG, "PreferenceUtil - getReceiptList() called")
        val receiptListPrefs: SharedPreferences =
            MyApplication.instance.getSharedPreferences(RECEIPT_LIST, Context.MODE_PRIVATE)
        //값이 없으면 ""을 가지고옴,
        //저장한 값의 키값을 주고 그 키값을 가지고 온다.
        val storedListString = receiptListPrefs.getString(KEY_RECEIPT_LIST, "")!!
        //내가 방금 저장한 영수증을 변수에 저장한다.
        var storedReceiptList = ArrayList<Myreceipt_One>()

        // string -> [object]
        //만약 값이 없다면?
        //처음인 값을 설정한다.
        //toMutableList 리스트의 공간이 늘어난다.!
        if (storedListString.isNotEmpty()) {
            storedReceiptList = Gson().fromJson(storedListString, Array<Myreceipt_One>::class.java)
                .toMutableList() as ArrayList<Myreceipt_One>
        }

        return storedReceiptList
    }


    // 영수증 삭제할 키 저장후 삭제
    fun setReceiptListRemove(key:Int) {
        KEY_RECEIPT_REMOVE = key

        Log.d(TAG, "PreferenceUtil - position 번호 ====>  $KEY_RECEIPT_REMOVE")

        Log.d(TAG, "PreferenceUtil - setReceiptListRemove() called 들어옴!")
        val receiptListPrefs: SharedPreferences =
            MyApplication.instance.getSharedPreferences(KEY_RECEIPT_REMOVE.toString(), Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = receiptListPrefs.edit()
        editor.remove("KEY_RECEIPT_REMOVE")

        editor.commit()

        Log.d(TAG, "PreferenceUtil - setReceiptListRemove() called 나감! -====> 삭제완료! ")

    }


//    // 영수증 저장된 것 삭제리턴
//    fun getReceiptListRemove(key:String, default: String): String? {
//        Log.d(TAG, "PreferenceUtil - getReceiptListRemove() called 들어옴!")
//        val receiptListPrefs: SharedPreferences =
//            MyApplication.instance.getSharedPreferences(KEY_RECEIPT_REMOVE.toString(), Context.MODE_PRIVATE)
//
//
//        Log.d(TAG, "PreferenceUtil - getReceiptListRemove() called 나감!")
//
//
//        return receiptListPrefs.getInt(key,default)
//
//    }


}
