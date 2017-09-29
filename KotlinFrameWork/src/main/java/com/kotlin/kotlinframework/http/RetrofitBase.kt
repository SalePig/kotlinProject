package com.kotlin.kotlinframework.http

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

/**
 * Created by Administrator on 2017/7/21 0021.
 */

abstract class RetrofitBase constructor(val baseUrl: String) {

    fun <T : Any> create(clazz: KClass<T>): T {
        return retrofit.create(clazz.java)
    }

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(baseUrl)
                //封装网络请求的运行线程
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //自定义gson转换器  将通用类型在解析封装处理异常情况,直接返回数据
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val timestamp = System.currentTimeMillis() / 1000L
                    val request = chain.request()
                    val builder = request.newBuilder()
                    builder.addHeader("token", "")
                    builder.addHeader("timestamp", timestamp.toString())
                    builder.addHeader("Content-Type", "application/json;charset=UTF-8")
                    val build = builder.build()
                    chain.proceed(build)
                }
                //日志打印
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }

}

object RetrofitHelp : RetrofitBase(API.ACCOUNT2)


