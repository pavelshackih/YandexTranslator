package io.pavelshackih.yandextranslator.data.wrapper

import io.pavelshackih.yandextranslator.domain.wrapper.PlatformWrapper

class PlatformWrapperImpl : PlatformWrapper {
    override fun getCurrentTime(): Long = System.currentTimeMillis()
}