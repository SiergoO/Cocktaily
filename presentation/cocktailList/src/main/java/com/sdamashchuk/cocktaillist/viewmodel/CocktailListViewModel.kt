package com.sdamashchuk.cocktaillist.viewmodel

import androidx.lifecycle.viewModelScope
import com.sdamashchuk.common.base.BaseViewModel
import com.sdamashchuk.domain.usecase.GetCocktailListUseCase
import com.sdamashchuk.model.CocktailItem
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
                    reduce { state.copy(cocktails = it) }
                }
            }.onFailure {
                intent {
                    postSideEffect(SideEffect.ShowError(it.message))
                }
            }
        }
    }

    fun sendAction(action: Action) {
        when (action) {
            is Action.CocktailClicked -> {
                intent {
                    postSideEffect(SideEffect.NavigateToCocktailDetails(action.cocktailId))
                }
            }
        }
    }

    sealed class SideEffect {
        data class NavigateToCocktailDetails(val cocktailId: Int) : SideEffect()
        data class ShowError(val message: String?) : SideEffect()
    }

    sealed class Action {
        data class CocktailClicked(val cocktailId: Int) : Action()
    }

    data class State(
        val cocktails: List<CocktailItem> = listOf(),
    )
}