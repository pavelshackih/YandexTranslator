package io.pavelshackih.yandextranslator.ext.common

inline fun Boolean.ifTrue(l: () -> Unit) {
    if (this) {
        l.invoke()
    }
}