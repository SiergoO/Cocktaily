package com.sdamashchuk.cocktaildetails.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.sdamashchuk.common.base.BaseViewModel
import com.sdamashchuk.domain.usecase.GetCocktailDetailsUseCase
import com.sdamashchuk.model.CocktailDetails
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.collections.immutable.toPersistentMap
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class CocktailDetailsViewModel(
    private val getCocktailDetailsUseCase: GetCocktailDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CocktailDetailsViewModel.State, CocktailDetailsViewModel.SideEffect>(State()) {

    private val cocktailId: Int = checkNotNull(savedStateHandle["cocktailId"])

    init {
        viewModelScope.launch {
            getCocktailDetailsUseCase.invoke(cocktailId).onSuccess {
                intent {
                    reduce {
                        state.copy(
                            cocktailDetails = it.copy(
                                ingredients = it.ingredients.toPersistentMap()
                            ),
                            isLoading = false
                        )
                    }
                }
            }.onFailure {
                intent {
                    postSideEffect(SideEffect.ShowError(it.message))
                    reduce {
                        state.copy(
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    sealed class SideEffect {
        data class ShowError(val message: String?) : SideEffect()
    }

    data class State(
        val isLoading: Boolean = true,
        val cocktailDetails: CocktailDetails = CocktailDetails(),
    )
}