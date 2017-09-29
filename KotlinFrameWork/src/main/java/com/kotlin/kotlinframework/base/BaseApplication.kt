package com.kotlin.kotlinframework.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.multidex.MultiDexApplication
import com.blankj.utilcode.utils.Utils
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import com.zhy.autolayout.config.AutoLayoutConifg
import java.lang.ref.WeakReference

abstract class BaseApplication : MultiDexApplication() {
    private var initialized = false

    private var topActivityRef: WeakReference<Activity>? = null

    val topActivity by lazy { topActivityRef?.get() }


    fun initialize() {
        if (!initialized) {
            initialized = true
            if (LeakCanary.isInAnalyzerProcess(this)) return
            LeakCanary.install(this)//内存检测
            //默认使用的高度是设备的可用高度，也就是不包括状态栏和底部的操作栏的，如果你希望拿设备的物理高度进行百分比化
            AutoLayoutConifg.getInstance().useDeviceSize()
            //工具类
            Utils.init(this)
            //借助Stetho在Chrome上调试Android网络&数据库
            Stetho.initializeWithDefaults(this)
            manageActivityLifecycle()
            onInitialized()
        }
    }

    protected open fun onInitialized() {}

    private fun manageActivityLifecycle() {
        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityDestroyed(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
            override fun onActivityResumed(activity: Activity) {
                topActivityRef = WeakReference(activity)
            }
        })
    }
}