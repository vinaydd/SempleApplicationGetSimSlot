package com.example.sharadsingh.sempleapplication.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SubscriptionInfo
import android.telephony.SubscriptionManager
import android.text.Html
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.androidnetworking.AndroidNetworking.head
import com.example.sharadsingh.sempleapplication.R
import com.example.sharadsingh.sempleapplication.model.ListModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList




class MainActivity : AppCompatActivity() {
    var isMultiSimEnabled = false
    lateinit var subInfoList: List<SubscriptionInfo>
    lateinit var numbers: ArrayList<String>
    lateinit var  modelList: ArrayList<ListModel>
    private var subscriptionManager: SubscriptionManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            subscriptionManager = this.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager
        }
        getTosetOnformation();
        val  button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){

            val intent1 = Intent(this@MainActivity, NewClass::class.java)
            intent1.putExtra("shitch", "allordertrip")
            intent1.putExtra("vin_data", "data")
            startActivity(intent1)
        }




    }
    private fun getTosetOnformation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            getClientPhoneNumber()
        }

    }

    private fun getClientPhoneNumber() {
        var numbers = ArrayList<String>()
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                subInfoList = subscriptionManager!!.getActiveSubscriptionInfoList()
            }
            if (subInfoList.size > 1) {
                isMultiSimEnabled = true
            }
            modelList = ArrayList<ListModel>()
            for (subscriptionInfo in subInfoList) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                    numbers.add(subscriptionInfo.getNumber())
                    val model = ListModel()
                    model.slot = (subscriptionInfo.simSlotIndex+1).toString()
                    model.cardNumber = subscriptionInfo.iccId
                    model.mobailenumber = subscriptionInfo.number
                    model.operator = subscriptionInfo.displayName as String?
                    model.county = subscriptionInfo.countryIso
                    model.image = subscriptionInfo.createIconBitmap(this)
                    modelList.add(model)
                }
            }
            showValues(modelList);
        } catch (e: Exception) {
            Log.d("", e.toString())
        }
    }

    private fun showValues(numbers: ArrayList<ListModel>) {
         val  simslotOne= findViewById<TextView>(R.id.textView9)
         val  simOne_operator= findViewById<TextView>(R.id.textView10)
        val  sim_one_country= findViewById<TextView>(R.id.textView11)
        val  simOne_cardno= findViewById<TextView>(R.id.textView12)
        val sim_one_image = findViewById<ImageView>(R.id.imageView2)
        val  sim2slotOne= findViewById<TextView>(R.id.textView5)
        val  sim2_one_name= findViewById<TextView>(R.id.textView6)
        val  sim2_one_country= findViewById<TextView>(R.id.textView7)
        val  sim2One_cartdd= findViewById<TextView>(R.id.textView8)
        val sim2_one_image = findViewById(R.id.imageView3)as ImageView
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        val li = findViewById<LinearLayout>(R.id.li)

        if(numbers !=null && numbers.size>0){
            simslotOne.setText("Slot Number: "+numbers.get(0).slot)
            simOne_operator.setText("Operator: "+numbers.get(0).operator)
            simOne_cardno.setText("Card No: "+numbers.get(0).cardNumber)
            sim_one_country.setText("Country Name: "+numbers.get(0).county)
            sim_one_image.setImageBitmap(numbers.get(0).image)


        }
        if(numbers !=null && numbers.size>0 && numbers.size==2) {
            sim2slotOne.setText("Slot Number: " + numbers.get(1).slot)
            sim2_one_name.setText("Operator: " + numbers.get(1).operator)
            sim2One_cartdd.setText("Card No: " + numbers.get(1).cardNumber)
            sim2_one_country.setText("Country Name: " + numbers.get(1).county)
            sim2_one_image.setImageBitmap(numbers.get(1).image)
        }

    }


}
