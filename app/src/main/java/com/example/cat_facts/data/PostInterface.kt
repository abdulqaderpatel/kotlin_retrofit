package com.example.cat_facts.data

import com.example.cat_facts.models.Post
import com.example.cat_facts.models.PostItem
import com.example.cat_facts.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostInterface {

    @POST("/")
    suspend fun getRandomPosts(@Body requestBody: User): Response<String>
}