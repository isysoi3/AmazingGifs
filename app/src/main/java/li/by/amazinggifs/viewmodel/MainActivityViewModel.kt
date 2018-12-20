package li.by.amazinggifs.viewmodel

import androidx.lifecycle.ViewModel
import li.by.amazinggifs.model.GifsRepository


class MainActivityViewModel : ViewModel() {

    val gifs = GifsRepository.gifs

    fun nextGifs(offset: Int) {
        GifsRepository.loadNextGifs(offset)
    }
}