package com.mukul.news.uk.test.data.network

import com.mukul.news.uk.test.R
import com.mukul.news.uk.test.data.network.model.CoinNetworkModel
import com.mukul.news.uk.test.utils.Result
import com.mukul.news.uk.test.utils.UiMessage
import retrofit2.HttpException
import java.io.IOException

class CoinNetworkDataSourceImpl(
    private val api: CoinApi
) : CoinNetworkDataSource {
    override suspend fun getCoins(): Result<List<CoinNetworkModel>> {
        return try {
            val response = api.getCoins()
            Result.Success(data = response)
        } catch (e: HttpException) {
            Result.Error(message = UiMessage.ResourceType(R.string.network_error))
        } catch (e: IOException) {
            Result.Error(message = UiMessage.ResourceType(R.string.internet_error))
        }
    }

    override suspend fun getCoin(id: String): Result<CoinNetworkModel> {
        return try {
            val response = api.getCoin(id)
            Result.Success(data = response)
        } catch (e: HttpException) {
            Result.Error(message = UiMessage.ResourceType(R.string.network_error))
        } catch (e: IOException) {
            Result.Error(message = UiMessage.ResourceType(R.string.internet_error))
        }
    }
}