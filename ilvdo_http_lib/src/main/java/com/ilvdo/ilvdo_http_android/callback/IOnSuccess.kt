package com.ilvdo.ilvdo_http_android.callback

import io.reactivex.disposables.Disposable

/**
 * Created by sjy on 2018/12/5
 * Describe  这边没有使用泛型 而是用any代替，主要是解决泛型 在后面传参转化的问题
 */
interface IOnSuccess<T> {
    fun onSuccess(t:T)
}