package com.br.marvelapp.http

import android.util.Log
import com.br.marvelapp.CryptoKeyUtils
import com.br.marvelapp.model.APIModel
import com.br.marvelapp.ui.main.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitObject {

    private var baseUrl = "https://gateway.marvel.com/v1/public/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val service = retrofit.create(APIInterface::class.java)

    fun loadMarvelCharacters(viewModel: MainViewModel) {
        val ts = Calendar.getInstance().timeInMillis
        val hash = CryptoKeyUtils.md5("$ts${CryptoKeyUtils.privateKey}${CryptoKeyUtils.publicKey}")
        service.listAllCharacters(ts.toString(), CryptoKeyUtils.publicKey, hash).enqueue(object: Callback<APIModel> {
            override fun onFailure(call: Call<APIModel>, t: Throwable) {
                Log.e("Failure", t.toString())
            }

            override fun onResponse(call: Call<APIModel>, response: Response<APIModel>) {
                Log.d("Response", response.code().toString())
                if (response.body() != null) {
                    viewModel.characterList.clear()
                    viewModel.characterList.addAll(response.body()!!.data.results)
                }
            }
        })
    }
}