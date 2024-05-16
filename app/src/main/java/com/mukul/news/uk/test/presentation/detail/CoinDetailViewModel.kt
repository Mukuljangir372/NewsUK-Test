package com.mukul.news.uk.test.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mukul.news.uk.test.domain.usecase.GetCoinUsecase
import com.mukul.news.uk.test.domain.usecase.GetCoinsUsecase
import com.mukul.news.uk.test.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUsecase: GetCoinUsecase
) : ViewModel() {
    private val _state = MutableStateFlow<CoinDetailState>(CoinDetailState.Loading)
    val state: StateFlow<CoinDetailState> = _state

    fun load(id: String) {
        loadCoin(id = id)
    }

    private var loadCoinJob: Job? = null
    private fun loadCoin(id: String) {
        loadCoinJob?.cancel()
        loadCoinJob = viewModelScope.launch {
            getCoinUsecase(id = id, force = false).collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _state.update { CoinDetailState.Loading }
                    }

                    is Result.Success -> {
                        _state.update { CoinDetailState.Success(result.data) }
                    }

                    is Result.Error -> {
                        _state.update { CoinDetailState.Error(result.message) }
                    }
                }
            }
        }
    }
}