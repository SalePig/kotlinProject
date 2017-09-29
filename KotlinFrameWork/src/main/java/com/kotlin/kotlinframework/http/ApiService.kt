package com.kotlin.kotlinframework.http

import com.kotlin.kotlinframework.base.BaseResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Administrator on 2017/8/8 0008.
 */

interface Api {

    @POST(API.XHS + URLConstans.MOBILE_EXISTED) @FormUrlEncoded
    fun mobileExisted(@Field("mobile") mobile :String): Observable<BaseResponse<Boolean>>




    companion object : Api by RetrofitHelp.create(Api::class)
}