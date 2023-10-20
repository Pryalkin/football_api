package com.bsuir.football.app.repository

import com.bsuir.football.app.model.Football
import com.bsuir.football.sources.exception.BackendException
import com.bsuir.football.sources.exception.InvalidCredentialsException
import com.bsuir.football.sources.model.AppSource
import retrofit2.Response

class AppRepository(
    private val appSource: AppSource
) {


    suspend fun getLeagues(): Response<Football> {
        val res: Response<Football> = try {
            appSource.getLeagues()
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }

    suspend fun getLeague(id: String): Response<Football> {
        val res: Response<Football> = try {
            appSource.getLeague(id)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }
        }
        return res
    }


}