package android.upstarts.util.extension

import android.upstarts.R
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.math.floor
import kotlin.math.roundToInt

@BindingAdapter("imageUrl")
fun ImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
            )
            .into(this)
    }
}

private fun roundDouble(num: Double): Any {
    return when (Math.abs(num) % 1.0 > 1e-10) {
        false -> num.roundToInt()
        else -> num
    }
}

@BindingAdapter("formatPrice")
fun TextView.formatPrice(price: Double?) {
    price?.let {
        val thousands = floor(price.div(1000.0))

        val hundreds = price.rem(1000.0)

        val unitPrice = resources.getString(R.string.unitOfPrice)
        val priceString: String

        val roundedThousands: Any = roundDouble(thousands)
        val roundedHundreds: Any = roundDouble(hundreds)

        priceString = when(thousands > 0.99) {
            true -> resources.getString(R.string.priceWithThousands, roundedThousands, roundedHundreds, unitPrice)
            else -> resources.getString(R.string.priceWithoutThousands, roundedHundreds, unitPrice)
        }
        text = priceString
    }
}

@BindingAdapter("formatNewLabel")
fun TextView.formatNewLabel(new: Boolean) {
    when (new) {
        true -> {
            val labelText = resources.getString(R.string.newLabelText)
            text = labelText
        }
    }
}