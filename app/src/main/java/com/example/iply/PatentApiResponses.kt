package com.example.iply

data class PatentApiResponses (
    val took: Int,
    val total: Int,
    val code: Int,
    val success: Boolean,
    val nextPage: Int?,
    val totalPages: Int,
    val patents: List<PatentResponse>
)

data class PatentResponse(
    val id: String,
    val title: String,
    val summary: String,
    val applicationDate: String,
    val inventor: String
)