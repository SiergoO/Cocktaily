package com.sdamashchuk.model

data class CocktailDetails(
   val id: Int = 0,
   val name: String = "",
   val imageUrl: String = "",
   val category: String? = null,
   val alcoholic: String? = null,
   val strGlass: String? = null,
   val instruction: String? = null,
   val instructionES: String? = null,
   val instructionDE: String? = null,
   val instructionFR: String? = null,
   val instructionIT: String? = null,
   val instructionZHHans: String? = null,
   val instructionZHHant: String? = null,
   val ingredients: Map<String?, String?> = mapOf(),
   val creativeCommonsConfirmed: Boolean? = null,
   val dateModified: String? = null
)