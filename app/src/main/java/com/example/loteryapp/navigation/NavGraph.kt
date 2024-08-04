package com.example.loteryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.loteryapp.data.DrawsData
import com.example.loteryapp.screens.LotteryDrawDetail
import com.example.loteryapp.screens.LotteryDrawList


@Composable
fun SetupNavGraph(navController: NavHostController, lotteryData: DrawsData) {
    NavHost(
        navController = navController,
        startDestination = Screen.LotteryList.route
    ) {
        composable(Screen.LotteryList.route) {
            LotteryDrawList(navController, lotteryData)
        }
        composable(Screen.LotteryDetail.route) { backStackEntry ->
            val drawId = backStackEntry.arguments?.getString("drawId")
            val draw = lotteryData.draws.find { it.id == drawId }
            draw?.let {
                LotteryDrawDetail(draw = it)
            }
        }
    }
}

