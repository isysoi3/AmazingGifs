package li.by.amazinggifs.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction
import li.by.amazinggifs.R
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.view.fragments.DetailGifFragment
import li.by.amazinggifs.view.fragments.GifsFragment
import li.by.amazinggifs.model.database.AppDatabase
import androidx.room.Room
import li.by.amazinggifs.model.database.GifDatabaseModel


interface ShowGifDetailListener{
    fun onShowGif(gif: Gif)
}

class MainActivity : AppCompatActivity(), ShowGifDetailListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.transaction {
            replace(R.id.container, GifsFragment())
        }
    }

    override fun onShowGif(gif: Gif) {
        supportFragmentManager.transaction {
            replace(R.id.container, DetailGifFragment.newInstance(gif))
            addToBackStack(null)
        }
    }
}
