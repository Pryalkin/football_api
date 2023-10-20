package com.bsuir.football.sources

import com.bsuir.football.Constants
import com.bsuir.football.app.setting.AppSettings
import com.bsuir.football.sources.backend.RetrofitConfig
import com.bsuir.football.sources.backend.RetrofitSourcesProvider
import com.bsuir.football.sources.backend.SourcesProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

object SourceProviderHolder {

    val sourcesProvider: SourcesProvider by lazy {
        val moshi = Moshi.Builder().
        add(Date::class.java, Rfc3339DateJsonAdapter()).
        addLast(KotlinJsonAdapterFactory()).
        build()
        val config = RetrofitConfig(
            retrofit = createRetrofit(moshi),
            moshi = moshi
        )
        RetrofitSourcesProvider(config)
    }

    /**
     * Create an instance of Retrofit client.
     */
    private fun createRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    /**
     * Create an instance of OkHttpClient with interceptors for authorization
     * and logging (see [createAuthorizationInterceptor] and [createLoggingInterceptor]).
     */
    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createAuthorizationInterceptor())
            .addInterceptor(createLoggingInterceptor())
            .build()
    }

    /**
     * Add Authorization header to each request if JWT-token exists.
     */
    private fun createAuthorizationInterceptor(): Interceptor {
        return Interceptor { chain ->
            val newBuilder = chain.request().newBuilder()
            newBuilder.addHeader("x-rapidapi-key", "7b6af69bf01cec51ddcd4111218d5e1d")
            newBuilder.addHeader("x-rapidapi-host", "v3.football.api-sports.io")
            return@Interceptor chain.proceed(newBuilder.build())
        }
    }

    /**
     * Log requests and responses to LogCat.
     */
    private fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

}