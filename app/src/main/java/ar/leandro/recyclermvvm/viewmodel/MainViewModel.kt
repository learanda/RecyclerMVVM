package ar.leandro.recyclermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.leandro.recyclermvvm.domain.data.network.Repo
import ar.leandro.recyclermvvm.model.Animal

class MainViewModel: ViewModel() {

    private val repo = Repo()
    fun fetchAnimalData():LiveData<MutableList<Animal>>{
        val mutableData = MutableLiveData<MutableList<Animal>>()
        repo.getAnimalData().observeForever { animalList ->
            mutableData.value = animalList
        }

        return mutableData
    }

}