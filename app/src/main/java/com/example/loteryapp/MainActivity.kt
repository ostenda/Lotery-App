package com.example.loteryapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.loteryapp.data.DrawsData
import com.example.loteryapp.navigation.SetupNavGraph
import com.example.loteryapp.ui.theme.LoteryAppTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val jsonString = readJsonFromAssets(this, "data.json")
            val lotteryData = parseJsonToModel(jsonString)

            LoteryAppTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavGraph(navController = navController, lotteryData = lotteryData)
                }
            }
        }
    }

    private fun readJsonFromAssets(context: Context, data: String): String {
        return context.assets.open(data).bufferedReader().use { it.readText() }
    }

    private fun parseJsonToModel(jsonString: String): DrawsData {
        val gson = Gson()
        return gson.fromJson(jsonString, DrawsData::class.java)
    }
}













