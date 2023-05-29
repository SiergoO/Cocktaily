package com.sdamashchuk.data.net.mapper

import com.sdamashchuk.data.net.dto.CocktailDetailsDTO
import com.sdamashchuk.model.CocktailDetails

class CocktailDetailsMapper {

    fun transform(cocktailDetailsDTO: CocktailDetailsDTO): CocktailDetails = with(cocktailDetailsDTO) {
        val ingredients = mutableMapOf<String, String>()

        for (i in 1..15) {
            val ingredient = getFieldValue("strIngredient$i")
            val measure = getFieldValue("strMeasure$i")

            if (!ingredient.isNullOrEmpty()) {
                ingredients[ingredient] = measure ?: ""
            }
        }

        CocktailDetails(
            id = idDrink.toIntOrNull() ?: 0,
            name = strDrink,
            imageUrl = strDrinkThumb,
            category = strCategory,
            alcoholic = strAlcoholic,
            strGlass = strGlass,
            instruction = strInstructions,
            instructionES = strInstructionsES,
            instructionDE = strInstructionsDE,
            instructionFR = strInstructionsFR,
            instructionIT = strInstructionsIT,
            instructionZHHans = strInstructionZHHans,
            instructionZHHant = strInstructionZHHant,
            ingredients = ingredients.toMap(),
            creativeCommonsConfirmed = strCreativeCommonsConfirmed != "Yes",
            dateModified = dateModified
        )
    }

    fun transformCollection(cocktailDetailsDTOList: List<CocktailDetailsDTO>): List<CocktailDetails> =
        cocktailDetailsDTOList.map { transform(it) }

    private fun CocktailDetailsDTO.getFieldValue(fieldName: String): String? {
        val property = this::class.members.find { it.name == fieldName }
        return (property?.call(this) as? String)?.takeIf { it.isNotBlank() }
    }
}