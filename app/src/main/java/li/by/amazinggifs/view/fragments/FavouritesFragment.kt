package li.by.amazinggifs.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import li.by.amazinggifs.R
import li.by.amazinggifs.viewmodel.FavouriteFragmentViewModel

class FavouritesFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_favourite, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model =  ViewModelProviders.of(this).get(FavouriteFragmentViewModel::class.java)
    }
}