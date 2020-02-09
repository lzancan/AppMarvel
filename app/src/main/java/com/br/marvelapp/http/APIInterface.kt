package com.br.marvelapp.http

import com.br.marvelapp.model.APIModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface APIInterface {
    @GET("characters?")
    fun listAllCharacters(@Query("limit") limit: String,
                          @Query("offset") offset: String,
                          @Query("ts") ts: String,
                          @Query("apikey") apiKey: String,
                          @Query("hash") hash: String): Call<APIModel>
}