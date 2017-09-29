package com.example.kotlin.kotlinproject.preserter

import android.content.Context
import cn.zhmj.sourdough.rx.EmptyObserver
import com.example.kotlin.kotlinproject.IView.ITestView
import com.kotlin.kotlinframework.base.BasePresenter
import com.kotlin.kotlinframework.base.IUI
import com.kotlin.kotlinframework.http.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017/9/13 0013.
 */

class TestPresent:BasePresenter<ITestView>() {

    fun getCheckNum2() {
        Api.mobileExisted("13545213172")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { println("call…………………………") }
                .subscribe(
                        EmptyObserver.with(
                                { toast("开始") },
                                { bean -> toast("成功") },
                                { exception -> print("异常") },
                                { toast("完成") })
                )
    }

}