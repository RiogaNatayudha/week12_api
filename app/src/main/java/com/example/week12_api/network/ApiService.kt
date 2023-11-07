package com.example.week12_api.network

import retrofit2.Call
import com.example.week12_api.model.Users
import retrofit2.http.GET

interface ApiService {
    @GET("employees")
    fun getAllUsers(): Call <Users>
}