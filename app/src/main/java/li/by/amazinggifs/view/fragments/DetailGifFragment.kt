package li.by.amazinggifs.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_detail_gif.*
import li.by.amazinggifs.R
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.utils.loadGif
import li.by.amazinggifs.viewmodel.DetailGifFragmentViewModel


private const val GIF_KEY = "GIF_KEY"
class DetailGifFragment : Fragment() {

    companion object {
        fun newInstance(gif : Gif): DetailGifFragment {
            val fragment = DetailGifFragment()
            fragment.arguments = bundleOf(GIF_KEY to gif)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_detail_gif, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val model =  ViewModelProviders.of(this).get(DetailGifFragmentViewModel::class.java)
        val gif = arguments?.get(GIF_KEY) as? Gif
        gif?.let {
            imageDetail.loadGif(gif.images.fixedWidth.url, context!!)
        }
    }
}
