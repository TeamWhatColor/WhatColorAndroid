package org.sopt.whatcolorandroid.api

import org.sopt.whatcolorandroid.ui.jeongwon.ResponseMissionData
import org.sopt.whatcolorandroid.ui.kangmin.data.RequestUserInfo
import org.sopt.whatcolorandroid.ui.kangmin.data.ResponseExist
import org.sopt.whatcolorandroid.ui.kangmin.data.ResponseUserInfo
import org.sopt.whatcolorandroid.ui.sehun.ResponseColorData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*

interface WhatColorService {
    @GET("user/{uuid}")
    fun getInfo(@Path("uuid") uuid: String): Call<ResponseExist>

    @POST("user")
    fun postUserInfo(@Body body: RequestUserInfo): Call<ResponseUserInfo>

    @GET("main/{id}")
    fun getMain(
        @Path("id") id : String
    ) : Call<ResponseColorData>

    @GET("mission/{uuid}")
    fun getMission(
        @Path("uuid") uuid: String): Call<ResponseMissionData>

}