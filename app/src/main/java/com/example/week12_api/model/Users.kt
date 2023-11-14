package com.example.week12_api.model

data class Users(
    val result: List<ResultItem?>? = null
)

data class ResultItem(
    val image: String? = null,
    val id: Int? = null,
    val title: String? = null
)

