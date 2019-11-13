package com.sherlockkk.kaiyankotlin.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(layoutId())
        initData()
        initView()
        start()

    }

    /**
     * 加载布局
     */
    abstract fun layoutId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     *初始化View
     */
    abstract fun initView()

    /**
     * 开始请求
     */
    abstract fun start()

    override fun onDestroy() {
        super.onDestroy()
        //todo 全局资源回收处理
    }
}