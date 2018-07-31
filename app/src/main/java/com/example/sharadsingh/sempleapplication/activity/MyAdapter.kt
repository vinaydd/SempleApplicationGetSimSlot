package com.example.sharadsingh.sempleapplication.activity

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sharadsingh.sempleapplication.R

class MyAdapter( val adapterlist: ArrayList<String>, val name: String) : RecyclerView.Adapter<MyAdapter.AcceptedBidViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcceptedBidViewHolder {

        val itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.accepted_bids_item, parent, false)
        return AcceptedBidViewHolder(itemView)
    }

    override fun getItemCount(): Int {
     return adapterlist.size
    }


    override fun onBindViewHolder(holder: AcceptedBidViewHolder, position: Int) {

        val  name = adapterlist.get(position)
        holder.headingTV.setText(name)


    }

    class AcceptedBidViewHolder(v: View) : RecyclerView.ViewHolder(v) {
       val headingTV: TextView


        init {
            headingTV = v.findViewById(R.id.textView2) as TextView

        }
    }
}
