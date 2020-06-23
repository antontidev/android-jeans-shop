package android.upstarts.data

import android.upstarts.domain.model.JeansModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface JeansDatabaseDao {
    @Insert
    fun insert(id: FavoriteJeans)

    @Query("DELETE FROM jeans_favorite_table")
    fun clear()

    @Query("SELECT * FROM jeans_favorite_table ORDER BY id DESC")
    fun getAllFavorite(): LiveData<List<FavoriteJeans>>
}

