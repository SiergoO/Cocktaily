package com.sdamashchuk.data.di

import com.sdamashchuk.data.net.HttpClientFactory
import com.sdamashchuk.data.net.api.TheCocktailApi
import com.sdamashchuk.data.net.mapper.CocktailDetailsMapper
import com.sdamashchuk.data.net.mapper.CocktailItemMapper
import com.sdamashchuk.data.repository.CocktailRepositoryImpl
import com.sdamashchuk.domain.repository.CocktailRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val netModule = module {
    single { HttpClientFactory().createHttpClient(context = get()) }
    singleOf(::TheCocktailApi)
    singleOf(::CocktailItemMapper)
    singleOf(::CocktailDetailsMapper)
}

val repositoryModule = module {
    singleOf(::CocktailRepositoryImpl) { bind<CocktailRepository>() }
}

val dataModules = listOf(
    netModule,
    repositoryModule
)