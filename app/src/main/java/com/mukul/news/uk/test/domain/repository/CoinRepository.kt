package com.mukul.news.uk.test.domain.repository

import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.utils.Result

interface CoinRepository {
    suspend fun getCoins(force: Boolean, sorted: Boolean): Result<List<Coin>>
    suspend fun getCoin(id: String, force: Boolean): Result<Coin>
}