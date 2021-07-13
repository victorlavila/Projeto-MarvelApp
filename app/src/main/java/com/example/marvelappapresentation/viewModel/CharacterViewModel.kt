package com.example.marvelappapresentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelappapresentation.data.characterModel.Result
import com.example.marvelappapresentation.data.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

class CharacterViewModel(
  //  private val response : CharacterUseCase
) : ViewModel() {

    val listMutableCharacter = MutableLiveData<List<Result>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    private val response = CharacterRepository()

    init {
        findCharacterResponse()
    }

    fun findCharacterResponse() = CoroutineScope(IO).launch {
        loading.postValue(true)
        try {
            response.getCharacterService().let { characterResponse ->
                listMutableCharacter.postValue(characterResponse.data.results)
                loading.postValue(false)
            }

        }catch (error: Throwable){
            loading.postValue(false)
            handleError(error)
        }
    }

    private fun handleError(error: Throwable) {
        when(error){
            is HttpException -> errorMessage.postValue("Erro de conexão código: ${error.code()}")
            is UnknownHostException -> errorMessage.postValue("Verifique sua conexão")
        }

    }
}