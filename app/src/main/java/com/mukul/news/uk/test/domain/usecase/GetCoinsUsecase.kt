package com.mukul.news.uk.test.domain.usecase

import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.utils.Result
import kotlinx.coroutines.flow.Flow

interface GetCoinsUsecase {
    suspend operator fun invoke(force: Boolean): Flow<Result<List<Coin>>>
}