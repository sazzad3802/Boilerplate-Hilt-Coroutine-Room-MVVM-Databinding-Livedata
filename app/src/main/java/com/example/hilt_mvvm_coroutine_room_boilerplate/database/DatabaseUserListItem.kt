package com.example.hilt_mvvm_coroutine_room_boilerplate.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hilt_mvvm_coroutine_room_boilerplate.domain.UserListItem

@Entity
data class DatabaseUserListItem(
    @PrimaryKey
    val id: Int,
    val avatar: String,
    val username: String
)

fun List<DatabaseUserListItem>.asDomainModel(): List<UserListItem> {
    return map {
        UserListItem(
            id = it.id,
            avatar = it.avatar,
            username = it.username
        )
    }
}