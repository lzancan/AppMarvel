package com.br.marvelapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.marvelapp.databinding.MainFragmentBinding
import com.br.marvelapp.ui.adapter.RecyclerAdapter

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance(viewModel: MainViewModel): MainFragment {
            val fragment = MainFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : MainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerViewCharacters.adapter = RecyclerAdapter(context!!, ArrayList())
        binding.recyclerViewCharacters.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }

}
