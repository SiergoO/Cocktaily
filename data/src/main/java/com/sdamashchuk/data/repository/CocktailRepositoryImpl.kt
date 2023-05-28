package com.sdamashchuk.data.repository

import com.sdamashchuk.data.net.NetworkChecker
import com.sdamashchuk.data.net.api.TheCocktailApi
import com.sdamashchuk.data.net.mapper.CocktailItemMapper
import com.sdamashchuk.domain.repository.CocktailRepository
import com.sdamashchuk.model.CocktailItem
import kotlinx.coroutines.delay

class CocktailRepositoryImpl(
    private val theCocktailApi: TheCocktailApi,
    private val networkChecker: NetworkChecker,
    private val cocktailItemMapper: CocktailItemMapper,
): CocktailRepository {

    override suspend fun isConnected(): Boolean = networkChecker.isConnected

    override suspend fun getAlcoholicCocktailList(): List<CocktailItem> {
        return theCocktailApi.getAlcoholicCocktailList().let { cocktailItemMapper.transformCollection(it?: listOf()) }
    }

    override suspend fun getCocktailDetails(): String {
        delay(2000)
        return "Details"
    }
}