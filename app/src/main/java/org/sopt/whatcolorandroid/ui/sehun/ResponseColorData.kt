package org.sopt.whatcolorandroid.ui.sehun

data class ResponseColorData(
    private val status: Int,
    private val success: Boolean,
    private val data: Data
) {
    data class Data(
        private val nickname: String,
        private val color: String,
        private val content : String
    )
}
