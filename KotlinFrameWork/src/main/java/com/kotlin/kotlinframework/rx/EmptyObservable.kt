package cn.zhmj.sourdough.rx

import io.reactivex.observers.DisposableObserver

/**
 *
 */
open class EmptyObserver<T> : DisposableObserver<T>() {


    override fun onError(e: Throwable?) {}

    override fun onNext(t: T) {}

    override fun onStart() {}

    override fun onComplete() {}

    companion object {

        fun <T> with(onStartAction:() -> Unit,onNextAction: (T) -> Unit, onErrorAction: (Throwable?) -> Unit,onCompleteAction:()-> Unit) = object : EmptyObserver<T>() {

            override fun onStart() {
                super.onStart()
                try {
                    onStartAction()
                } catch (e: Exception) {
                    onError(e)
                }
            }

            override fun onNext(t: T): Unit {
                super.onNext(t)
                try {
                    onNextAction(t)
                } catch (e: Exception) {
                    onError(e)
                }
            }

            override fun onError(e: Throwable?) {
                super.onError(e)
                onErrorAction(e)
            }

            override fun onComplete() {
                super.onComplete()
                try {
                    onCompleteAction()
                } catch (e: Exception) {
                    onError(e)
                }
            }
        }


        fun <T> with(onStartAction:() -> Unit,onNextAction: (T) -> Unit, onErrorAction: (Throwable?) -> Unit) = Companion.with(onStartAction,onNextAction,onErrorAction){}


        fun <T> with(onNextAction: (T) -> Unit, onErrorAction: (Throwable?) -> Unit) = Companion.with({},onNextAction,onErrorAction)

        fun <T> with(onNextAction: (T) -> Unit) = Companion.with(onNextAction) {}
//        fun <T> with(onNextAction: (T) -> Unit) = Companion.with(onNextAction,{})
    }
}
