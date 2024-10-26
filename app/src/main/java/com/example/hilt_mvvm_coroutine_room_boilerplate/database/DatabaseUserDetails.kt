package com.example.hilt_mvvm_coroutine_room_boilerplate.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hilt_mvvm_coroutine_room_boilerplate.domain.UserDetails

@Entity
data class DatabaseUserDetails(
    @PrimaryKey
    val user: String,
    val avatar: String,
    val name: String,
    val userSince: String,
    val location: String
)

fun DatabaseUserDetails.asDomainModel(): UserDetails {
    return UserDetails(
        user = user,
        avatar = avatar,
        name = name,
        userSince = userSince,
        location = location
    )
}