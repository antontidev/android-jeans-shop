package android.upstarts.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    fun launch(action: suspend () -> Unit) {
        scope.launch {
            action()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}