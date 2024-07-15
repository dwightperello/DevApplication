package com.example.devopsapplicatioin

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class DevOpsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCenter.start(
            this, "183aaa0e-5a40-4e48-beb6-c42be195c83d",
            Analytics::class.java, Crashes::class.java
        )
    }
}