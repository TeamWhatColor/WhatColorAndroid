package org.sopt.whatcolorandroid.ui.kangmin.data

data class ResponseExist(
    val data: Data,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val exist: Boolean
    )
}