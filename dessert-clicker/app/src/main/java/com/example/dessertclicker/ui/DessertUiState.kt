package com.example.dessertclicker.ui

import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert

data class DessertUiState(
    val currentDessert:Dessert = Datasource.dessertList[0],
    val currentDessertProductionIndex:Int,
    val totalDessertsSold:Int = 0,
    val totalRevenue:Int = 0
)
