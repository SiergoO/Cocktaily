package com.sdamashchuk.data.net.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetAlcoholicCocktailListResponseDTO(
    @SerialName("drinks") val drinks: List<CocktailItemDTO>
)
