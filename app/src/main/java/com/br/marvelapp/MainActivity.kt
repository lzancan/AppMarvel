package com.br.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.marvelapp.http.RetrofitObject
import com.br.marvelapp.ui.main.MainFragment
import com.br.marvelapp.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, createFragment())
                .commitNow()
        }
        RetrofitObject.loadMarvelCharacters(viewModel)
    }

    private fun createFragment(): MainFragment {
        return MainFragment.newInstance(viewModel)
    }

}
