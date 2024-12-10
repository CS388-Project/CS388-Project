import com.example.iply.PatentApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PatentApiService {

    // 특허 검색 API
    @GET("/search")
    fun searchPatents(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Call<PatentApiResponse>
}
