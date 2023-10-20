package com.bsuir.football.sources.backend

import com.bsuir.football.sources.model.AppSource

interface SourcesProvider {

    fun getAppSource(): AppSource

}