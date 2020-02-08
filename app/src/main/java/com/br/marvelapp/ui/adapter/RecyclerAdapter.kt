package com.br.marvelapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.br.marvelapp.AdapterItemsContract
import com.br.marvelapp.R
import com.br.marvelapp.databinding.CharacterItemBinding
import com.br.marvelapp.model.CharacterModel
import com.bumptech.glide.Glide

class RecyclerAdapter(private val context: Context, var items: List<CharacterModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(),
    AdapterItemsContract {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CharacterItemBinding = CharacterItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<CharacterModel>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        Glide.with(context).load(items[position].thumbnail?.path + "." + items[position].thumbnail?.extension).error(R.drawable.ic_error).into(holder.binding.itemBackground)

    }

    class ViewHolder(val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(characterModel: CharacterModel) {
            binding.character = characterModel
            binding.executePendingBindings()
        }
    }
}