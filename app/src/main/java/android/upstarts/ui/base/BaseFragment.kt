package android.upstarts.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

open class BaseFragment: Fragment() {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    fun launch(action: suspend () -> Unit) {
        scope.launch {
            action()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}