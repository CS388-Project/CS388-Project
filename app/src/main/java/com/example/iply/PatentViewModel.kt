package com.example.iply

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class PatentViewModel : ViewModel() {
    private val repository = PatentRepository()

    // 특허 데이터를 가져오는 메서드
    fun fetchPatents(ds: String, query: String) = liveData(Dispatchers.IO) {
        try {
            val patents = repository.fetchPatents(ds, query)
            emit(patents)
        } catch (e: Exception) {
            emit(emptyList()) // 예외 발생 시 빈 리스트 반환
        }
    }

}
