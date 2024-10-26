package com.example.hilt_mvvm_coroutine_room_boilerplate.network

import com.example.hilt_mvvm_coroutine_room_boilerplate.network.model.NetworkUserDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface UserDetailsService {

    @GET("/users/{user}")
    suspend fun getUserDetails(@Path("user") user: String): NetworkUserDetails
}