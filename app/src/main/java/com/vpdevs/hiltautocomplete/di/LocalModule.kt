package com.vpdevs.hiltautocomplete.di

import android.content.Context
import androidx.room.Room
import com.vpdevs.hiltautocomplete.db.dao.ACDao
import com.vpdevs.hiltautocomplete.db.databse.ACDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        ACDatabase::class.java,
        "AutoCompleteDB"
    ).build()

    @Provides
    @Singleton
    fun providesWordsDao(db: ACDatabase): ACDao {
        return db.acDao
    }

}