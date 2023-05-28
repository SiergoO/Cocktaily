package com.sdamashchuk.domain.usecase

import com.sdamashchuk.domain.repository.CocktailRepository
import com.sdamashchuk.domain.usecase.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetCocktailListUseCase(
    private val cocktailRepository: CocktailRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Unit, String>(dispatcher) {

    override suspend fun execute(parameters: Unit): Result<String> =
        try {
            val cocktailList = cocktailRepository.getCocktailList()
            Result.success(cocktailList)
        } catch (t: Throwable) {
            Result.failure(t)
        }
}