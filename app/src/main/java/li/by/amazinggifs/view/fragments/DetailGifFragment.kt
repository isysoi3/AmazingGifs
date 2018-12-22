package li.by.amazinggifs.view.fragments

import android.graphics.Color
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_detail_gif.*
import li.by.amazinggifs.R
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.model.GifsDataBaseRepository
import li.by.amazinggifs.model.database.GifDatabaseModel
import li.by.amazinggifs.utils.loadGif
import li.by.amazinggifs.viewmodel.DetailGifFragmentViewModel


private const val GIF_KEY = "GIF_KEY"

class DetailGifFragment : Fragment() {


    companion object {
        fun newInstance(gif: Gif): DetailGifFragment {
            val fragment = DetailGifFragment()
            fragment.arguments = bundleOf(GIF_KEY to gif)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_detail_gif, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model = ViewModelProviders.of(this).get(DetailGifFragmentViewModel::class.java)
        val gif = arguments?.get(GIF_KEY) as? Gif
        gif?.let {
            imageDetail.loadGif(it.images.fixedWidth.url, context!!)
        }

        model.gif = gif!!

        model.gifs.observe(this, Observer {
            it?.let { itList: List<GifDatabaseModel> ->
                itList.forEach {
                    if (it.pathURL == model.gif.images.fixedWidth.url) {
                        model.isAdded = true
                        imageButtonStar.setColorFilter(Color.RED)
                    }
                }
                if (!model.isAdded) {
                    imageButtonStar.setColorFilter(Color.BLACK)
                }
            }
        })

        imageButtonStar.setOnClickListener {
            if (model.isAdded) {
                model.removeFromFavorites()
                imageButtonStar.setColorFilter(Color.BLACK)
            } else {
                model.addToFavorites()
                imageButtonStar.setColorFilter(Color.RED)
            }
        }

        imageViewShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            val toShare = "Look at gif : ${gif?.images?.fixedWidth?.url}"
            sendIntent.putExtra(Intent.EXTRA_TEXT, toShare)
            sendIntent.type = "text/plain"
            context!!.startActivity(sendIntent)
        }
    }
}
