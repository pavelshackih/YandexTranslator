package io.pavelshackih.yandextranslator.domain

import io.pavelshackih.yandextranslator.R

enum class AppLang(val code: String, val ui: Int) {
    EN("en", R.string.eng),
    RU("ru", R.string.rus),
    DE("de", R.string.ger)
}

data class Translate(val variants: List<String>)