package com.mukul.news.uk.test.data.di

import com.mukul.news.uk.test.data.local.CoinLocalDataSource
import com.mukul.news.uk.test.data.local.CoinLocalDataSourceImpl
import com.mukul.news.uk.test.data.mapper.CoinModelMapper
import com.mukul.news.uk.test.data.mapper.CoinModelMapperImpl
import com.mukul.news.uk.test.data.network.CoinNetworkDataSource
import com.mukul.news.uk.test.data.network.CoinNetworkDataSourceImpl
import com.mukul.news.uk.test.data.repository.CoinRepositoryImpl
import com.mukul.news.uk.test.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoinDataBindModule {
    @Binds
    fun bindCoinLocalDataSource(impl: CoinLocalDataSourceImpl): CoinLocalDataSource

    @Binds
    fun bindCoinNetworkDataSource(impl: CoinNetworkDataSourceImpl): CoinNetworkDataSource

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    @Binds
    fun bindCoinModelMapper(impl: CoinModelMapperImpl): CoinModelMapper
}