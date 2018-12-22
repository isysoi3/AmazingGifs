package li.by.amazinggifs.viewmodel

import androidx.lifecycle.ViewModel
import li.by.amazinggifs.model.GifsDataBaseRepository


class FavouriteFragmentViewModel : ViewModel() {
    val gifs = GifsDataBaseRepository.getAllGifs()
}
