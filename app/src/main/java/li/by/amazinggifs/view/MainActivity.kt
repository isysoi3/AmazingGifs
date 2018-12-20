package li.by.amazinggifs.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import li.by.amazinggifs.R
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        val adapter = GifsAdapter(this)


        recyclerViewGifs.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerViewGifs.adapter = adapter

        model.nextGifs(0)
        model.gifs.observe(this, Observer {
            it?.let { itList: List<Gif> ->
                adapter.gifs = ArrayList(itList)
            }
        })
    }
}
