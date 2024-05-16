package com.mukul.news.uk.test.data.network

import com.mukul.news.uk.test.common.NetworkConstants
import com.mukul.news.uk.test.data.network.model.CoinNetworkModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {
    @GET(NetworkConstants.COIN_PAPRIKA_FEED)
    suspend fun getCoins(): List<CoinNetworkModel>

    @GET(NetworkConstants.COIN_PAPRIKA_FEED_ID)
    suspend fun getCoin(@Path("id") id: String): CoinNetworkModel
}