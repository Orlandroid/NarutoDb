package com.example.presentation.extensions

import android.app.Activity
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.presentation.R
import java.lang.Error


fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(urlImage: String, @DrawableRes imageOnError: Int? = null) {
    if (imageOnError == null) {
        Glide.with(context).load(urlImage).transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.clans)
            .into(this)
    } else {
        Glide.with(context).load(urlImage).transition(DrawableTransitionOptions.withCrossFade())
            .error(imageOnError)
            .error(R.drawable.clans)
            .into(this)
    }
}

fun ImageView.setColorFilterImage(context: Context, @ColorRes colorInt: Int) {
    this.setColorFilter(
        ContextCompat.getColor(context, colorInt), PorterDuff.Mode.SRC_OVER
    )
}

@RequiresApi(Build.VERSION_CODES.M)
fun Drawable.tint(context: Context, @ColorRes color: Int) {
    DrawableCompat.setTint(this, context.resources.getColor(color, context.theme))
}









