package com.upgrade.doctriod.view

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

class Utils {

    companion object  {
        fun getProgressDrawable(context : Context) : CircularProgressDrawable {
            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.strokeWidth = 10f
            circularProgressDrawable.centerRadius = 50f
            circularProgressDrawable.start()
            return circularProgressDrawable
        }
    }
}