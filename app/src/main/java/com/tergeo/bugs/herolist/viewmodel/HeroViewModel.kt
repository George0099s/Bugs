package com.tergeo.bugs.herolist.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tergeo.bugs.herolist.model.HeroModel
import com.tergeo.bugs.network.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroViewModel: ViewModel() {

    companion object {
        private const val TAG = "HeroViewModel"
    }

    init {
//        getHeroList()
    }

    val heroListLiveData = MutableLiveData<List<HeroModel>>()

    private fun getHeroList() {
        Common.retrofitService
            .getHeroList()
            .enqueue(object : Callback<List<HeroModel>> {
            override fun onResponse(
                call: Call<List<HeroModel>>,
                response: Response<List<HeroModel>>
            ) {
                Log.d(TAG, "onResponse: ${response.message()}")
                if (response.isSuccessful && response.body() != null) {

                    val list = response.body()!!

                    Runnable {
                        heroListLiveData.value = list
                    }
                }
            }

            override fun onFailure(call: Call<List<HeroModel>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }
}