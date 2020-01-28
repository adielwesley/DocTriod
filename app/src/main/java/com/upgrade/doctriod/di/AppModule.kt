package com.upgrade.doctriod.di;

import com.upgrade.doctriod.models.services.DocTriodService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
object AppModule {

    private const val BASE_URL = "http://localhost:8080"

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideDocTriodApi(retrofit : Retrofit) : DocTriodService {
        return retrofit.create(DocTriodService::class.java)
    }

    internal fun provideRetrofitInterface() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }


}
