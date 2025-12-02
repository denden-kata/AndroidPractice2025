package com.example.androidpractice2025.data

/**
 * PokéAPI レスポンス.
 */
data class PokemonListResponse(
    val results: List<PokemonListResult>
)

/**
 * 一件分のエントリ.
 * 例:
 * {
 *   "name": "bulbasaur",
 *   "url": "https://pokeapi.co/api/v2/pokemon/1/"
 * }
 * */
data class PokemonListResult(
    val name: String,
    val url: String,
)