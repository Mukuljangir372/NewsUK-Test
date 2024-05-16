package com.mukul.news.uk.test.domain.usecase

import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.utils.Result
import kotlinx.coroutines.flow.Flow

interface GetCoinUsecase {
    suspend operator fun invoke(id: String, force: Boolean): Flow<Result<Coin>>
}