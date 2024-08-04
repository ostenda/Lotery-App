package com.example.loteryapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.loteryapp.data.Draw
import com.example.loteryapp.data.DrawsData
import com.example.loteryapp.model.generateRandomTicket
import com.example.loteryapp.model.isTicketWinning
import com.example.loteryapp.navigation.Screen



@Composable
fun LotteryDrawList(
    navController: NavHostController,
    drawsData: DrawsData,
    modifier: Modifier = Modifier
) {
    val tickets = List(5) { generateRandomTicket() } // Generate 5 random tickets

    LazyColumn(modifier = modifier) {
        item {
            Text(
                text = "Lottery Draws",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(drawsData.draws) { draw ->
            LotteryDrawItem(draw = draw, onClick = {
                navController.navigate(Screen.LotteryDetail.createRoute(draw.id))
            })
        }

        item {
            Text(
                text = "Generated Tickets",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(tickets) { ticket ->
            TicketItem(ticket = ticket, winningDraws = drawsData.draws)
        }
    }
}

@Composable
fun LotteryDrawItem(draw: Draw, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(text = "Draw Date: ${draw.drawDate}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Draw ID: ${draw.id}", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun TicketItem(ticket: Draw, winningDraws: List<Draw>, modifier: Modifier = Modifier) {
    val hasWon = isTicketWinning(ticket, winningDraws)

    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Text(text = "Ticket ID: ${ticket.id}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Draw Date: ${ticket.drawDate}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Numbers: ${ticket.number1}, ${ticket.number2}, ${ticket.number3}, ${ticket.number4}, ${ticket.number5}, ${ticket.number6}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Bonus Ball: ${ticket.bonusBall}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Status: ${if (hasWon) "Won" else "Not Won"}", style = MaterialTheme.typography.bodyLarge)
    }
}