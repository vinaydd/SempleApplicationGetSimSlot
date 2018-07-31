package com.example.sharadsingh.sempleapplication.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.example.sharadsingh.sempleapplication.R
import com.example.sharadsingh.sempleapplication.response.Baseresponce
import com.example.sharadsingh.sempleapplication.utills.Constants
import com.example.sharadsingh.sempleapplication.web_client.ManagerClass
import org.json.JSONObject

class Main2Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<View>(R.id.button3).setOnClickListener {
            val intent = Intent(this@Main2Activity, NewClass::class.java)
            startActivity(intent)
        }


        val jsonObject = JSONObject()
        jsonObject.put("username", "naaptol")
        jsonObject.put("password", "t1234")
        ManagerClass.instance.getLogin(this@Main2Activity, Constants.JSON_OBJECTS, Constants.POST_REQUEST, jsonObject, true)
    }


    override fun <T> processResponse(result: T?) {
        super.processResponse(result)
        if (result is Baseresponce) {
            val baseResponce = result as Baseresponce
            if (baseResponce.errorCode.equals("100")){
                Toast.makeText(this@Main2Activity,baseResponce.errorMesaage,Toast.LENGTH_LONG).show()
                val intent = Intent(this@Main2Activity, NewClass::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this@Main2Activity,baseResponce.errorMesaage,Toast.LENGTH_LONG).show()

            }


        }

    }


}
