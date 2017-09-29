package com.kotlin.kotlinframework.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Administrator on 2017/9/14 0014.
 */

abstract class BaseMVPFragment<P : IPresenter> : BaseFragment() {

    val TAG = "BaseMVPFragment"

    private val KEY_DATA = "keyData"

    private val SAVE_STATE = "save_state"

    protected var mPresenter: P? = null

    protected var mRootView: View? = null

    protected var mData: Bundle? = null

    protected var mExtras: Bundle? = null
    protected var bundle: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            val isSupportHidden = savedInstanceState.getBoolean(SAVE_STATE)
            val ft = fragmentManager.beginTransaction()
            if (isSupportHidden)
                ft.hide(this)
             else
                ft.show(this)

            ft.commit()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bundle = savedInstanceState
        setExtras(arguments)

        if (savedInstanceState != null) {
            val bundle = savedInstanceState.getBundle(KEY_DATA)
            if (bundle != null) {
                mData = bundle
            }
        }
        if (mRootView == null) {
            mPresenter = createPresenter()
            getPresenter()?.init(context, getUI())
            mRootView = onCreateViewExecute(inflater, container, savedInstanceState)
        }
        initViews(mRootView, savedInstanceState)
        return mRootView
    }

    /**
     * 不适用databinding 需要重写此方法

     * @param rootView
     * *
     * @param savedInstanceState
     */
    fun initViews(rootView: View?, savedInstanceState: Bundle?) {

    }

    /**
     * onCreateViewExecute

     * @param inflater
     * *
     * @param container
     * *
     * @param savedInstanceState
     * *
     * @return
     */
    protected fun onCreateViewExecute(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = null
        if (getLayoutResID() != 0) {
            view = inflater.inflate(getLayoutResID(), container, false)
        } else {
            view = super.onCreateView(inflater, container, savedInstanceState)
        }
        getPresenter()?.onUICreate(savedInstanceState)
        return view
    }


    /**
     * 得到布局文件

     * @return
     */
    protected abstract fun getLayoutResID(): Int

    /**
     * getUI:得到UI.一般都是Fragment或者Activity本身 <br></br>

     * @return
     */
    protected abstract fun getUI(): IUI

    /**
     * createPresenter:创建一个Presenter，子类来实现，可以通过new的方式直接new出来一个. <br></br>

     * @return
     */
    protected abstract fun createPresenter(): P

    /**
     * getPresenter:子类应该通过这个方法拿到Presenter的实例，而不是通过变量拿到. <br></br>

     * @return
     */
    protected fun getPresenter(): P? {
        return mPresenter
    }

    override fun onStart() {
        super.onStart()
        getPresenter()?.onUIStart()
    }

    override fun onStop() {
        super.onStop()
        getPresenter()?.onUIStop()
    }

    override fun onResume() {
        super.onResume()
        getPresenter()?.onUIResume()
    }

    override fun onPause() {
        super.onPause()
        getPresenter()?.onUIPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (mRootView?.parent as ViewGroup).removeView(mRootView)
        getPresenter()?.onUIDestory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (mData != null) {
            outState.putBundle(KEY_DATA, mData)
        }
        getPresenter()?.onSaveInstanceState(outState)
        outState.putBoolean(SAVE_STATE, isHidden)
        super.onSaveInstanceState(outState)
    }

    /**
     * getData:得到传输过来的数据. <br></br>

     * @return
     */
    fun getData(): Bundle? {
        return mData
    }

    /**
     * setData:设置启动这个Fragment必须的数据. <br></br>

     * @param bundle
     */
    fun setData(bundle: Bundle) {
        this.mData = bundle
    }

    /**
     * getExtras:得到Extras. <br></br>

     * @return Extras
     */
    fun getExtras(): Bundle? {
        return mExtras
    }

    /**
     * setExtras:设置Extras. <br></br>

     * @param extras extras
     */
    fun setExtras(extras: Bundle) {
        this.mExtras = extras
    }
}
