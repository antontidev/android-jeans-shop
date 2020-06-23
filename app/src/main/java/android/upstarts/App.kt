package android.upstarts

import android.app.Application
import android.upstarts.di.components.AppComponent
import android.upstarts.di.components.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}