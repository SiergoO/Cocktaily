package com.sdamashchuk.cocktaillist.viewmodel

import androidx.lifecycle.viewModelScope
import com.sdamashchuk.common.base.BaseViewModel
import com.sdamashchuk.domain.usecase.GetCocktailListUseCase
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class CocktailListViewModel(
    private val getCocktailListUseCase: GetCocktailListUseCase
) : BaseViewModel<CocktailListViewModel.State, CocktailListViewModel.SideEffect>(State()) {

    init {
        viewModelScope.launch {
            getCocktailListUseCase.invoke(Unit).onSuccess {
                intent {
                    reduce { state.copy(title = it) }
                }
            }
        }
    }

    fun sendAction(action: Action) {
        when (action) {
            is Action.CocktailClicked -> {
                intent {
                    postSideEffect(SideEffect.NavigateToCocktailDetails)
                }
            }
        }
    }

    sealed class SideEffect {
        object NavigateToCocktailDetails : SideEffect()
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed class Action {
        object CocktailClicked : Action()
    }

    data class State(
        val title: String = "",
    )
}