package com.example.cat_facts.utils

import com.example.cat_facts.data.ApiInterface
import com.example.cat_facts.data.PostInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: ApiInterface by lazy {
        Retrofit.Builder().baseUrl(Util.Base).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }


    val dummyData: PostInterface by lazy {
        Retrofit.Builder().baseUrl("https://server-gbqcklj.vercel.app").addConverterFactory(GsonConverterFactory.create())
            .build().create(PostInterface::class.java)
    }

}