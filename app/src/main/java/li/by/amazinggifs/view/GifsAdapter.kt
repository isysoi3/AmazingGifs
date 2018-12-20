package li.by.amazinggifs.view

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import li.by.amazinggifs.R
import li.by.amazinggifs.model.FIXED_WIDTH
import li.by.amazinggifs.model.Gif
import li.by.amazinggifs.utils.getRandomHSVColor


class GifsAdapter(val context: Context) : RecyclerView.Adapter<GifsAdapter.MyViewHolder>() {

    private val screenWidthDP: Float

    init {
        val displayMetrics = context.resources.displayMetrics
        screenWidthDP = displayMetrics.widthPixels / displayMetrics.density
    }

    var gifs = ArrayList<Gif>()
        set(value) {
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false) as ImageView
        val vh = MyViewHolder(v)

        vh.imageView.setBackgroundColor(getRandomHSVColor())
        return vh
    }

    override fun getItemCount() = gifs.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val height = gifs[position].images.fixedWidth.height
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            height * screenWidthDP / (2 * FIXED_WIDTH),
            context.resources.displayMetrics
        )
        holder.imageView.layoutParams.height = px.toInt()

        Glide.with(context)
            .load(gifs[position].images.fixedWidth.url)
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
            .into(holder.imageView)
    }


    class MyViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)
}