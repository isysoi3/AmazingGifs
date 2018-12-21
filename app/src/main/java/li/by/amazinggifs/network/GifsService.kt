package li.by.amazinggifs.network

import li.by.amazinggifs.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface GifsService {
    @GET("/v1/gifs/trending")
    fun getTrendingGifs(@Query("offset") offset: Int): Call<Data>
}