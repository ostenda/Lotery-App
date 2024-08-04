package com.example.loteryapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.loteryapp.data.Draw

@Composable
fun LotteryDrawDetail(draw: Draw, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Draw Date: ${draw.drawDate}", style = MaterialTheme.typography.headlineLarge)
        Text(text = "Number 1: ${draw.number1}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Number 2: ${draw.number2}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Number 3: ${draw.number3}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Number 4: ${draw.number4}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Number 5: ${draw.number5}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Number 6: ${draw.number6}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Bonus Ball: ${draw.bonusBall}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Top Prize: ${draw.topPrize}", style = MaterialTheme.typography.bodyLarge)
    }
}