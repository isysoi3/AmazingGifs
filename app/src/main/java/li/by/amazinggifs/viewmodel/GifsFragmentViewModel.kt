package li.by.amazinggifs.viewmodel

import androidx.lifecycle.ViewModel
import li.by.amazinggifs.model.GifsRepository


class GifsFragmentViewModel : ViewModel() {

    val gifs = GifsRepository.gifs
    var loading = false

    fun nextGifs(offset: Int) {
        loading = true
        GifsRepository.loadNextGifs(offset)
    }
}