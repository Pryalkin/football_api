package com.bsuir.football.sources.backend

import com.bsuir.football.sources.model.AppSource
import com.bsuir.football.sources.model.RetrofitAppSource

class RetrofitSourcesProvider(
    private val config: RetrofitConfig
) : SourcesProvider {

    override fun getAppSource(): AppSource {
        return RetrofitAppSource(config)
    }

}