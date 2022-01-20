package br.com.wesjon.compose2048.business

data class Coordinate(
    val row: Int,
    val col: Int,
    val value: Int,
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int
)