package com.br.marvelapp.bind

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.br.marvelapp.AdapterItemsContract
import com.br.marvelapp.R
import com.bumptech.glide.Glide



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

        @BindingAdapter("loadGlideImage")
        @JvmStatic
        fun loadImage(view: ImageView, url: String) {
            val context = view.context
            Glide.with(context).load(url).error(
                R.drawable.ic_error
            ).into(view)
        }
    }

}