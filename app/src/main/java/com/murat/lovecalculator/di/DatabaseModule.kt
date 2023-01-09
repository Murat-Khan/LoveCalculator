package com.murat.lovecalculator.di

import android.app.Application
import androidx.room.Room
import com.murat.lovecalculator.room.LoveDao
import com.murat.lovecalculator.room.LoveDataBase
import com.murat.lovecalculator.utils.Constants.LOVE_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): LoveDataBase{
        return Room.databaseBuilder(application,  LoveDataBase::class.java, LOVE_DATABASE)
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideArticleDao(db: LoveDataBase): LoveDao{
        return db.getDao()
    }
}