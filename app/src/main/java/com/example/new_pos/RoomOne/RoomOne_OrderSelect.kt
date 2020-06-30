package com.example.new_pos.RoomOne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.new_pos.R
import com.example.new_pos.Shared.MyApplication
import com.example.new_pos.Shared.PreferenceUtil
import kotlinx.android.synthetic.main.activity_room_one__order_select.*

class RoomOne_OrderSelect : AppCompatActivity() {

    val TAG: String = "로그"

    //count 3개씩 , sum 2개씩
    //방크기
    //작은방
    var small_sum: Int=0
    var small_scount: Int =0
    //중간방
    var middle_sum: Int=0
    var middle_count: Int =0

    //중간방
    var Big_sum: Int=0
    var Big_count: Int =0

    //주류
    //소주
    var soju_sum: Int=0
    var soju_count: Int =0
    //맥주캔
    var can_sum: Int=0
    var can_count: Int =0
    //맥주피쳐
    var heaver_sum: Int=0
    var heaver_count: Int =0

    //음료수
    var drink_sum: Int=0
    var drink_count: Int =0

    //안주
    //과일
    var fruit_sum: Int=0
    var fruit_count: Int =0

    //마른안주
    var thin_sum: Int=0
    var thin_count: Int =0

    //오징어
    var squid_sum: Int=0
    var squid_count: Int =0

    //육포&대구포
    var beef_sum: Int=0
    var beef_count: Int =0

    //세트
    //양주 세트
    var liquor_sum: Int=0
    var liquor_count: Int =0

    //어시스트 세트
    //1명
    var assist_one_sum: Int=0
    var assist_one_count: Int =0
    //2명
    var assist_two_sum: Int=0
    var assist_two_count: Int =0

    //3명
    var assist_three_sum: Int=0
    var assist_three_count: Int =0

    //4명
    var assist_for_sum: Int=0
    var assist_for_count: Int =0

    //5명
    var assist_five_sum: Int=0
    var assist_five_count: Int =0

    //어시스트만
    var assist_sum: Int=0
    var assist_count: Int =0

