package com.example.hilt_mvvm_coroutine_room_boilerplate.network

import com.example.hilt_mvvm_coroutine_room_boilerplate.network.model.NetworkUserListItem
import retrofit2.http.GET

interface UserListService {

    @GET("/repos/square/retrofit/stargazers")
    suspend fun getUserList(): List<NetworkUserListItem>
}