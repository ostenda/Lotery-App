package com.example.loteryapp

import com.example.loteryapp.data.Draw
import com.example.loteryapp.model.generateRandomTicket
import com.example.loteryapp.model.isTicketWinning
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TicketGenerationTest {

    @Test
    fun `generateRandomTicket produces a valid ticket`() {
        val ticket = generateRandomTicket()
        assertTrue(ticket.number1.toInt() in 1..59)
        assertTrue(ticket.number2.toInt() in 1..59)
        assertTrue(ticket.number3.toInt() in 1..59)
        assertTrue(ticket.number4.toInt() in 1..59)
        assertTrue(ticket.number5.toInt() in 1..59)
        assertTrue(ticket.number6.toInt() in 1..59)
        assertTrue(ticket.bonusBall.toInt() in 1..19)
    }
}

class TicketWinningCheckTest {

    @Test
    fun `ticket is winning if it matches a winning draw`() {
        val winningDraw = Draw(
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
        val ticket = Draw(
            id = "ticket-1",
            drawDate = "2024-08-04",
            number1 = "2",
            number2 = "16",
            number3 = "23",
            number4 = "44",
            number5 = "47",
            number6 = "52",
            bonusBall = "14",
            topPrize = 0
        )
        val winningDraws = listOf(winningDraw)
        assertTrue(isTicketWinning(ticket, winningDraws))
    }

    @Test
    fun `ticket is not winning if it does not match any winning draw`() {
        val winningDraw = Draw(
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
        val ticket = Draw(
            id = "ticket-2",
            drawDate = "2024-08-04",
            number1 = "1",
            number2 = "15",
            number3 = "24",
            number4 = "45",
            number5 = "48",
            number6 = "53",
            bonusBall = "15",
            topPrize = 0
        )
        val winningDraws = listOf(winningDraw)
        assertFalse(isTicketWinning(ticket, winningDraws))
    }
}