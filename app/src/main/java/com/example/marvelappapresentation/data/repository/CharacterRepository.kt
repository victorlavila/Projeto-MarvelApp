package com.example.marvelappapresentation.data.repository

import com.example.marvelappapresentation.data.characterModel.CharacterResponse
import com.example.marvelappapresentation.data.network.Api
import com.example.marvelappapresentation.data.network.Retrofit
import com.example.marvelappapresentation.domain.utils.*

class CharacterRepository {

    val page: Int = 1
    val orderBy: String = "name"
    val limit: Int = 100

    private val service = Api::class
    private val heroesService = Retrofit(BASE_URL).create(service)

    suspend fun getCharacterService(): CharacterResponse = heroesService.getResponseCharacter(
        page,orderBy, TS, HASH, PUBLIC_KEY, limit
    )
}