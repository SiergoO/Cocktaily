package com.sdamashchuk.domain.repository

import com.sdamashchuk.model.CocktailDetails
import com.sdamashchuk.model.CocktailItem

interface CocktailRepository {

    suspend fun getAlcoholicCocktailList(): List<CocktailItem>

    suspend fun getCocktailDetails(cocktailId: Int): CocktailDetails
}