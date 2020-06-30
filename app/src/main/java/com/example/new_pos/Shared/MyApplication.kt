package com.example.new_pos.Shared

import android.app.Application

//SharedPreferences 사용하기
//배열로 쉐어드를 사용하기 위해 먼저 바꿔주어야 할 곳이다!
class MyApplication : Application() {

    //instance는 메모리에 올라간 녀석들을 뜻한다.
    //메모리에 올라갔다는 뜻은 내가 결산창에서 띄운 영수증들이 메모리에 하나씩 쌓인다는 뜻이다.
    companion object {
        //lateinit var prefs: PreferenceUtil
        lateinit var instance: MyApplication
    }
    override fun onCreate() {
       // prefs =
           // PreferenceUtil(applicationContext)
        super.onCreate()
        instance =this
    }
}