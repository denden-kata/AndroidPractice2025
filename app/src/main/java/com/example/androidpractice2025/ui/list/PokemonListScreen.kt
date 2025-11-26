package com.example.androidpractice2025.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidpractice2025.data.PokemonSummary

// TODO サンプルの値なので本実装では消す
val pokemonSummarys: List<PokemonSummary> = listOf(
    PokemonSummary(
        id = 1,
        name = "test_name",
        imageUrl = "test_imageUrl"
    )
)

/**
 * ポケモン概要一覧のレイアウト.
 * @param onNavigateToDetail 詳細画面への遷移.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    onNavigateToDetail: (Int) -> Unit,
) {
    // 画面のレイアウトを作成する
    Scaffold(
        topBar = {
            // アプリバーを作成する
            TopAppBar(
                title = { Text("ポケモン図鑑") }
            )
        }
    ) { innerPadding ->
        // アプリバーをのぞいた余白を渡す
        Column(
            modifier = Modifier
                // アプリバーの真下に重ならないように調整する
                .padding(innerPadding)
                .padding(16.dp)
                // 残りの余白をすべて使う
                .fillMaxSize()
        ){
            Text(
                text = "ポケモン一覧",
                style = MaterialTheme.typography.titleMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(pokemonSummarys) { pokemonSummary ->
                    PokemonRecordCard(
                        pokemonSummary = pokemonSummary,
                        onClick = {
                            onNavigateToDetail(pokemonSummary.id)
                        }
                    )
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}

/**
 * カード.
 * @param PokemonSummary ポケモン概要.
 * @param onClick 詳細画面への遷移.
 */
@Composable
fun PokemonRecordCard(
    pokemonSummary: PokemonSummary,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "名前")
            Text(
                text = pokemonSummary.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}