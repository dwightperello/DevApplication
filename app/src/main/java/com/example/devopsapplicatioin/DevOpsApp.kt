package com.example.devopsapplicatioin

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class DevOpsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCenter.start(
            this, "9618766f-b578-471c-8810-0e90958008af",
            Analytics::class.java, Crashes::class.java
        )
    }
}