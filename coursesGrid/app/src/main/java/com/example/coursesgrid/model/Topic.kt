package com.example.coursesgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val name:Int,
   val count:Int,
    @DrawableRes val imageSrc:Int
)