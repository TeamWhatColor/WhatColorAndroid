package org.sopt.whatcolorandroid.ui.kangmin.data

data class ResponseUserInfo(
    val data: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val teamColor: String
    )
}