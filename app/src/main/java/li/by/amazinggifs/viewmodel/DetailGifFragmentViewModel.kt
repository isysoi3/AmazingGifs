package li.by.amazinggifs.viewmodel

import androidx.lifecycle.ViewModel
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.model.GifsDataBaseRepository
import li.by.amazinggifs.model.database.GifDatabaseModel

//TODO : you need to work with it
// please implement logic in repository class
// in repository class work with database :)
class DetailGifFragmentViewModel: ViewModel() {

    lateinit var gif: Gif

    fun addToFavorites() {
        if (!isGifInFavorites()) {
            GifsDataBaseRepository.insert(GifDatabaseModel(gif.title, gif.images.fixedWidth.url))
        }
    }

    fun isGifInFavorites(): Boolean {
        val gifs = GifsDataBaseRepository.getAllGifs()

        gifs.forEach {
            if (it.pathURL == gif.images.fixedWidth.url && it.title == gif.title) {
                return true
            }
        }
        return false
    }

    fun removeFromFavorites() {
        GifsDataBaseRepository.delete(GifDatabaseModel(gif.title, gif.images.fixedWidth.url))
    }
}