package com.example.kotlin.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import cn.zhmj.sourdough.rx.EmptyObserver
import com.example.kotlin.kotlinproject.IView.ITestView
import com.example.kotlin.kotlinproject.preserter.TestPresent
import com.kotlin.kotlinframework.base.BaseActivity
import com.kotlin.kotlinframework.base.BaseMVPActivity
import com.kotlin.kotlinframework.http.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_kotlin.*


class kotlinActivity : BaseMVPActivity<ITestView, TestPresent>() {

    override fun getLayoutResID(): Int {
        return R.layout.activity_kotlin
    }

    override fun createPresenter(): TestPresent {
        return TestPresent()
    }

    override fun initViews(savedInstanceState: Bundle?){
        check_num.setOnClickListener {
            getPresenter()?.getCheckNum2()
        }
    }

}
