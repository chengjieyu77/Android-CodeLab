package com.example.a30daysapp.model

import androidx.annotation.DrawableRes

data class Day(
    val dayCount:Int,
    val todo:String,
    @DrawableRes val image:Int,
    val desc:String
)
