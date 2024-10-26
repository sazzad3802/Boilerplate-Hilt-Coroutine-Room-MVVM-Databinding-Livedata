package com.example.hilt_mvvm_coroutine_room_boilerplate.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.hilt_mvvm_coroutine_room_boilerplate.database.UsersDatabase
import com.example.hilt_mvvm_coroutine_room_boilerplate.database.asDomainModel
import com.example.hilt_mvvm_coroutine_room_boilerplate.domain.UserDetails
import com.example.hilt_mvvm_coroutine_room_boilerplate.network.UserDetailsService
import com.example.hilt_mvvm_coroutine_room_boilerplate.network.model.asDatabaseModel
import timber.log.Timber
import javax.inject.Inject

class UserDetailsRepository @Inject constructor(
    private val userDetailsService: UserDetailsService,
    private val database: UsersDatabase
) {

    fun getUserDetails(user: String): LiveData<UserDetails?> {
        return database.usersDao.getUserDetails(user).map { it?.asDomainModel() }
    }


    suspend fun refreshUserDetails(user: String) {
        try {
            val userDetails = userDetailsService.getUserDetails(user)
            database.usersDao.insertUserDetails(userDetails.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }

}