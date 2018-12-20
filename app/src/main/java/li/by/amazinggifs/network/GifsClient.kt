package li.by.amazinggifs.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val GIPHS_BASE_URL = "http://api.giphy.com/"
private const val API_KEY = "lazMNUSivKpaejYShKoRtoJuvG8Bydfx"
private const val API_KEY_PARAMETER = "api_key"

object GifsClient {
    var gifsService: GifsService

    init {
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
            .addInterceptor {
                val original = it.request()
                val originalHttpUrl = original.url()
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter(API_KEY_PARAMETER, API_KEY)
                    .build()
                val requestBuilder = original.newBuilder()
                    .url(url)
                val request = requestBuilder.build()
                it.proceed(request)
            }
            .addInterceptor(logger)
            .build()
        val retrofit = Retrofit.Builder().baseUrl(GIPHS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
        gifsService = retrofit.create(GifsService::class.java)
    }
}