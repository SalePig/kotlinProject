package com.example.kotlin.kotlinproject

import org.junit.Test
import org.junit.runner.RunWith


class KotlinTest{


    /**
     * 变量 与常量
     */
    @Test fun testKotlin() {
        var quantity = 5   //变量
        val price: Double = 20.3// 常量 final

        val name: String = "大米"

        println("单价:$price")
        println("数量:$quantity")
        println("产品:$name 总计:${quantity * price}")
    }

    /**
     * null
     */
    @Test fun testKotlin2() {

        //当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。
        val name :String? = null//可为空


    }


}