package com.mukul.news.uk.test.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mukul.news.uk.test.data.local.CoinDao
import com.mukul.news.uk.test.data.local.model.CoinLocalModel

@TypeConverters(CoinDatabaseTypeConvertor::class)
@Database(
    entities = [CoinLocalModel::class],
    version = 1
)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}