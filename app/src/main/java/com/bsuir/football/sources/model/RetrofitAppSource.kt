package com.bsuir.football.sources.model

import com.bsuir.football.app.model.Football
import com.bsuir.football.sources.backend.BackendRetrofitSource
import com.bsuir.football.sources.backend.RetrofitConfig
import kotlinx.coroutines.delay
import retrofit2.Response

class RetrofitAppSource(
    config: RetrofitConfig
) : BackendRetrofitSource(config), AppSource {

    private val appApi = retrofit.create(AppApi::class.java)

    override suspend fun getLeagues(): Response<Football> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getLeagues()
    }

    override suspend fun getLeague(id: String): Response<Football> = wrapRetrofitExceptions {
        delay(1000)
        appApi.getLeague(id)
    }


}