package model

data class PokemonResponse(
    var count: Int,
    var next: String,
    var previous: Boolean,
    var results: List<Pokemon>
)
