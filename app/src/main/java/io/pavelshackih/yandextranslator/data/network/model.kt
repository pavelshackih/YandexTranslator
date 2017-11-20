package io.pavelshackih.yandextranslator.data.network

import com.google.gson.annotations.SerializedName

data class LangsResponse(@SerializedName("dirs") val dirs: List<String>,
                         @SerializedName("langs") val langs: Map<String, String>)

data class TranslateResponse(@SerializedName("code") val code: Int = 0,
                             @SerializedName("lang") val lang: String = "",
                             @SerializedName("text") val text: List<String> = ArrayList())