package com.sdamashchuk.data.di

import com.sdamashchuk.data.repository.CocktailRepositoryImpl
import com.sdamashchuk.domain.repository.CocktailRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::CocktailRepositoryImpl) { bind<CocktailRepository>() }
}

val dataModules = listOf(
    repositoryModule
)