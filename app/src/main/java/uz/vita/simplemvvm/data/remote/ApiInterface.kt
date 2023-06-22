package uz.vita.simplemvvm.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiInterface {

    @GET
    suspend fun getUserCard(
        @Header("Authorization") authToken: String
    ): Response<Boolean>

}