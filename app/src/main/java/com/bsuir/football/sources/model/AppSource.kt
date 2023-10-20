package com.bsuir.football.sources.model

import com.bsuir.football.app.model.Football
import retrofit2.Response

interface AppSource {
    suspend fun getLeagues(): Response<Football>
    suspend fun getLeague(id: String): Response<Football>
}