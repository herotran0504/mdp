package miu.mdp.assignment7.animal.ui.speciesdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import miu.mdp.assignment7.animal.data.repository.SpeciesRepository
import miu.mdp.assignment7.animal.model.Species
import javax.inject.Inject

@HiltViewModel
internal class SpeciesViewModel @Inject constructor(
    private val repository: SpeciesRepository
) : ViewModel() {

    val fetchResult = repository.getSpecies().asLiveData()

    fun insertSpecies(species: Species) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertSpecies(species)
        }
    }

}
