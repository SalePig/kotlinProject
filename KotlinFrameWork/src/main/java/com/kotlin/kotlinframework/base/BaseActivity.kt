package com.kotlin.kotlinframework.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.View
import com.zhy.autolayout.AutoLayoutActivity

/**
 * Created by Administrator on 2017/9/12 0012.
 */

abstract class BaseActivity : AutoLayoutActivity(),IUI{

    protected var mIsActivityDestoryed = false
    private var isPaused: Boolean = false
    private var isStoped: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        isPaused = false
    }

    override fun onPause() {
        super.onPause()
        isPaused = true
    }

    override fun onDestroy() {
        mIsActivityDestoryed = true
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        // 一定不要干掉这段代码
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onStart() {
        super.onStart()
        isStoped = false

    }

    override fun onRestart() {
        super.onRestart()
        isStoped = false
    }

    override fun onStop() {
        isStoped = true
        super.onStop()
    }

    /**
     * isActivityDestoryed:Activity是否已经Destory了. <br></br>

     * @return true, Activity已经销毁了，不要在执行任何Fragment事务、显示Dialog等操作
     */
    fun isActivityDestoryed(): Boolean {
        return mIsActivityDestoryed
    }


    override fun isPaused(): Boolean {
        return isPaused;
    }

    override fun isDestoryed(): Boolean {
        return isActivityDestoryed()
    }

    override fun isDetached(): Boolean {
        return isDestoryed()
    }

    override fun isStoped(): Boolean {
        return isStoped
    }

    override fun isFragmentHidden(): Boolean {
        return isDestoryed()
    }

    override fun isVisibleToUser(): Boolean {
        return !isPaused()
    }

    override fun dismissWaitingDialogIfShowing() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showWaitingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContext(): Context {
        return this;
    }
}