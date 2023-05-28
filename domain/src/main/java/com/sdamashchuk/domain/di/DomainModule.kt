package com.sdamashchuk.domain.di

import com.sdamashchuk.domain.usecase.GetCocktailDetailsUseCase
import com.sdamashchuk.domain.usecase.GetCocktailListUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val useCaseModule = module {
    single { Dispatchers.IO }
    factory { GetCocktailListUseCase(get(), get()) }
    factory { GetCocktailDetailsUseCase(get(), get()) }
}

val domainModules = listOf(
    useCaseModule
)