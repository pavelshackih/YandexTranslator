package io.pavelshackih.yandextranslator.ext.converter

interface Converter<F, T> {

    fun convert(from: F): T
}