package com.example.devopsapplicatioin

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class DevOpsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCenter.start(
            this, "173f60d7-6498-48e5-b32b-3fc5d06d82f8",
            Analytics::class.java, Crashes::class.java
        )
    }
}