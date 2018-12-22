package li.by.amazinggifs.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.model.GifsDataBaseRepository
import li.by.amazinggifs.model.database.GifDatabaseModel

//TODO : you need to work with it
// please implement logic in repository class
// in repository class work with database :)
class DetailGifFragmentViewModel : ViewModel() {


    lateinit var gif: Gif
    val gifs = GifsDataBaseRepository.getAllGifs()
    var isAdded = false

    fun addToFavorites() {
        if(!isAdded){
            GifsDataBaseRepository.insert(
                GifDatabaseModel(
                    gif.images.fixedWidth.url,
                    gif.title,
                    gif.images.fixedWidth.height
                )
            )
            isAdded = true
        }
    }

    fun removeFromFavorites() {
        if(isAdded){
            GifsDataBaseRepository.delete(
                GifDatabaseModel(
                    gif.images.fixedWidth.url,
                    gif.title,
                    gif.images.fixedWidth.height
                )
            )
            isAdded = false
        }
    }
}