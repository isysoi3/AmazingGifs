package li.by.amazinggifs.utils

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.util.*


private val random = Random()
fun getRandomHSVColor(): Int {
    val hue = random.nextInt(361)
    val saturation = 1.0f
    val value = 1.0f
    val alpha = 255
    return Color.HSVToColor(alpha, floatArrayOf(hue.toFloat(), saturation, value))
}


fun ImageView.loadGif(url:String, ctx: Context){
    Glide.with(ctx)
        .load(url)
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
        .into(this)
}