package com.bsuir.football.sources.model

import com.bsuir.football.app.model.Football
import retrofit2.Response
import retrofit2.http.*

interface AppApi {

    @GET("leagues")
    suspend fun getLeagues(@Query("season") season: String = "2024"): Response<Football>

    @GET("leagues")
    suspend fun getLeague(@Query("id") id: String,
                          @Query("season") season: String = "2024"): Response<Football>

}