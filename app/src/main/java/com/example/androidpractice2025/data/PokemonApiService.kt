package com.example.androidpractice2025.data

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * PokéAPI と通信するためのインターフェイス.
 * Retrofit がこのインターフェイスの実装を自動生成してくれる.
 */
interface PokemonApiService {

    /**
     * ポケモン一覧を取得する.
     *
     * 例: GET /pokemon?limit=50&offset=0
     */
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0,
    ): PokemonListResponse
}