package com.example.hilt_mvvm_coroutine_room_boilerplate.di

import android.content.Context
import androidx.room.Room
import com.example.hilt_mvvm_coroutine_room_boilerplate.database.UsersDao
import com.example.hilt_mvvm_coroutine_room_boilerplate.database.UsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): UsersDatabase {
        return Room.databaseBuilder(
            appContext,
            UsersDatabase::class.java,
            "Users"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideChannelDao(usersDatabase: UsersDatabase): UsersDao {
        return usersDatabase.usersDao
    }

}