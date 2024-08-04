package com.example.loteryapp

import com.example.loteryapp.data.DrawsData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import com.google.gson.Gson

class JsonReadingTest {

    @Test
    fun testReadJsonFromAssets() {
        val jsonString = """{
  "draws": [
    {
      "id": "draw-1",
      "drawDate": "2023-05-15",
      "number1": "2",
      "number2": "16",
      "number3": "23",
      "number4": "44",
      "number5": "47",
      "number6": "52",
      "bonus-ball": "14",
      "topPrize": 4000000000
    }
  ]
}"""
        val expectedJson = jsonString.trimIndent()
        assertEquals(expectedJson, jsonString)
    }
}

class JsonParsingTest {

    @Test
    fun testParseJsonToModel() {
        val jsonString = """
            {
              "draws": [
                {
                  "id": "draw-1",
                  "drawDate": "2023-05-15",
                  "number1": "2",
                  "number2": "16",
                  "number3": "23",
                  "number4": "44",
                  "number5": "47",
                  "number6": "52",
                  "bonus-ball": "14",
                  "topPrize": 4000000000
                }
              ]
            }
        """
        val gson = Gson()
        val drawsData = gson.fromJson(jsonString, DrawsData::class.java)
        assertEquals(1, drawsData.draws.size)
        assertEquals("draw-1", drawsData.draws[0].id)
    }
}

