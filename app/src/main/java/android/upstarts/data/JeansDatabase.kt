package android.upstarts.data

import android.content.Context
import android.upstarts.domain.model.JeansModel
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * A database that stores SleepNight information.
 * And a global method to get access to the database.
 *
 * This pattern is pretty much the same for any database,
 * so you can reuse it.
 */
@Database(entities = [FavoriteJeans::class], version = 1, exportSchema = false)
abstract class JeansDatabase : RoomDatabase() {
    abstract val jeansDatabaseDao: JeansDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: JeansDatabase? = null

        fun getInstance(context: Context): JeansDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        JeansDatabase::class.java,
                        "jeans_favorite_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
