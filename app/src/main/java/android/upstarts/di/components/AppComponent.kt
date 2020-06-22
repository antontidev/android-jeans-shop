package android.upstarts.di

import android.content.Context
import android.upstarts.di.modules.EndpointApiModule
import android.upstarts.ui.CatalogFragment
import android.upstarts.ui.DetailFragment
import android.upstarts.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        EndpointApiModule::class
    ]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(fragment: CatalogFragment)
    fun inject(fragment: DetailFragment)
    fun inject(activity: MainActivity)
}