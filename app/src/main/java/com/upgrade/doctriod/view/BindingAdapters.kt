package com.upgrade.doctriod.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.upgrade.doctriod.R

class BindingAdapters {

    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, list: List<Any>) {

            recyclerView.adapter.let {
                if (it is AdapterItemsContract) {
                    it.replaceItems(list)
                }
            }
        }

        @BindingAdapter("imgSrc")
        @JvmStatic
        fun loadImage(view: ImageView, url: String) {
            val options = RequestOptions()
                .placeholder(Utils.getProgressDrawable(view.context))
                .error(R.mipmap.ic_launcher)

            Glide.with(view.context)
                .setDefaultRequestOptions(options)
                .load(url)
                .into(view)
        }
    }
}