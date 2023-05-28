package com.sdamashchuk.domain.repository

interface CocktailRepository {

    suspend fun getCocktailList(): String

    suspend fun getCocktailDetails(): String
}