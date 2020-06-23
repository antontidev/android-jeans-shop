package android.upstarts.domain.interactors

import android.upstarts.domain.EndpointApi
import android.upstarts.domain.model.JeansModel
import javax.inject.Inject
import kotlin.math.log

class GetJeansUseCase @Inject constructor(
    private val endpointApi: EndpointApi
) {
    suspend operator fun invoke() = endpointApi.getRemoteJeans()
}