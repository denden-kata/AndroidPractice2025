package com.example.androidpractice2025.data

object PokemonRepository {

    /**
     * ポケモン一覧を取得して PokemonSummary のリストに変換する.
     */
    suspend fun fetchPokemonSummaries(limit: Int = 50): List<PokemonSummary> {
        val response = PokemonApiClient.apiService.getPokemonList(limit = limit)

        return response.results.mapNotNull { result ->
            // 例: "https://pokeapi.co/api/v2/pokemon/25/" から "25" を抜き出す
            val id = extractIdFromUrl(result.url) ?: return@mapNotNull null

            PokemonSummary(
                id = id,
                // 先頭だけ大文字にして少し読みやすく
                name = result.name.replaceFirstChar { ch ->
                    if (ch.isLowerCase()) ch.titlecase() else ch.toString()
                },
                // 公式イラストの URL を ID から組み立てる
                imageUrl = buildImageUrl(id)
            )
        }
    }

    /**
     * PokéAPI の URL から ID を取り出す.
     *
     * 例: "https://pokeapi.co/api/v2/pokemon/25/" -> 25
     */
    private fun extractIdFromUrl(url: String): Int? {
        return url
            // 最後の '/' を削る
            .trimEnd('/')
            // "/" で分割
            .split("/")
            // 最後の要素を取る
            .lastOrNull()?.toIntOrNull()
    }

    /**
     * 公式イラストの URL を ID から作る.
     *
     * 例:
     * https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png
     */
    private fun buildImageUrl(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }
}