package com.sdamashchuk.domain.usecase;

import com.sdamashchuk.domain.repository.CocktailRepository
import com.sdamashchuk.domain.usecase.base.UseCase
import com.sdamashchuk.model.CocktailDetails
import kotlinx.coroutines.CoroutineDispatcher

class GetCocktailDetailsUseCase(
    private val cocktailRepository: CocktailRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<Int, CocktailDetails>(dispatcher) {

    override suspend fun execute(parameters: Int): Result<CocktailDetails> =
        try {
            val cocktailDetails = cocktailRepository.getCocktailDetails(parameters)
            Result.success(cocktailDetails)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

