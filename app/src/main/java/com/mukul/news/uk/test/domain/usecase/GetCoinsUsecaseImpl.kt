package com.mukul.news.uk.test.domain.usecase

import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.domain.repository.CoinRepository
import com.mukul.news.uk.test.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUsecaseImpl @Inject constructor(
    private val repository: CoinRepository
) : GetCoinsUsecase {
    override suspend fun invoke(force: Boolean): Flow<Result<List<Coin>>> {
        return flow {
            emit(Result.Loading())
            emit(repository.getCoins(force = force, sorted = true))
        }
    }
}