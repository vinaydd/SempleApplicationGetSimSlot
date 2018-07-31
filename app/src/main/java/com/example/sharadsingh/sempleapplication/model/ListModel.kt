package com.example.sharadsingh.sempleapplication.model

import android.graphics.Bitmap

import java.io.Serializable

class ListModel : Serializable {
    var slot: String? = null
    var operator: String? = null
    var county: String? = null
    var cardNumber: String? = null
    var mobailenumber: String? = null
    var image: Bitmap? = null
}
