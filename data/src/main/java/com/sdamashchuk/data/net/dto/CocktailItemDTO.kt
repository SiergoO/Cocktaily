package com.sdamashchuk.data.net.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CocktailItemDTO(
    @SerialName("strDrink") val strDrink: String,
    @SerialName("strDrinkThumb") val strDrinkThumb: String,
    @SerialName("idDrink") val idDrink: String
)