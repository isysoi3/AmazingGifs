package li.by.amazinggifs.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_gifs.*
import li.by.amazinggifs.R
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.view.GifsAdapter
import li.by.amazinggifs.view.RecyclerItemClickListener
import li.by.amazinggifs.view.ShowGifDetailListener
import li.by.amazinggifs.viewmodel.GifsFragmentViewModel


class GifsFragment : Fragment(){
    private var showGifDetailListener : ShowGifDetailListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
         = inflater.inflate(R.layout.fragment_gifs, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        showGifDetailListener = context as? ShowGifDetailListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model = ViewModelProviders.of(this).get(GifsFragmentViewModel::class.java)
        val adapter = GifsAdapter(context!!)

        recyclerViewGifs.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerViewGifs.adapter = adapter

        recyclerViewGifs.addOnItemTouchListener(object : RecyclerItemClickListener(context!!,
            recyclerViewGifs ,object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    showGifDetailListener?.onShowGif(adapter.gifs[position])
                }

                override fun onLongItemClick(view: View?, position: Int) { }

            }) {})

        model.nextGifs(0)
        model.gifs.observe(this, Observer {
            it?.let { itList: List<Gif> ->
                adapter.gifs = ArrayList(itList)
            }
        })
    }
}
