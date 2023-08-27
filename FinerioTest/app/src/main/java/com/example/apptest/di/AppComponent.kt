package com.example.apptest.di

import com.example.apptest.ui.MainActivity
import dagger.Component
import ui.LoginActivity
import javax.inject.Singleton

@Component(modules = [UserRepositoryModule::class, MovementsRepositoryModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: LoginActivity)
    fun inject(activity: MainActivity)

}