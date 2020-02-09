package com.br.marvelapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.br.marvelapp.http.RetrofitCallObject
import com.br.marvelapp.model.CharacterModel
import com.br.marvelapp.ui.fragment.CharacterDetailsFragment
import com.br.marvelapp.ui.fragment.CharacterListFragment
import com.br.marvelapp.viewmodel.MainViewModel
import com.br.marvelapp.R


class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    private var calledDetailsFragment = false

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        hideBackButton()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, createFragment())
                .commitNow()
        }
    }

    private fun createFragment(): CharacterListFragment {
        return CharacterListFragment.newInstance(viewModel)
    }

    fun goToDetailsFragment(character: CharacterModel) {
        if(!calledDetailsFragment) {
            showBackButton()
            val fragment = CharacterDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(CharacterDetailsFragment.CHARACTER_SELECTED, character)
            fragment.arguments = bundle
            addFragment(fragment)
        }
    }

    private fun showBackButton(){
        calledDetailsFragment = true
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun hideBackButton(){
        calledDetailsFragment = false
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    private fun addFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.container, fragment, fragment.toString())
        ft.addToBackStack(null)
        ft.commit()
    }

}
