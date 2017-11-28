package io.pavelshackih.yandextranslator.ext.view

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflate(@LayoutRes resId: Int): View =
        LayoutInflater.from(this.context).inflate(resId, this, false)