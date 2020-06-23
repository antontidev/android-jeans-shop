package android.upstarts.domain.interactors

import android.upstarts.data.JeansDatabaseDao
import javax.inject.Inject

class GetFavoriteUseCase @Inject constructor(
    private val databaseDao: JeansDatabaseDao
) {
    operator fun invoke() = databaseDao.getAllFavorite()
}