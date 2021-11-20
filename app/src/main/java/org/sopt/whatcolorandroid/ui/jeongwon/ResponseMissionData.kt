package org.sopt.whatcolorandroid.ui.jeongwon

data class ResponseMissionData(
    val status: Int,
    val success: Boolean,
) {
    data class Data(
        val content: String
    )
}


