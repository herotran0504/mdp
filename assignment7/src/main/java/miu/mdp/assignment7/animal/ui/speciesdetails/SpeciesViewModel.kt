package miu.mdp.assignment7.animal.ui.speciesdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import miu.mdp.assignment7.animal.data.Result
import miu.mdp.assignment7.animal.data.repository.SpeciesRepository
import miu.mdp.assignment7.animal.model.Species
import javax.inject.Inject

@HiltViewModel
internal class SpeciesViewModel @Inject constructor(
    private val repository: SpeciesRepository
) : ViewModel() {

    val fetchResult: LiveData<Result<List<Species>>> = repository.getSpecies().asLiveData()

    private val _insertResult = MutableLiveData<Result<Unit>>()
    val insertResult: LiveData<Result<Unit>> = _insertResult

    fun insertSpecies(species: Species) {
        viewModelScope.launch {
            _insertResult.postValue(repository.insertSpecies(species))
        }
    }

}
