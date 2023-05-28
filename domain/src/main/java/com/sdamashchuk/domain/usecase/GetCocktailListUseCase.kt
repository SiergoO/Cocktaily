package com.sdamashchuk.domain.usecase

import com.sdamashchuk.domain.repository.CocktailRepository
import com.sdamashchuk.domain.usecase.base.UseCase
import com.sdamashchuk.model.CocktailItem
import kotlinx.coroutines.CoroutineDispatcher

class GetCocktailListUseCase(
    private val cocktailRepository: CocktailRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, List<CocktailItem>>(dispatcher) {

    override suspend fun execute(parameters: Unit): Result<List<CocktailItem>> =
        try {
            val alcoholicCocktailList = cocktailRepository.getAlcoholicCocktailList()
            Result.success(alcoholicCocktailList)
        } catch (t: Throwable) {
            Result.failure(t)
        }
}