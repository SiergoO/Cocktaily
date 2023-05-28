package com.sdamashchuk.data.net.mapper

import com.sdamashchuk.data.net.dto.CocktailDetailsDTO
import com.sdamashchuk.model.CocktailDetails

class CocktailDetailsMapper {

    fun transform(cocktailDetailsDTO: CocktailDetailsDTO): CocktailDetails = with(cocktailDetailsDTO) {
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
            ingredient1 = strIngredient1,
            ingredient2 = strIngredient2,
            ingredient3 = strIngredient3,
            ingredient4 = strIngredient4,
            ingredient5 = strIngredient5,
            ingredient6 = strIngredient6,
            ingredient7 = strIngredient7,
            ingredient8 = strIngredient8,
            ingredient9 = strIngredient9,
            ingredient10 = strIngredient10,
            ingredient11 = strIngredient11,
            ingredient12 = strIngredient12,
            ingredient13 = strIngredient13,
            ingredient14 = strIngredient14,
            ingredient15 = strIngredient15,
            measure1 = strMeasure1,
            measure2 = strMeasure2,
            measure3 = strMeasure3,
            measure4 = strMeasure4,
            measure5 = strMeasure5,
            measure6 = strMeasure6,
            measure7 = strMeasure7,
            measure8 = strMeasure8,
            measure9 = strMeasure9,
            measure10 = strMeasure10,
            measure11 = strMeasure11,
            measure12 = strMeasure12,
            measure13 = strMeasure13,
            measure14 = strMeasure14,
            measure15 = strMeasure15,
            creativeCommonsConfirmed = strCreativeCommonsConfirmed.toBoolean(),
            dateModified = dateModified
        )
    }

    fun transformCollection(cocktailDetailsDTOList: List<CocktailDetailsDTO>): List<CocktailDetails> =
        cocktailDetailsDTOList.map { transform(it) }
}