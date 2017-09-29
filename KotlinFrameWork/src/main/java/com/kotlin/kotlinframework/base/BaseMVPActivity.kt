package com.kotlin.kotlinframework.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import java.util.logging.Logger

/**
 * Created by Administrator on 2017/9/12 0012.
 */

  abstract  class BaseMVPActivity<U:IUI,P:IPresenter> : BaseActivity(),IUI {


    //静态变量
    companion object {
        val KEY_DATA = "keyDataOfActivity"
    }

    //var 可变 变量  val不可变 变量
    private var mPresenter: P? = null
    private var mBundle: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mBundle = savedInstanceState?.getBundle(KEY_DATA)
//        mBundle = intent.extras != null? intent.extras:savedInstanceState?.getBundle(KEY_DATA)
        mBundle = if (intent.extras != null)
            intent.extras
        else
            savedInstanceState?.getBundle(KEY_DATA)
//        mPresenter = createPresenter();
//        getPresenter()?.init(this,getUI());
        initPresenter()
        onCreateExecute(savedInstanceState)

        getPresenter()?.onUICreate(savedInstanceState)
    }

    protected fun onCreateExecute(savedInstanceState:Bundle?){
        if(getLayoutResID()!=0){
            setContentView(getLayoutResID())
            initViews(savedInstanceState)
        }
    }


    /**
     * createPresenter:创建一个Presenter，子类来实现，可以通过new的方式直接new出来一个. <br></br>
     * @return
     */
    protected abstract fun createPresenter(): P

    protected  fun initPresenter(){
        mPresenter= if (mPresenter!=null) mPresenter else createPresenter()
        mPresenter?.init(this,getUI())
    }

    /**
     * getPresenter:子类应该通过这个方法拿到Presenter的实例，而不是通过变量拿到. <br></br>

     * @return Presenter
     */
    protected fun getPresenter(): P? {
        if (getgetPresenter(mPresenter))
            return mPresenter
        else
            Log.e("BaseMVPActivity:", "Presenter is null? please check")
        return null
    }

    private fun getgetPresenter(presenter: P?): Boolean {
        return presenter != null
    }


    /***
     * 获取view

     * @return
     */
    protected abstract fun getLayoutResID(): Int


    /**
     * 数据没绑定就调用此方法

     * @param savedInstanceState
     */
    open fun initViews(savedInstanceState: Bundle?) {

    }


    /**
     * getUI:得到UI层组件，一般都是Activity或者Fragment本身. <br></br>
     * @return
     */
    protected  fun getUI(): IUI{
        return  this;
    }


    override fun onResume() {
        super.onResume()
        getPresenter()?.onUIResume()
    }

    override fun onPause() {
        super.onPause()
        getPresenter()?.onUIPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter()?.onUIDestory()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onStart() {
        super.onStart()
        getPresenter()?.onUIStart()
    }

    override fun onRestart() {
        super.onRestart()
        getPresenter()?.onUIRestart()
    }

    override fun onStop() {
        super.onStop()
        getPresenter()?.onUIStop()
    }
}