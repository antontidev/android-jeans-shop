package android.upstarts.viewmodel

import android.upstarts.data.FavoriteJeans
import android.upstarts.domain.interactors.GetFavoriteUseCase
import android.upstarts.domain.interactors.GetJeansUseCase
import android.upstarts.domain.model.JeansModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CatalogViewModel @Inject constructor(
    private val getJeansUseCase: GetJeansUseCase,
    private val getFavoriteUseCase: GetFavoriteUseCase
): BaseViewModel() {
    private val _favorites = getFavoriteUseCase()
    val favorites: LiveData<List<FavoriteJeans>>
        get() = _favorites

    private var _jeans: MutableLiveData<List<JeansModel>>
    val jeans: LiveData<List<JeansModel>>
        get() = _jeans

    init {
        var allJeans: List<JeansModel> = listOf()
        launch {
            allJeans = getJeansUseCase()
        }
        _jeans = MutableLiveData(allJeans)
    }
}