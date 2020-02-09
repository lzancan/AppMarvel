package com.br.marvelapp.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.br.marvelapp.model.CharacterModel

class MainViewModel : ViewModel() {

    var characterList = ObservableArrayList<CharacterModel>()
    var loadingVisibility = ObservableBoolean(false)
    var message = ObservableField<String>()

}
