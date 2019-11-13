package com.sherlockkk.kaiyankotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false
    /**
     *是否加载过数据
     */
    private var hasLoadData = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView()
        lazyLoadDataIfPrepared()
    }

    /**
     * 加载布局
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 懒加载数据。
     * 1、页面可视&&视图已加载完毕&&没有加载过数据
     * 2、手动刷新数据
     */
    abstract fun lazyLoad()

    private fun lazyLoadDataIfPrepared() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }
    }
}
