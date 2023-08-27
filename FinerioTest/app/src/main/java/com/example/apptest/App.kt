package com.example.apptest

import android.app.Application
import android.content.ContextWrapper
import com.example.apptest.di.AppComponent
import com.example.apptest.di.DaggerAppComponent
import com.example.apptest.di.MovementsRepositoryModule
import com.example.apptest.di.UserRepositoryModule
import com.pixplicity.easyprefs.library.Prefs

class App : Application() {

    lateinit var appCompoment: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appCompoment = DaggerAppComponent.builder()
            .userRepositoryModule(UserRepositoryModule(this))
            .movementsRepositoryModule(MovementsRepositoryModule(this))
            .build()

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}