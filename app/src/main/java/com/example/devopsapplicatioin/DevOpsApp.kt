package com.example.devopsapplicatioin

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class DevOpsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCenter.start(
            this, "75da5be4-4439-4541-8703-d4baa595fd9d",
            Analytics::class.java, Crashes::class.java
        )
    }
}