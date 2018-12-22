package li.by.amazinggifs.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_gifs.*
import li.by.amazinggifs.R
import li.by.amazinggifs.model.database.GifDatabaseModel
import li.by.amazinggifs.view.adapters.GifsDatabaseAdapter
import li.by.amazinggifs.viewmodel.FavouriteFragmentViewModel

class FavouritesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_gifs, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model = ViewModelProviders.of(this).get(FavouriteFragmentViewModel::class.java)

        val adapter = GifsDatabaseAdapter(context!!)
        recyclerViewGifs.adapter = adapter
        recyclerViewGifs.layoutManager = LinearLayoutManager(context!!)

        model.gifs.observe(this, Observer {
            it?.let { itList: List<GifDatabaseModel> ->
                adapter.gifs = ArrayList(itList)
            }
        })
    }
}