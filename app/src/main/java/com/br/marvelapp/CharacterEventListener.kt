package com.br.marvelapp

import com.br.marvelapp.model.CharacterModel

interface CharacterEventListener {
    fun clickCharacter(character: CharacterModel)
}