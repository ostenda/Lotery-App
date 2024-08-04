package com.example.loteryapp.navigation

sealed class Screen(val route: String) {
    object LotteryList : Screen("lotteryList")
    object LotteryDetail : Screen("lotteryDetail/{drawId}") {
        fun createRoute(drawId: String) = "lotteryDetail/$drawId"
    }
}