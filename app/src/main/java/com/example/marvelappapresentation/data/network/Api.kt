package com.example.marvelappapresentation.data.network

import com.example.marvelappapresentation.data.characterModel.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("characters")
    suspend fun getResponseCharacter(
        @Query("offset") offset: Int?,
        @Query("orderBy") orderBy: String?,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?,
        @Query("limit") limit: Int?
    ) : CharacterResponse

}