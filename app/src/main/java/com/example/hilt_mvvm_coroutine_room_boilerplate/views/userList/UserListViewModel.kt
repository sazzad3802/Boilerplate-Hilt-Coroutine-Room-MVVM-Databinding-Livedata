package com.example.hilt_mvvm_coroutine_room_boilerplate.views.userList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hilt_mvvm_coroutine_room_boilerplate.repository.UserListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userListRepository: UserListRepository
) : ViewModel() {

    val data = userListRepository.users

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userListRepository.refreshUserList()
        }
    }

}