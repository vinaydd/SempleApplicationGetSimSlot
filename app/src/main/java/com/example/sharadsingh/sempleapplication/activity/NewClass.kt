package com.example.sharadsingh.sempleapplication.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.example.sharadsingh.sempleapplication.R

class NewClass : AppCompatActivity() {


    var adapterlist : ArrayList<String> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_file)
        val svd = intent
        if(svd !=null){
            var name = svd.getStringExtra("shitch")
            var valued = svd.getStringExtra("vin_data")
            Toast.makeText(this@NewClass, name+valued, Toast.LENGTH_SHORT).show()
        }
        val button = findViewById<Button>(R.id.button2)
        adapterlist = this.getAlldata()
        Log.d("list_size",adapterlist.size.toString())
        val recycleListview = findViewById<RecyclerView>(R.id.list)
        recycleListview.layoutManager =  LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        recycleListview.adapter= MyAdapter(adapterlist, "vinay");
        button.setOnClickListener(){
            try {

               // showDialogeFormessage();
             val  iedwdfw = Intent(this@NewClass,Main2Activity::class.java)
                startActivity(iedwdfw)
            }catch (e: Exception){
                e.message
            }
        }

    }




    private fun getAlldata(): ArrayList<String> {

        adapterlist.add("vinay")
        adapterlist.add("singh")
        adapterlist.add("himalaya")
        adapterlist.add("singh")
        adapterlist.add("rahul")
        adapterlist.add("singh")

        return adapterlist

    }

    private fun showDialogeFormessage() {

        val  dilog = Dialog(this)
        dilog.setContentView(R.layout.activity_main)
        dilog.show()
    }


}