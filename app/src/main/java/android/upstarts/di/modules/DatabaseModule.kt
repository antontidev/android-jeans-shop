package android.upstarts.di.modules

import android.app.Application
import android.content.Context
import android.upstarts.data.JeansDatabase
import android.upstarts.data.JeansDatabaseDao
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesRoomDatabase(context: Context): JeansDatabase {
        return JeansDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun providesProductDao(jeansDatabase: JeansDatabase): JeansDatabaseDao {
        return jeansDatabase.jeansDatabaseDao
    }
}