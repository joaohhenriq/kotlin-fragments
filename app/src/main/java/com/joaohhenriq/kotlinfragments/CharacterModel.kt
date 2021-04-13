package com.joaohhenriq.kotlinfragments

import java.io.Serializable

data class CharacterModel(
    val name: String,
    val description: String,
    val imageResId: Int
) : Serializable