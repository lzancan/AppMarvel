package com.br.marvelapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.marvelapp.ui.activity.MainActivity
import com.br.marvelapp.databinding.CharacterListFragmentBinding
import com.br.marvelapp.http.RetrofitCallObject
import com.br.marvelapp.ui.adapter.CharacterRecyclerAdapter
import com.br.marvelapp.viewmodel.MainViewModel

class CharacterListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    var visibleItemCount = 0
    var totalItemCount = 0
    var pastVisiblesItems = 0
    var loading = true


    companion object {
        fun newInstance(viewModel: MainViewModel): CharacterListFragment {
            val fragment = CharacterListFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RetrofitCallObject.loadMarvelCharacters(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : CharacterListFragmentBinding = CharacterListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerViewCharacters.adapter = CharacterRecyclerAdapter(activity as MainActivity, ArrayList())
        val linearLayoutManager = LinearLayoutManager(activity)
        binding.recyclerViewCharacters.layoutManager = linearLayoutManager
        binding.recyclerViewCharacters.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0){
                    visibleItemCount = linearLayoutManager.childCount
                    totalItemCount = linearLayoutManager.itemCount
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition()

                    if (!viewModel.loadingVisibility.get()) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            RetrofitCallObject.loadMarvelCharacters(viewModel)
                        }
                    }
                }
            }
        })
        return binding.root
    }

}
