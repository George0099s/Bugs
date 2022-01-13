package com.tergeo.bugs.network

object Common {
    private const val BASE_URL = "www.simplifiedcoding.net/demos/"

    val retrofitService: API = RetrofitClient.getClient(BASE_URL).create(API::class.java)
}