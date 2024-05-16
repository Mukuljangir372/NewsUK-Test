package com.mukul.news.uk.test.domain.usecase

import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.domain.repository.CoinRepository
import com.mukul.news.uk.test.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUsecaseImpl @Inject constructor(
    private val repository: CoinRepository
) : GetCoinUsecase {
    override suspend fun invoke(id: String, force: Boolean): Flow<Result<Coin>> {
        return flow {
            emit(Result.Loading())
            emit(repository.getCoin(id, force))
        }
    }
}