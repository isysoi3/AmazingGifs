package li.by.amazinggifs.view.adapters

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import li.by.amazinggifs.R
import li.by.amazinggifs.model.FIXED_WIDTH
import li.by.amazinggifs.model.database.GifDatabaseModel
import li.by.amazinggifs.utils.getRandomHSVColor
import li.by.amazinggifs.utils.loadGif


class GifsDatabaseAdapter(val context: Context) : RecyclerView.Adapter<GifsDatabaseAdapter.MyViewHolder>() {

    private val screenWidthDP: Float

    init {
        val displayMetrics = context.resources.displayMetrics
        screenWidthDP = displayMetrics.widthPixels / displayMetrics.density
    }

    var gifs = ArrayList<GifDatabaseModel>()
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
        val height = gifs[position].height
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            height * screenWidthDP / (FIXED_WIDTH),
            context.resources.displayMetrics
        )
        holder.imageView.layoutParams.height = px.toInt()

        holder.imageView.loadGif(gifs[position].pathURL, context)
    }


    class MyViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)
}