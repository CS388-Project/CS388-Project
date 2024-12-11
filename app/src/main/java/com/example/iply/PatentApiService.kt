import com.example.iply.PatentApiResponses

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface PatentApiService {

    @GET("/s")
    suspend fun getPatents(
        @Query("ds") ds: String,
        @Query("q") query: String
    ): Response<PatentApiResponses>

}