package com.example.androidpractice2025.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidpractice2025.ui.detail.PokemonDetailScreen
import com.example.androidpractice2025.ui.list.PokemonListScreen

/**
 * ナビゲーション.
 */
@Composable
fun NavGraph() {
    // 画面遷移の実行コントローラ
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        // アプリ起動時に表示する「ポケモン概要一覧」のルート名
        startDestination = "pokemon_list"
    ) {
        /**
         * ポケモン概要一覧.
         */
        composable(route = "pokemon_list") {
            PokemonListScreen(
                onNavigateToDetail = { pokemonId: Int ->
                    navController.navigate("pokemon_detail/$pokemonId")
                }
            )
        }

        /**
         * ポケモン詳細.
         */
        composable(
            route = "pokemon_detail/{pokemonId}"
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments
                ?.getString("pokemonId")
                ?.toIntOrNull()

            PokemonDetailScreen(
                pokemonId = pokemonId,
                // 戻るボタンを押すと、「ポケモン概要一覧」に戻る
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}