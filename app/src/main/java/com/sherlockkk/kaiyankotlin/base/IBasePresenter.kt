package com.sherlockkk.kaiyankotlin.base

interface IBasePresenter<in V : IBaseView> {
    fun attachView(mRootView: V)
    fun detachView()
}