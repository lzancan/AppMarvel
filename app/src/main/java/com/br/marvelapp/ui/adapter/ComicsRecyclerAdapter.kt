package com.br.marvelapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.marvelapp.AdapterItemsContract
import com.br.marvelapp.databinding.ComicsItemBinding
import com.br.marvelapp.model.ComicItemModel

class ComicsRecyclerAdapter(var items: List<ComicItemModel>) : RecyclerView.Adapter<ComicsRecyclerAdapter.ViewHolder>(),
    AdapterItemsContract {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ComicsItemBinding = ComicsItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(list: List<*>) {
        this.items = list as List<ComicItemModel>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(private val binding: ComicsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(comicItemModel: ComicItemModel) {
            binding.comic = comicItemModel
            binding.executePendingBindings()
        }
    }
}