package com.mukul.news.uk.test.presentation.detail

import androidx.compose.runtime.Stable
import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.utils.UiMessage

@Stable
sealed interface CoinDetailState {
    data class Success(val coin: Coin) : CoinDetailState
    data object Loading : CoinDetailState
    data class Error(val uiMessage: UiMessage) : CoinDetailState
}