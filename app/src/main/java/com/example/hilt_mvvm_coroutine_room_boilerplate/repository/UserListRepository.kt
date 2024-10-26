package com.example.hilt_mvvm_coroutine_room_boilerplate.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.hilt_mvvm_coroutine_room_boilerplate.database.UsersDatabase
import com.example.hilt_mvvm_coroutine_room_boilerplate.database.asDomainModel
import com.example.hilt_mvvm_coroutine_room_boilerplate.domain.UserListItem
import com.example.hilt_mvvm_coroutine_room_boilerplate.network.UserListService
import com.example.hilt_mvvm_coroutine_room_boilerplate.network.model.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class UserListRepository @Inject constructor(
    private val userListService: UserListService,
    private val database: UsersDatabase
) {

    val users: LiveData<List<UserListItem>?> = database.usersDao.getDatabaseUsers().map { it?.asDomainModel() }

    suspend fun refreshUserList() {
        try {
            val users = userListService.getUserList()
            database.usersDao.insertAll(users.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}