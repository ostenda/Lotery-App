package com.example.loteryapp.data

import com.google.gson.annotations.SerializedName

data class Draw(
    val id: String,
    val drawDate: String,
    val number1: String,
    val number2: String,
    val number3: String,
    val number4: String,
    val number5: String,
    val number6: String,
    @SerializedName("bonus-ball") val bonusBall: String,
    val topPrize: Long
)

data class DrawsData(
    val draws: List<Draw>
)
