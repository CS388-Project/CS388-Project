package com.example.iply
import RetrofitClient

class PatentRepository {
    private val patentApiService = RetrofitClient.patentApiService

    // PatentResponse를 Patent로 변환하는 메서드
    private fun mapResponseToPatent(response: PatentResponse): Patent {
        return Patent(
            id = response.id,
            title = response.title,
            summary = response.summary,
            applicationDate = response.applicationDate,
            inventor = response.inventor
        )
    }

    // API 호출 후 Response에서 Patent 목록으로 변환
    suspend fun fetchPatents(ds: String = "us", query: String): List<Patent> {
        return try {
            val response = patentApiService.getPatents(ds, query)
            if (response.isSuccessful) {
                response.body()?.patents?.map { mapResponseToPatent(it) } ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

}
