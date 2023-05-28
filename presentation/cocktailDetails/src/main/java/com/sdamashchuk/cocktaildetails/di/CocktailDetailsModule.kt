package com.sdamashchuk.cocktaildetails.di

import com.sdamashchuk.cocktaildetails.viewmodel.CocktailDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val cocktailDetailsModule = module {
    viewModelOf(::CocktailDetailsViewModel)
}