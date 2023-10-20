package com.bsuir.football.app.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsuir.football.Singletons
import com.bsuir.football.app.model.Football
import com.bsuir.football.app.model.utils.HttpResponse
import com.bsuir.football.app.repository.AppRepository
import com.bsuir.football.app.utils.MutableLiveEvent
import com.bsuir.football.app.utils.publishEvent
import com.bsuir.football.app.utils.share
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import retrofit2.Response

class AppViewModel  (
    private val appRepository: AppRepository = Singletons.appRepository
): ViewModel() {

    private val _message = MutableLiveEvent<String>()
    val message = _message.share()

    private val _football = MutableLiveData<Football>()
    val football: LiveData<Football> get() = _football

//    private val _w = MutableLiveData<W>()
//    val w: LiveData<W> get() = _w

    private fun showToast(mes: String) = _message.publishEvent(mes)

    fun getLeagues() {
        viewModelScope.launch {
            var res: Response<Football> = appRepository.getLeagues()
            if (res.isSuccessful){
                _football.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

    fun getLeague(id: String) {
        viewModelScope.launch {
            var res: Response<Football> = appRepository.getLeague(id)
            if (res.isSuccessful){
                _football.value = res.body()
            } else {
                val gson = GsonBuilder().setDateFormat("MM-dd-yyyy hh:mm:ss").create()
                val mes = gson.fromJson(res.errorBody()!!.string(), HttpResponse::class.java).message
                showToast(mes)
            }
        }
    }

}