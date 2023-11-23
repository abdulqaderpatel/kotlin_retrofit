package com.example.cat_facts.data

import com.example.cat_facts.models.CatFacts
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/fact")
    suspend fun getRandomFacts(): Response<CatFacts>




}