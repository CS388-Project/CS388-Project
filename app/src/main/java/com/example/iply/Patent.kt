package com.example.iply

data class Patent(
    val id: String,
    val title: String,
    val summary: String,
    val applicationDate: String,
    val inventor: String,
    var imageResId: Int = R.drawable.ic_placeholder_image
)

// API Response Wrapper
data class PatentApiResponse(
    val patents: List<Patent>,
    val page: Int,
    val totalPages: Int
)