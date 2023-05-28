package com.sdamashchuk.data.net.api

import com.sdamashchuk.data.net.dto.CocktailItemDTO
import com.sdamashchuk.data.net.dto.GetAlcoholicCocktailListResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TheCocktailApi(private val httpClient: HttpClient) {

    companion object {
        private const val BASE_URL = "https://thecocktaildb.com/api/json/v1/1/"
    }

    suspend fun getAlcoholicCocktailList(): List<CocktailItemDTO> = httpClient
        .get("${BASE_URL}filter.php?a=Alcoholic")
        .body<GetAlcoholicCocktailListResponseDTO>()
        .drinks
}