    //어시스트and안주
    var assist_snack_sum: Int=0
    var assist_snack_count: Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_one__order_select)


        //작은방
        small_add_btn.setOnClickListener {
            //갯수에 따른 방 가격
            small_sum=20000 * (small_scount+1)
            //Log.d(TAG, "OrderSelect - ${sum}")


            price_tv.text=small_sum.toString()

            Sum(small_sum)


            //add버튼을 누른 횟수
            small_scount++
            count_tv.text=small_scount.toString()



        }

        small_del_btn.setOnClickListener {


            if (small_scount > 0) {
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                small_sum -= 20000
                price_tv.text = small_sum.toString()

                Sum(small_sum)

                //del버튼을 누른 횟수
                small_scount--
                count_tv.text = small_scount.toString()


            } else {
                Toast.makeText(this, "0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }
        //중간방
        middle_add_btn.setOnClickListener {

            //갯수에 따른 방 가격
            middle_sum=25000 * (middle_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            mprice_tv.text=middle_sum.toString()

            Sum(middle_sum)

            //add버튼을 누른 횟수
            middle_count++
            mcount_tv.text=middle_count.toString()

        }

        middle_del_btn.setOnClickListener {


            if(middle_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                middle_sum -=25000
                mprice_tv.text=middle_sum.toString()

                Sum(middle_sum)


                //del버튼을 누른 횟수
                middle_count--
                mcount_tv.text=middle_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //큰방
        Big_add_btn.setOnClickListener {

            //갯수에 따른 방 가격
            Big_sum=30000 * (Big_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            Big_price_tv.text=Big_sum.toString()

            Sum(Big_sum)

            //add버튼을 누른 횟수
            Big_count++
            Big_count_tv.text=Big_count.toString()

        }

        Big_del_btn.setOnClickListener {
            if(Big_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                Big_sum -=30000
                Big_price_tv.text=Big_sum.toString()
                Sum(Big_sum)

                //del버튼을 누른 횟수
                Big_count--
                Big_count_tv.text=Big_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

//       //주류
//        //소주
        soju_add_btn.setOnClickListener {

            soju_sum=5000 * (soju_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            soju_price_tv.text=soju_sum.toString()

            Sum(soju_sum)

            //add버튼을 누른 횟수
            soju_count++
            soju_count_tv.text=soju_count.toString()

        }

        soju_del_btn.setOnClickListener {


            if(soju_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                soju_sum -=5000
                soju_price_tv.text=soju_sum.toString()
                Sum(soju_sum)

                //del버튼을 누른 횟수
                soju_count--
                soju_count_tv.text=soju_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //맥주캔
        can_add_btn.setOnClickListener {

            can_sum=5000 * (can_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            can_price_tv.text=can_sum.toString()

            Sum(can_sum)

            //add버튼을 누른 횟수
            can_count++
            can_count_tv.text=can_count.toString()

        }

        can_del_btn.setOnClickListener {

            if(can_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                can_sum -=5000
                can_price_tv.text=can_sum.toString()
                Sum(can_sum)

                //del버튼을 누른 횟수
                can_count--
                can_count_tv.text=can_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }


        //맥주피쳐
        heaver_add_btn.setOnClickListener {


            heaver_sum=20000 * (heaver_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            heaver_price_tv.text=heaver_sum.toString()

            Sum(heaver_sum)

            //add버튼을 누른 횟수
            heaver_count++
            heaver_count_tv.text=heaver_count.toString()

        }

        heaver_del_btn.setOnClickListener {


            if(heaver_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                heaver_sum -=20000
                heaver_price_tv.text=heaver_sum.toString()
                Sum(heaver_sum)

                //del버튼을 누른 횟수
                heaver_count--
                heaver_count_tv.text=heaver_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }


        //음료수
        drink_add_btn.setOnClickListener {


            drink_sum=1000 * (drink_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            drink_price_tv.text=drink_sum.toString()


            Sum(drink_sum)

            //add버튼을 누른 횟수
            drink_count++
            drink_count_tv.text=drink_count.toString()

        }

        drink_del_btn.setOnClickListener {

            if(drink_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                drink_sum -=1000
                drink_price_tv.text=drink_sum.toString()
                Sum(drink_sum)

                //del버튼을 누른 횟수
                drink_count--
                drink_count_tv.text=drink_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //안주
        //과일
        fruit_add_btn.setOnClickListener {


            fruit_sum=25000 * (fruit_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            fruit_price_tv.text=fruit_sum.toString()
            Sum(fruit_sum)

            //add버튼을 누른 횟수
            fruit_count++
            fruit_count_tv.text=fruit_count.toString()

        }

        fruit_del_btn.setOnClickListener {

            if(fruit_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                fruit_sum -=25000
                fruit_price_tv.text=fruit_sum.toString()
                Sum(fruit_sum)

                //del버튼을 누른 횟수
                fruit_count--
                fruit_count_tv.text=fruit_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //마른안주
        thin_add_btn.setOnClickListener {


            thin_sum=20000 * (thin_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            thin_price_tv.text=thin_sum.toString()
            Sum(thin_sum)

            //add버튼을 누른 횟수
            thin_count++
            thin_count_tv.text=fruit_count.toString()

        }

        thin_del_btn.setOnClickListener {

            if(thin_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                thin_sum -=20000
                thin_price_tv.text=thin_sum.toString()
                Sum(thin_sum)

                //del버튼을 누른 횟수
                thin_count--
                thin_count_tv.text=thin_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //오징어
        squid_add_btn.setOnClickListener {


            squid_sum=15000 * (squid_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            squid_price_tv.text=squid_sum.toString()

            Sum(squid_sum)
            //add버튼을 누른 횟수
            squid_count++
            squid_count_tv.text=squid_count.toString()

        }

        squid_del_btn.setOnClickListener {

            if(squid_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                squid_sum -=15000
                squid_price_tv.text=squid_sum.toString()
                Sum(squid_sum)

                //del버튼을 누른 횟수
                squid_count--
                squid_count_tv.text=squid_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //육포@대구포
        beef_add_btn.setOnClickListener {


            beef_sum=20000 * (beef_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            beef_price_tv.text=beef_sum.toString()

            Sum(beef_sum)
            //add버튼을 누른 횟수
            beef_count++
            beef_count_tv.text=beef_count.toString()

        }

        beef_del_btn.setOnClickListener {

            if(beef_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                beef_sum -=20000
                beef_price_tv.text=beef_sum.toString()
                Sum(beef_sum)

                //del버튼을 누른 횟수
                beef_count--
                beef_count_tv.text=beef_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //세트 -> 양주세트
        liquor_add_btn.setOnClickListener {


            liquor_sum=130000 * (liquor_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            liquor_price_tv.text=liquor_sum.toString()

            Sum(liquor_sum)
            //add버튼을 누른 횟수
            liquor_count++
            liquor_count_tv.text=liquor_count.toString()



        }

        liquor_del_btn.setOnClickListener {

            if(liquor_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                liquor_sum -=130000
                liquor_price_tv.text=liquor_sum.toString()
                Sum(liquor_sum)

                //del버튼을 누른 횟수
                liquor_count--
                liquor_count_tv.text=liquor_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //어시스트 세트 -> 1명
        assist_one_add_btn.setOnClickListener {


            assist_one_sum=105000 * (assist_one_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            assist_one_price_tv.text=assist_one_sum.toString()

            Sum(assist_one_sum)
            //add버튼을 누른 횟수
            assist_one_count++
            assist_one_count_tv.text=assist_one_count.toString()


        }

        assist_one_del_btn.setOnClickListener {

            if(assist_one_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                assist_one_sum -=105000
                assist_one_price_tv.text=assist_one_sum.toString()
                Sum(assist_one_sum)

                //del버튼을 누른 횟수
                assist_one_count--
                assist_one_count_tv.text=assist_one_count.toString()



            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //어시스트 세트 -> 2명
        assist_two_add_btn.setOnClickListener {


            assist_two_sum=160000 * (assist_two_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            assist_two_price_tv.text=assist_two_sum.toString()

            Sum(assist_two_sum)
            //add버튼을 누른 횟수
            assist_two_count++
            assist_two_count_tv.text=assist_two_count.toString()



        }

        assist_two_del_btn.setOnClickListener {

            if(assist_two_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                assist_two_sum -=160000
                assist_two_price_tv.text=assist_two_sum.toString()
                Sum(assist_two_sum)

                //del버튼을 누른 횟수
                assist_two_count--
                assist_two_count_tv.text=assist_two_count.toString()




            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //어시스트 세트 -> 3명
        assist_three_add_btn.setOnClickListener {


            assist_three_sum=215000 * (assist_three_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            assist_three_price_tv.text=assist_three_sum.toString()

            Sum(assist_three_sum)
            //add버튼을 누른 횟수
            assist_three_count++
            assist_three_count_tv.text=assist_three_count.toString()



        }

        assist_three_del_btn.setOnClickListener {

            if(assist_three_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                assist_three_sum -=215000
                assist_three_price_tv.text=assist_three_sum.toString()
                Sum(assist_three_sum)

                //del버튼을 누른 횟수
                assist_three_count--
                assist_three_count_tv.text=assist_three_count.toString()




            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //어시스트 세트 -> 4명
        assist_for_add_btn.setOnClickListener {


            assist_for_sum=270000 * (assist_for_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            assist_for_price_tv.text=assist_for_sum.toString()

            Sum(assist_for_sum)
            //add버튼을 누른 횟수
            assist_for_count++
            assist_for_count_tv.text=assist_for_count.toString()



        }

        assist_for_del_btn.setOnClickListener {

            if(assist_for_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                assist_for_sum -=270000
                assist_for_price_tv.text=assist_for_sum.toString()
                Sum(assist_for_sum)

                //del버튼을 누른 횟수
                assist_for_count--
                assist_for_count_tv.text=assist_for_count.toString()




            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //어시스트 세트 -> 5명
        assist_five_add_btn.setOnClickListener {


            assist_five_sum=325000 * (assist_five_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            assist_five_price_tv.text=assist_five_sum.toString()
            Sum(assist_five_sum)

            //add버튼을 누른 횟수
            assist_five_count++
            assist_five_count_tv.text=assist_five_count.toString()



        }

        assist_five_del_btn.setOnClickListener {

            if(assist_five_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                assist_five_sum -=325000
                assist_five_price_tv.text=assist_five_sum.toString()
                Sum(assist_five_sum)

                //del버튼을 누른 횟수
                assist_five_count--
                assist_five_count_tv.text=assist_five_count.toString()




            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //어시스트만
        assist_add_btn.setOnClickListener {


            assist_sum=30000 * (assist_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            assist_price_tv.text=assist_sum.toString()

            Sum(assist_sum)
            //add버튼을 누른 횟수
            assist_count++
            assist_count_tv.text=assist_count.toString()



        }

        assist_del_btn.setOnClickListener {

            if(assist_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                assist_sum -=30000
                assist_price_tv.text=assist_sum.toString()
                Sum(assist_sum)

                //del버튼을 누른 횟수
                assist_count--
                assist_count_tv.text=assist_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }


        //어시스트and안주
        assist_snack_add_btn.setOnClickListener {


            assist_snack_sum=5000 * (assist_snack_count+1)
            //Log.d(TAG, "OrderSelect - ${sum}")

            assist_snack_price_tv.text=assist_snack_sum.toString()

            Sum(assist_snack_sum)
            //add버튼을 누른 횟수
            assist_snack_count++
            assist_snack_count_tv.text=assist_snack_count.toString()



        }

        assist_snack_del_btn.setOnClickListener {

            if(assist_snack_count > 0){
                // Log.d(TAG, "OrderSelect - ${count}")
                //값빼기
                assist_snack_sum -=5000
                assist_snack_price_tv.text=assist_snack_sum.toString()
                Sum(assist_snack_sum)

                //del버튼을 누른 횟수
                assist_snack_count--
                assist_snack_count_tv.text=assist_snack_count.toString()


            }else{
                Toast.makeText(this,"0 이하 입니다.", Toast.LENGTH_SHORT).show()
            }

        }

        //계산버튼
        price_next_One_btn.setOnClickListener {
            val total_One = Intent(this, RoomOne_Receipt::class.java)
            startActivity(total_One)
            finish()
        }





    }


    private fun Sum(total_One: Int) {
        var total_One: Int = 0
        total_One=(middle_sum+small_sum+Big_sum+soju_sum+can_sum+heaver_sum+drink_sum+fruit_sum+thin_sum+squid_sum+beef_sum+liquor_sum+assist_sum+assist_snack_sum+assist_one_sum+assist_two_sum+assist_three_sum+assist_for_sum+assist_five_sum)
        Log.d(TAG, "sum_One - ${total_One}")
        PreferenceUtil.setString("total_One", "총금액은 ${total_One} 원")
        Total_One_tv.text = total_One.toString()

    }


}