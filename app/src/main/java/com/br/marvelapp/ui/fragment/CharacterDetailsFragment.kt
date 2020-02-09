package com.br.marvelapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.marvelapp.databinding.CharacterDetailsBinding
import com.br.marvelapp.model.CharacterModel
import com.br.marvelapp.ui.adapter.ComicsRecyclerAdapter

class CharacterDetailsFragment: Fragment() {

    companion object {
        const val CHARACTER_SELECTED = "character_selected"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : CharacterDetailsBinding = CharacterDetailsBinding.inflate(inflater, container, false)
        val characterSelected: CharacterModel? = arguments?.getParcelable(CHARACTER_SELECTED) as CharacterModel?
        if(characterSelected != null) {
            binding.character = characterSelected
            binding.recyclerViewComics.adapter =
                ComicsRecyclerAdapter(characterSelected.comics?.items?:ArrayList())
            binding.recyclerViewComics.layoutManager = LinearLayoutManager(activity)
        }
        return binding.root
    }

}