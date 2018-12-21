package li.by.amazinggifs.model

import androidx.lifecycle.MutableLiveData
import li.by.amazinggifs.network.GifsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object GifsRepository {
    val gifs = MutableLiveData<List<Gif>>()
    fun loadNextGifs(offset: Int) {
        GifsClient.gifsService.getTrendingGifs(offset).enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    gifs.postValue(response.body()?.gifs)
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                gifs.value = null
            }
        })
    }
}
