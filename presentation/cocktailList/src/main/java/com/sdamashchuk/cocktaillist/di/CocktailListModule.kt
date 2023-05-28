package com.sdamashchuk.cocktaillist.di

import com.sdamashchuk.cocktaillist.viewmodel.CocktailListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val cocktailListModule = module {
    viewModelOf(::CocktailListViewModel)
}