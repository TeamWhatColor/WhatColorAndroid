package org.sopt.whatcolorandroid.ui.sehun

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {

    @GET("/main/{id}")
    fun getMain(
        @Path("id") id : String
    ) : Call<ResponseColorData>
}