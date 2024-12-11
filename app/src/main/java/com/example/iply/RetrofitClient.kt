import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.Key
import java.util.Properties

object RetrofitClient {
    private const val BASE_URL = "https://global-patent1.p.rapidapi.com/"
    private val apiKey: String = "ae2f1d02dfmshd9f355de26bcfdcp1bdf25jsncb0b7f7f1a16"
    /*
        private val apiKey: String by lazy {
        val properties = Properties()
        val inputStream = RetrofitClient::class.java.classLoader?.getResourceAsStream("apikey.properties")
        properties.load(inputStream)
        val key = properties.getProperty("API_KEY", "")
        Log.d("RetrofitClient", "Loaded API Key: $key")
        key
    }
    */
    // Interceptor로 헤더 추가
    private val headerInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("x-rapidapi-key", apiKey)
            .addHeader("x-rapidapi-host", "global-patent1.p.rapidapi.com")
            .build()

        Log.d("RetrofitClient", "Headers: ${request.headers}")
        chain.proceed(request)
    }


    // LoggingInterceptor 추가
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // 요청 및 응답의 전체 내용을 로그로 출력
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor) // Interceptor 추가
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient) // OkHttpClient 연결
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val patentApiService: PatentApiService = retrofit.create(PatentApiService::class.java)
}
