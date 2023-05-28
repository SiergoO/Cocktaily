package com.sdamashchuk.domain.repository

import com.sdamashchuk.model.CocktailItem

interface CocktailRepository {

    suspend fun isConnected(): Boolean

    suspend fun getAlcoholicCocktailList(): List<CocktailItem>

    suspend fun getCocktailDetails(): String
}