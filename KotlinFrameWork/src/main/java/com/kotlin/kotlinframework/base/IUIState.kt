package com.kotlin.kotlinframework.base

/**
 * Created by Administrator on 2017/9/12 0012.
 */

interface IUIState {
    /**
     * isPaused:是否已经pause.
     * @return 是否已经pause
     */
    fun isPaused(): Boolean

    /**
     * 是否已经destoryed.
     * @return 是否已经destoryed
     */
    fun isDestoryed(): Boolean

    /**
     * Fragmeng是否Detached;对Activity来讲,返回值同isDestoryed()

     * @return Detached
     */
    fun isDetached(): Boolean

    /**
     * 是否已Stop.

     * @return 是否已Stop
     */
    fun isStoped(): Boolean

    /**
     * Fragment是否被隐藏，对Activity来讲，返回值同isDestoryed().

     * @return 返回值同isDestoryed()
     */
    fun isFragmentHidden(): Boolean

    /**
     * 判断是否对用户可见，对Activity来讲和isPause()方法返回值相反；
     * 对Fragment来讲和setUserVisibleHint()的参数值一致.
     * @return 是否对用户可见
     */
    fun isVisibleToUser(): Boolean
}
