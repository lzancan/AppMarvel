package com.br.marvelapp.model

class ThumbnailObject(var path: String, var extension: String){
    fun getUrl(): String{
        return "$path.$extension"
    }
}