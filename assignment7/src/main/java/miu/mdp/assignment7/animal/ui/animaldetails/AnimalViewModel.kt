package miu.mdp.assignment7.animal.ui.animaldetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import miu.mdp.assignment7.animal.data.Result
import miu.mdp.assignment7.animal.data.repository.AnimalRepository
import miu.mdp.assignment7.animal.model.Animal
import javax.inject.Inject

@HiltViewModel
internal class AnimalViewModel @Inject constructor(
    private val repository: AnimalRepository
) : ViewModel() {

    val fetchResult: LiveData<Result<List<Animal>>> = repository.getAnimals().asLiveData()

    private val _insertResult = MutableLiveData<Result<Unit>>()
    val insertResult: LiveData<Result<Unit>> = _insertResult

    fun insertAnimal(animal: Animal) {
        viewModelScope.launch {
            _insertResult.postValue(repository.insertAnimal(animal))
        }
    }
}
