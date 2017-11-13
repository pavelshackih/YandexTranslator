package io.pavelshackih.yandextranslator.ext.rx

import io.reactivex.Maybe

fun <T> maybeFromNull(value: T?): Maybe<T> = if (value == null) Maybe.empty() else Maybe.just(value)