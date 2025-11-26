package com.example.androidpractice2025.data

/**
 * データクラス.
 */
data class PokemonSummary(
    val id: Int,
    val name: String,
    val imageUrl: String?, // 一覧用の小さめ画像
)