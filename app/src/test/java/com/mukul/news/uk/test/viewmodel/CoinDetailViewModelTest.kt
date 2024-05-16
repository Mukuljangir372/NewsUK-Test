package com.mukul.news.uk.test.viewmodel

import com.google.common.truth.Truth.assertThat
import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.domain.usecase.GetCoinUsecase
import com.mukul.news.uk.test.presentation.detail.CoinDetailState
import com.mukul.news.uk.test.presentation.detail.CoinDetailViewModel
import com.mukul.news.uk.test.utils.MainCoroutineRule
import com.mukul.news.uk.test.utils.Result
import com.mukul.news.uk.test.utils.UiMessage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class CoinDetailViewModelTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private val getCoinUsecase: GetCoinUsecase = mock(GetCoinUsecase::class.java)

    private val sut = CoinDetailViewModel(
        getCoinUsecase = getCoinUsecase
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given_loading_when_get_coin_then_returns_loading_state`() = runTest {
        val flow = flow<Result<Coin>> { emit(Result.Loading()) }
        given(getCoinUsecase(id = coin.id, force = true)).willReturn(flow)

        sut.load(id = coin.id)
        advanceUntilIdle()

        assertThat(sut.state.value).isEqualTo(CoinDetailState.Loading)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given_success_when_get_coin_then_returns_success_state`() = runTest {
        val flow = flow<Result<Coin>> { emit(Result.Success(coin)) }
        given(getCoinUsecase(id = coin.id, force = true)).willReturn(flow)

        sut.load(id = coin.id)
        advanceUntilIdle()

        assertThat(sut.state.value).isEqualTo(CoinDetailState.Success(coin))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `given_failure_when_get_coin_then_returns_failure_state`() = runTest {
        val error = Result.Error<Coin>(UiMessage.StringType("Error"))
        val flow = flow<Result<Coin>> { emit(error) }
        given(getCoinUsecase(id = coin.id, force = true)).willReturn(flow)

        sut.load(id = coin.id)
        advanceUntilIdle()

        assertThat(sut.state.value).isEqualTo(CoinDetailState.Error(error.message))
    }

    companion object {
        private val coin = Coin(
            id = "btc",
            name = "Bitcoin",
            symbol = "Btc",
            logo = "https://www.bitcoin.com",
            tags = listOf(),
            description = "Bitcoin Internet"
        )
    }
}