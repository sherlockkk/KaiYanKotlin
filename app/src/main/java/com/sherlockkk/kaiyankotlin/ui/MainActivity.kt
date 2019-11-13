package com.sherlockkk.kaiyankotlin.ui

import android.view.KeyEvent
import com.sherlockkk.kaiyankotlin.R
import com.sherlockkk.kaiyankotlin.base.BaseActivity
import com.sherlockkk.kaiyankotlin.showToast

class MainActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    var exitTime = 0L
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(exitTime) <= 2000) {
                finish()
            } else {
                exitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}