package com.sdamashchuk.cocktaildetails.viewmodel

import androidx.lifecycle.viewModelScope
import com.sdamashchuk.common.base.BaseViewModel
import com.sdamashchuk.domain.usecase.GetCocktailDetailsUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class CocktailDetailsViewModel(
    private val getCocktailDetailsUseCase: GetCocktailDetailsUseCase
) : BaseViewModel<CocktailDetailsViewModel.State, CocktailDetailsViewModel.SideEffect>(State()) {

    init {
        viewModelScope.launch {
            getCocktailDetailsUseCase.invoke(Unit).onSuccess {
                intent {
                    reduce { state.copy(title = it) }
                }
            }
        }
    }

    fun sendAction(action: Action) {
    }

    sealed class SideEffect {
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed class Action {

    }

    data class State(
        val title: String = "",
    )
}