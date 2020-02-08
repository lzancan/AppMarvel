package com.br.marvelapp.model

class APIModel {
    var code: Int = 0
    lateinit var status: String
    lateinit var copyright: String
    lateinit var attributionText: String
    lateinit var attributionHTML: String
    lateinit var data: APIDataModel
    lateinit var etag: String
}