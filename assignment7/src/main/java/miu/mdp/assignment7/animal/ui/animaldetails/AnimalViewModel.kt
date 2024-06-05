package miu.mdp.assignment7.animal.ui.animaldetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import miu.mdp.assignment7.animal.data.repository.AnimalRepository
import miu.mdp.assignment7.animal.model.Animal
import javax.inject.Inject

@HiltViewModel
internal class AnimalViewModel @Inject constructor(
    private val repository: AnimalRepository
) : ViewModel() {

    val fetchResult = repository.getAnimals().asLiveData()

    fun insertAnimal(animal: Animal) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAnimal(animal)
        }
    }
}
