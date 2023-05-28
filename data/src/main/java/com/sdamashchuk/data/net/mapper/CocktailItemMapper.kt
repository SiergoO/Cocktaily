package com.sdamashchuk.data.net.mapper

import com.sdamashchuk.data.net.dto.CocktailItemDTO
import com.sdamashchuk.model.CocktailItem

class CocktailItemMapper {

    fun transform(cocktailItemDTO: CocktailItemDTO): CocktailItem = with(cocktailItemDTO) {
        CocktailItem(
            id = idDrink.toIntOrNull() ?: 0,
            name = strDrink,
            imageUrl = strDrinkThumb
        )
    }

    fun transformCollection(cocktailItemDTOList: List<CocktailItemDTO>): List<CocktailItem> =
        cocktailItemDTOList.map { this.transform(it) }
}
