package com.example.iply

data class Patent(
    val name: String,
    val imageResId: Int,
    /*
    val id: String,
    val title: String,
    val summary: String,
    val applicant: String,
    val applicationDate: String,
    val documentNumber: String,
    val documentDate: String,
    val currentAssignee: String?,
    val ipc: String,
    val imagePath: String? // 이미지 경로가 없을 경우를 대비해 nullable
    */
)

// API Response Wrapper
data class PatentApiResponse(
    val patents: List<Patent>,
    val page: Int,
    val totalPages: Int
)