package li.by.amazinggifs.utils

import android.graphics.Color
import java.util.*


private val random = Random()
fun getRandomHSVColor(): Int {
    val hue = random.nextInt(361)
    val saturation = 1.0f
    val value = 1.0f
    val alpha = 255
    return Color.HSVToColor(alpha, floatArrayOf(hue.toFloat(), saturation, value))
}