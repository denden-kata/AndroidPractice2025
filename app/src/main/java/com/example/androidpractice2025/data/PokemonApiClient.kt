package com.example.androidpractice2025.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit のインスタンスを 1 つだけ保持するオブジェクト.
 */
object PokemonApiClient {

    private val retrofit: Retrofit = Retrofit.Builder()
        // PokéAPI のベースURL
        .baseUrl("https://pokeapi.co/api/v2/")
        // JSON <-> data class の変換
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // API インターフェイスの実装を生成
    val apiService: PokemonApiService = retrofit.create(PokemonApiService::class.java)
}