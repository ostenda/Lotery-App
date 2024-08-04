package com.example.loteryapp.model


import com.example.loteryapp.data.Draw
import kotlin.random.Random

fun generateRandomTicket(): Draw {
    val numbers = List(6) { Random.nextInt(1, 60).toString() }
    val bonusBall = Random.nextInt(1, 20).toString()
    val drawId = "ticket-${Random.nextInt(1000, 9999)}" // Unique ID for the ticket
    val topPrize = 0L // Tickets don't have a top prize by default

    return Draw(
        id = drawId,
        drawDate = "2024-08-04", // Example date
        number1 = numbers[0],
        number2 = numbers[1],
        number3 = numbers[2],
        number4 = numbers[3],
        number5 = numbers[4],
        number6 = numbers[5],
        bonusBall = bonusBall,
        topPrize = topPrize
    )
}

fun isTicketWinning(ticket: Draw, winningDraws: List<Draw>): Boolean {
    return winningDraws.any { winningDraw ->
                ticket.number1 == winningDraw.number1 &&
                ticket.number2 == winningDraw.number2 &&
                ticket.number3 == winningDraw.number3 &&
                ticket.number4 == winningDraw.number4 &&
                ticket.number5 == winningDraw.number5 &&
                ticket.number6 == winningDraw.number6 &&
                ticket.bonusBall == winningDraw.bonusBall
    }
}