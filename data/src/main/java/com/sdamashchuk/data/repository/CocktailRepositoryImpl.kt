package com.sdamashchuk.data.repository

import com.sdamashchuk.data.net.NetworkChecker
import com.sdamashchuk.data.net.api.TheCocktailApi
import com.sdamashchuk.data.net.mapper.CocktailDetailsMapper
import com.sdamashchuk.data.net.mapper.CocktailItemMapper
import com.sdamashchuk.domain.repository.CocktailRepository
import com.sdamashchuk.model.CocktailDetails
import com.sdamashchuk.model.CocktailItem

class CocktailRepositoryImpl(
    private val theCocktailApi: TheCocktailApi,
    private val networkChecker: NetworkChecker,
    private val cocktailItemMapper: CocktailItemMapper,
    private val cocktailDetailsMapper: CocktailDetailsMapper
) : CocktailRepository {

    override suspend fun isConnected(): Boolean = networkChecker.isConnected

    override suspend fun getAlcoholicCocktailList(): List<CocktailItem> =
        theCocktailApi.getAlcoholicCocktailList().let { cocktailItemMapper.transformCollection(it) }

    override suspend fun getCocktailDetails(cocktailId: Int): CocktailDetails =
        theCocktailApi.getCocktailDetailsById(cocktailId).let { cocktailDetailsMapper.transform(it) }
}