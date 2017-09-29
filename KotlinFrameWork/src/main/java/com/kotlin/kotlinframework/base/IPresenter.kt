package com.kotlin.kotlinframework.base

import android.content.Context
import android.os.Bundle

/**
 * Created by Administrator on 2017/9/12 0012.
 */

interface IPresenter {

    fun <U:IUI> init(context: Context?, ui: U?)

    /**
     * onUICreate:UI被创建的时候应该invoke这个method. <br></br>
     * 比如Activity的onCreate()、Fragment的onCreateView()的方法应该调用Presenter的这个方法
     * @param savedInstanceState 保存了的状态
     */
    fun onUICreate(savedInstanceState: Bundle?)

    /**
     * onUIStart:在UI被创建和被显示到屏幕之间应该回调这个方法. <br></br>
     * 比如Activity的onStart()方法应该调用Presenter的这个方法
     */
    fun onUIStart()

    /**
     * onUIResume:在UI被显示到屏幕的时候应该回调这个方法. <br></br>
     * 比如Activity的onResume()方法应该调用Presenter的这个方法
     */
    fun onUIResume()

    /**
     * onUIPause:在UI从屏幕上消失的时候应该回调这个方法. <br></br>
     * 比如Activity的onPause()方法应该调用Presenter的这个方法
     */
    fun onUIPause()

    /**
     * onUIStop:在UI从屏幕完全隐藏应该回调这个方法. <br></br>
     * 比如Activity的onStop()方法应该调用Presenter的这个方法
     */
    fun onUIStop()

    fun onUIRestart()

    /**
     * onUIDestory:当UI被Destory的时候应该回调这个方法. <br></br>
     */
    fun onUIDestory()

    /**
     * onSaveInstanceState:保存数据. <br></br>
     * 一般是因为内存不足UI的状态被回收的时候调用
     * @param outState 待保存的状态
     */
    fun onSaveInstanceState(outState: Bundle)

    /**
     * onRestoreInstanceState:当UI被恢复的时候被调用. <br></br>
     * @param savedInstanceState 保存了的状态
     */
    fun onRestoreInstanceState(savedInstanceState: Bundle)


}