package android.upstarts.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jeans_favorite_table")
data class FavoriteJeans(
    @PrimaryKey
    val id: Long
)