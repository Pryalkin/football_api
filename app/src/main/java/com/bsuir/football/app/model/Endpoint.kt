package com.bsuir.football.app.model

data class Endpoint(
    val league: League,
    val country: Country,
    val seasons: List<Season>
)
