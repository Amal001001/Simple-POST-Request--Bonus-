package com.example.simplepostrequestbonus

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIInterface {
    @POST("/custom-people/")
    fun addName(@Body namesdata:data) : Call<data>
}