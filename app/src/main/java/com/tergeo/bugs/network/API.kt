package com.tergeo.bugs.network

import com.tergeo.bugs.herolist.model.HeroModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface API {

    @PATCH("marvel")
    fun getHeroList(): Call<List<HeroModel>>
}