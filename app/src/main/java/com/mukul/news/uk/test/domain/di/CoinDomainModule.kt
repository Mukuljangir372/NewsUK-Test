package com.mukul.news.uk.test.domain.di

import com.mukul.news.uk.test.domain.usecase.GetCoinUsecase
import com.mukul.news.uk.test.domain.usecase.GetCoinUsecaseImpl
import com.mukul.news.uk.test.domain.usecase.GetCoinsUsecase
import com.mukul.news.uk.test.domain.usecase.GetCoinsUsecaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoinDomainModule {
    @Binds
    fun bindGetCoinsUsecase(impl: GetCoinsUsecaseImpl): GetCoinsUsecase

    @Binds
    fun bindGetCoinUsecase(impl: GetCoinUsecaseImpl): GetCoinUsecase
}