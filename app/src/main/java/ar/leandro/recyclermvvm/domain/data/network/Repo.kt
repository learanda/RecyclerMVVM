package ar.leandro.recyclermvvm.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ar.leandro.recyclermvvm.model.Animal
import com.google.firebase.firestore.FirebaseFirestore

class Repo {

    fun getAnimalData():LiveData<MutableList<Animal>>{
        val mutableData = MutableLiveData<MutableList<Animal>>()
        FirebaseFirestore.getInstance().collection("Animales").get().addOnSuccessListener { result ->
            val listData = mutableListOf<Animal>()
            for(document in result) {
                val nombre = document.getString("nombre")
                val imagen = document.getString("imagen")
                val animal = Animal(nombre!!, imagen!!)
                listData.add(animal)
            }
            mutableData.value = listData
        }
        return mutableData
    }

}