package com.x.data.remote.module

import com.x.data.BuildConfig.BASE_URL
import com.x.data.BuildConfig.TICKETS_BASE_URL
import com.x.data.remote.apiservice.ApiService
import com.x.data.remote.apiservice.TicketsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideOkHttpClientBuilder().build() }
    factory { provideApiService(provideRetrofit(provideOkHttpClientBuilder().build())) }
    factory { provideTicketApiService(provideTicketRetrofit(provideOkHttpClientBuilder().build())) }
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun provideTicketRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(TICKETS_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}


fun provideApiService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

fun provideTicketApiService(retrofit: Retrofit): TicketsApiService {
    return retrofit.create(TicketsApiService::class.java)
}



internal fun provideOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient()
    .newBuilder()
    .addInterceptor(provideLoggingInterceptor())
    .callTimeout(60, TimeUnit.SECONDS)
    .connectTimeout(60, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .writeTimeout(60, TimeUnit.SECONDS)

private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
    when {
        org.koin.android.BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
        else -> HttpLoggingInterceptor.Level.NONE
    }
)
