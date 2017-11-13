package io.pavelshackih.yandextranslator.data.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.pavelshackih.yandextranslator.BuildConfig
import io.pavelshackih.yandextranslator.ext.common.ifTrue
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface TranslatorRemoteApi {

    @Headers(
            "Accept: */*",
            "Content-Type: application/x-www-form-urlencoded"
    )
    @POST("getLangs")
    fun getLangs(@Query("ui") ui: String): Single<LangsResponse>

    @Headers(
            "Accept: */*",
            "Content-Type: application/x-www-form-urlencoded"
    )
    @FormUrlEncoded
    @POST("translate")
    fun translate(@Query("code") lang: String, @Field("text") text: String): Single<TranslateResponse>

    companion object {

        private const val BASE_URL = "https://translate.yandex.net/api/v1.5/tr.json/"

        val API: TranslatorRemoteApi by lazy {
            val interceptor = HttpLoggingInterceptor().apply {
                BuildConfig.DEBUG.ifTrue {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            }
            val client = OkHttpClient.Builder()
                    .addInterceptor(YandexApiInterceptor())
                    .addInterceptor(interceptor)
                    .build()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            retrofit.create(TranslatorRemoteApi::class.java)
        }
    }

    private class YandexApiInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter(API_KEY_PARAM, API_KEY)
                    .build()

            val requestBuilder = original.newBuilder().url(url)
            val request = requestBuilder.build()
            return chain.proceed(request)
        }

        companion object {
            private const val API_KEY_PARAM = "key"
            private const val API_KEY = "trnsl.1.1.20171104T161246Z.c22b13f997b7bbcd.8c9997db6d8f98f2da6303a64c78b728a9150ba9"
        }
    }
}