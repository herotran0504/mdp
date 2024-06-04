package miu.mdp.assignment2.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import miu.mdp.assignment2.data.ChemicalRepository
import miu.mdp.assignment2.model.Chemical
import javax.inject.Inject

@HiltViewModel
class ChemicalViewModel @Inject constructor(
    private val repository: ChemicalRepository
) : ViewModel() {

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _chemicals = MutableLiveData<List<Chemical>>()

    init {
        fetchChemicals()
    }

    private fun fetchChemicals() {
        viewModelScope.launch {
            _chemicals.value = repository.getChemicals()
        }
    }

    fun guessChemical(guess: String) {
        if (guess.isEmpty()) {
            _message.value = "Please input chemical to guess."
            return
        }
        val randomChemical = _chemicals.value?.randomOrNull()?.name.orEmpty()
        val isCorrect = guess.equals(randomChemical, ignoreCase = true)
        _message.value = if (isCorrect) {
            "Congratulations! You guessed it right. It was $randomChemical."
        } else {
            "Sorry, wrong guess. The correct answer was $randomChemical."
        }
    }

    fun addChemical(chemical: String) {
        if (chemical.isEmpty()) {
            _message.value = "Please input chemical to add."
            return
        }
        if (_chemicals.value.orEmpty().any { it.name == chemical }) {
            _message.value = "Chemical '$chemical' is already available."
            return
        }
        viewModelScope.launch {
            repository.addChemical(chemical)
            fetchChemicals()
            _message.value = "Chemical '$chemical' added successfully."
        }
    }
}