package com.maple.demo.kotlinmvvm.http

import com.maple.demo.kotlinmvvm.BuildConfig
import com.maple.demo.kotlinmvvm.model.service.ApiService
import com.safframework.http.interceptor.LoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * author: gaogq
 * time: 2019/4/1 18:14
 * description:
 */
class RetrofitManager private constructor() {

    private val apiService: ApiService

    private val okhttpClient: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
        //设置超时
        builder.writeTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)
        builder.readTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)
        builder.connectTimeout((5 * 1000).toLong(), TimeUnit.MILLISECONDS)

        val loggingInterceptor = LoggingInterceptor.Builder()
                .loggable(BuildConfig.DEBUG) //  发布到生产环境需要改成false
                .request()
                .requestTag("Request")
                .response()
                .responseTag("Response")
                .build()

        //设置拦截器
        builder.addInterceptor(loggingInterceptor)

        okhttpClient = builder.build()

        mRetrofit = Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //设置 gson 转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 设置 RxJava2 适配器
                .client(okhttpClient)
                .build()

        apiService = mRetrofit.create(ApiService::class.java)
    }

    fun retrofit(): Retrofit = mRetrofit

    fun apiService(): ApiService = apiService

    fun okhttpClient(): OkHttpClient = okhttpClient

    private object Holder {
        val MANAGER = RetrofitManager()
    }

    companion object {

        private lateinit var mRetrofit: Retrofit

        @JvmStatic
        fun get(): RetrofitManager {

            return Holder.MANAGER
        }
    }
}