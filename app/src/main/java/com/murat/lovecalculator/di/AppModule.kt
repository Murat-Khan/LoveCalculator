package com.murat.lovecalculator.di
import android.content.Context
import android.content.Entity
import androidx.room.Room
import com.murat.lovecalculator.local.Pref
import com.murat.lovecalculator.remote.LoveApi
import com.murat.lovecalculator.remote.LoveModel
import com.murat.lovecalculator.room.LoveDataBase
import com.murat.lovecalculator.utils.Constants.LOVE_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApi() : LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }
    @Provides
    fun getSharedPreferences(@ApplicationContext appContext: Context): Pref {
        return Pref(appContext)
    }
   /* @Provides
   fun provideDao(db : LoveDataBase) = db.getDao()

    @Provides
    fun provideDatabase(@ApplicationContext context:Context) =Room.databaseBuilder(
        context,LoveDataBase::class.java, LOVE_DATABASE)
        .allowMainThreadQueries()
        .build()*/



}