package com.mukul.news.uk.test.presentation.list

import androidx.compose.runtime.Stable
import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.utils.UiMessage

@Stable
sealed interface CoinListState {
    data class Success(val coins: List<Coin>) : CoinListState
    data object Loading : CoinListState
    data class Error(val uiMessage: UiMessage) : CoinListState
}