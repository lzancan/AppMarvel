package com.br.marvelapp

import androidx.databinding.Observable
import com.br.marvelapp.http.RetrofitCallObject
import com.br.marvelapp.model.CharacterModel
import com.br.marvelapp.viewmodel.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun before() {
        viewModel = MainViewModel()
    }

    @Test
    fun getAllCharacters() {
        viewModel.loadingVisibility.set(true)
        val ts = Calendar.getInstance().timeInMillis
        val hash = CryptoKeyUtils.md5("$ts${CryptoKeyUtils.privateKey}${CryptoKeyUtils.publicKey}")
        assert(hash.isNotEmpty())
        assert(viewModel.loadingVisibility.get())
        val response = RetrofitCallObject.doApiCall(ts.toString(), hash).execute()
        val characters = response.body()?.data?.results
        assertEquals(200, response.code())
        assert(!characters.isNullOrEmpty())
        assert(characters!![0].name.isNotEmpty())
        assert(characters[0].thumbnail!!.getUrl().isNotEmpty())
        assert(characters[0].thumbnail!!.getUrl() != ".")

    }
}
