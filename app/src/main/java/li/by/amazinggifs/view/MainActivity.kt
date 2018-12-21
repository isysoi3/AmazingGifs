package li.by.amazinggifs.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.transaction
import li.by.amazinggifs.R
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.view.fragments.DetailGifFragment
import li.by.amazinggifs.view.fragments.FavouritesFragment
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

    override fun onShowGif(gif: Gif) = changeFragment(DetailGifFragment.newInstance(gif))

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.action_favourites){
            changeFragment(FavouritesFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeFragment(fragment : Fragment){
        supportFragmentManager.transaction {
            replace(R.id.container, fragment)
            addToBackStack(null)
        }
    }
}
