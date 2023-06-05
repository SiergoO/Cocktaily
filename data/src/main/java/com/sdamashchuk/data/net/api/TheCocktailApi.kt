package com.sdamashchuk.data.net.api

import com.sdamashchuk.data.net.dto.CocktailDetailsDTO
import com.sdamashchuk.data.net.dto.CocktailItemDTO
import com.sdamashchuk.data.net.dto.GetCocktailDetailsResponseDTO
import com.sdamashchuk.data.net.dto.GetCocktailListResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class TheCocktailApi(private val httpClient: HttpClient) {

    suspend fun getAlcoholicCocktailList(): List<CocktailItemDTO> = httpClient
        .get("${BASE_URL}/filter.php"){
            parameter("a", "Alcoholic")
        }
        .body<GetCocktailListResponseDTO>()
        .drinks

    suspend fun getCocktailDetailsById(cocktailId: Int): CocktailDetailsDTO = httpClient
        .get("${BASE_URL}/lookup.php") {
            parameter("i", cocktailId)
        }
        .body<GetCocktailDetailsResponseDTO>()
        .drinks
        .first()

    companion object {
        private const val BASE_URL = "https://thecocktaildb.com/api/json/v1/1"
    }
}
