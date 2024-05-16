package com.mukul.news.uk.test.data.network

import com.mukul.news.uk.test.data.network.model.CoinNetworkModel
import com.mukul.news.uk.test.utils.Result

interface CoinNetworkDataSource {
    suspend fun getCoins(): Result<List<CoinNetworkModel>>
    suspend fun getCoin(id: String): Result<CoinNetworkModel>
}