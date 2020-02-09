package com.br.marvelapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.marvelapp.ui.activity.MainActivity
import com.br.marvelapp.databinding.CharacterListFragmentBinding
import com.br.marvelapp.ui.adapter.CharacterRecyclerAdapter
import com.br.marvelapp.viewmodel.MainViewModel

class CharacterListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance(viewModel: MainViewModel): CharacterListFragment {
            val fragment = CharacterListFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : CharacterListFragmentBinding = CharacterListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerViewCharacters.adapter = CharacterRecyclerAdapter(activity as MainActivity, ArrayList())
        binding.recyclerViewCharacters.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }

}
