package io.pavelshackih.yandextranslator.domain

enum class SupportedLang(val code: String) {
    EN("en"), RU("ru")
}

data class Translate(val variants: List<String>)