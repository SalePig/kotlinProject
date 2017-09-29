package com.kotlin.kotlinframework.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast

/**
 * Created by Administrator on 2017/9/12 0012.
 */

abstract class BasePresenter<U :IUI>:IPresenter{

    private var mContext:Context?= null
    private var mUI: U?= null

    override fun <T : IUI> init(context: Context?, ui: T?) {
        mUI=ui as U
        mContext=context
    }

    protected fun  getUI() :U?{
        return mUI
    }

    protected fun getContext():Context? {

        return mContext
    }

    override fun onUICreate(savedInstanceState: Bundle?) {

    }

    override fun onUIStart() {
    }

    override fun onUIResume() {
    }

    override fun onUIPause() {
    }

    override fun onUIStop() {
    }

    override fun onUIRestart() {

    }
    override fun onUIDestory() {
    }

    override fun onSaveInstanceState(outState: Bundle) {
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {

    }


    fun toast(message: CharSequence, duration: Int =Toast.LENGTH_SHORT) {
        Toast.makeText(getContext(), message, duration).show()
    }
}