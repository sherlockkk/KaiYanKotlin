package com.sherlockkk.kaiyankotlin

import android.content.Context
import android.widget.Toast

fun Context.showToast(msg: String) {
    Toast.makeText(MyApplication.context, msg, Toast.LENGTH_SHORT).show()
}