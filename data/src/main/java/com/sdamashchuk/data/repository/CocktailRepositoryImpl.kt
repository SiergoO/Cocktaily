package com.sdamashchuk.data.repository

import com.sdamashchuk.domain.repository.CocktailRepository
import kotlinx.coroutines.delay

class CocktailRepositoryImpl: CocktailRepository {

    override suspend fun getCocktailList(): String {
        delay(2000)
        return "Cocktails"
    }

    override suspend fun getCocktailDetails(): String {
        delay(2000)
        return "Details"
    }
}