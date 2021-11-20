package org.sopt.whatcolorandroid.ui.sehun

data class ResponseColorData(
    val status: Int,
    val success: Boolean,
    val data: Data
) {
    data class Data(
        val nickname: String,
        val color: String,
        val content : String
    )
}
