package com.sherlockkk.kaiyankotlin

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

class MyApplication : Application() {

    companion object {
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}