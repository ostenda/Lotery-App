package com.example.loteryapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.loteryapp.data.Draw
import com.example.loteryapp.data.DrawsData
import com.example.loteryapp.model.generateRandomTicket
import com.example.loteryapp.navigation.Screen
import com.example.loteryapp.screens.LotteryDrawDetail
import com.example.loteryapp.screens.LotteryDrawItem
import com.example.loteryapp.screens.LotteryDrawList
import com.example.loteryapp.screens.TicketItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNavigation() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screen.LotteryList.route) {
                composable(Screen.LotteryList.route) {
                    val drawsData = DrawsData(draws = listOf(
                        Draw(
                            id = "draw-1",
                            drawDate = "2023-05-15",
                            number1 = "2",
                            number2 = "16",
                            number3 = "23",
                            number4 = "44",
                            number5 = "47",
                            number6 = "52",
                            bonusBall = "14",
                            topPrize = 4000000000
                        )
                    ))
                    LotteryDrawList(navController, drawsData)
                }
                composable(Screen.LotteryDetail.route) { backStackEntry ->
                    val drawId = backStackEntry.arguments?.getString("drawId")
                    val draw = DrawsData(draws = listOf(
                        Draw(
                            id = "draw-1",
                            drawDate = "2023-05-15",
                            number1 = "2",
                            number2 = "16",
                            number3 = "23",
                            number4 = "44",
                            number5 = "47",
                            number6 = "52",
                            bonusBall = "14",
                            topPrize = 4000000000
                        )
                    )).draws.find { it.id == drawId }
                    draw?.let {
                        LotteryDrawDetail(draw = it)
                    }
                }
            }
        }

        // Navigate to Lottery Detail
        composeTestRule.onNodeWithText("Draw ID: draw-1").performClick()
        composeTestRule.onNodeWithText("Draw Date: 2023-05-15").assertExists()
    }
}

@RunWith(AndroidJUnit4::class)
class ComposableTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLotteryDrawItem() {
        val draw = Draw(
            id = "draw-1",
            drawDate = "2023-05-15",
            number1 = "2",
            number2 = "16",
            number3 = "23",
            number4 = "44",
            number5 = "47",
            number6 = "52",
            bonusBall = "14",
            topPrize = 4000000000
        )

        composeTestRule.setContent {
            LotteryDrawItem(draw = draw, onClick = {})
        }

        composeTestRule.onNodeWithText("Draw Date: 2023-05-15").assertExists()
        composeTestRule.onNodeWithText("Draw ID: draw-1").assertExists()
    }

    @Test
    fun testTicketItem() {
        val ticket = generateRandomTicket()
        val winningDraws = listOf<Draw>()

        composeTestRule.setContent {
            TicketItem(ticket = ticket, winningDraws = winningDraws)
        }

        composeTestRule.onNodeWithText("Ticket ID: ${ticket.id}").assertExists()
        composeTestRule.onNodeWithText("Draw Date: ${ticket.drawDate}").assertExists()
    }
}
