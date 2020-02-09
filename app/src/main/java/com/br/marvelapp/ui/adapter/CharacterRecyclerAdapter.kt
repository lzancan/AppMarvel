package com.br.marvelapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.marvelapp.AdapterItemsContract
import com.br.marvelapp.CharacterEventListener
import com.br.marvelapp.ui.activity.MainActivity
import com.br.marvelapp.databinding.CharacterItemBinding
import com.br.marvelapp.model.CharacterModel


class CharacterRecyclerAdapter(private val context: MainActivity, var items: List<CharacterModel>) : RecyclerView.Adapter<CharacterRecyclerAdapter.ViewHolder>(),
    AdapterItemsContract{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: CharacterItemBinding = CharacterItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(list: List<*>) {
        this.items = list as List<CharacterModel>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, items[position])

    }

    class ViewHolder(private val binding: CharacterItemBinding): RecyclerView.ViewHolder(binding.root),
        CharacterEventListener {

        var context: MainActivity? = null

        fun bind(context: MainActivity, characterModel: CharacterModel) {
            this.context = context
            binding.character = characterModel
            binding.itemClickListener = this
            binding.executePendingBindings()
        }

        override fun clickCharacter(character: CharacterModel) {
            if (context is MainActivity && context != null) {
                context!!.goToDetailsFragment(character)
            }
        }
    }

}