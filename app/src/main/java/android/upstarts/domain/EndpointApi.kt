package android.upstarts.domain

import android.upstarts.domain.model.JeansModel
import retrofit2.http.GET
import retrofit2.http.Path

interface EndpointApi {
    @GET("jeans/jeans-default.json")
    suspend fun getRemoteJeans(): List<JeansModel>
}