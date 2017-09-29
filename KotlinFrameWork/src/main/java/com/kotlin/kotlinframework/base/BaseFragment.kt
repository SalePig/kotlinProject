package com.kotlin.kotlinframework.base

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by Administrator on 2017/9/14 0014.
 */

abstract class BaseFragment:Fragment() ,IUI{

    /**
     * 调用Fragment的startActivityForResult的child *
     */
    private var startActivityForResultChild: BaseFragment? = null

    private var isPaused: Boolean = false

    private var isStoped: Boolean = false
    private var isDestoryed: Boolean = false
    private var isVisibleToUser = false
    var mActivty: Activity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isDestoryed = false
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    override fun onStart() {
        super.onStart()
        isStoped = false
    }

    override fun onResume() {
        super.onResume()
        isPaused = false
    }

    override fun onPause() {
        isPaused = true
        super.onPause()
    }

    override fun onStop() {
        isStoped = true
        super.onStop()
    }

    override fun onDestroy() {
        isDestoryed = true
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // 一定不要干掉这段代码
        super.onActivityResult(requestCode, resultCode, data)
    }

    /**
     * setStartActivityForResultChild:设置调用Fragment的startActivityForResult的child. <br></br>

     * @param child
     */
     fun setStartActivityForResultChild(child: BaseFragment) {
        this.startActivityForResultChild = child
    }

     fun getStartActivityForResultChild(): BaseFragment ?{
        return startActivityForResultChild
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }

    override fun isPaused(): Boolean {
        return isPaused
    }

    override fun isStoped(): Boolean {
        return isStoped
    }

    override fun isDestoryed(): Boolean {
        return isDestoryed
    }

    fun isFragmentDetached(): Boolean {
        return isDetached
    }

    override fun isFragmentHidden(): Boolean {
        return isHidden
    }

    override fun isVisibleToUser(): Boolean {
        return isVisibleToUser
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        this.isVisibleToUser = isVisibleToUser
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun getContext(): Context {
        return context
    }

    override fun dismissWaitingDialogIfShowing() {

    }

    override fun showWaitingDialog() {

    }
}