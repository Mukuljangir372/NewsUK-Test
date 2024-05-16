package com.mukul.news.uk.test.data.mapper

import com.mukul.news.uk.test.data.local.model.CoinLocalModel
import com.mukul.news.uk.test.data.local.model.CoinTagLocalModel
import com.mukul.news.uk.test.data.network.model.CoinNetworkModel
import com.mukul.news.uk.test.data.network.model.CoinTagNetworkModel
import com.mukul.news.uk.test.domain.model.Coin
import com.mukul.news.uk.test.domain.model.CoinTag

interface CoinModelMapper {
    fun localToDomain(local: CoinLocalModel): Coin
    fun networkToDomain(network: CoinNetworkModel): Coin
    fun domainToLocal(domain: Coin): CoinLocalModel

    fun localTagToDomain(local: CoinTagLocalModel): CoinTag
    fun networkTagToDomain(network: CoinTagNetworkModel): CoinTag
    fun domainTagToLocal(domain: CoinTag): CoinTagLocalModel
}