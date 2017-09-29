package com.kotlin.kotlinframework.base

import android.content.Context

/**
 * Created by Administrator on 2017/9/12 0012.
 */

interface IUI:IUIState{

    //dismissWaitingDialogIfShowing:如果加载对话框正在显示，则dismiss掉它. <br></br>
     fun dismissWaitingDialogIfShowing()
    // showWaitingDialog:显示正在加载对话框. <br></br>
     fun showWaitingDialog()
//     fun showLoading()
//     fun showContent()
//     fun showEmpty()
//     fun showError()
     fun getContext(): Context
}