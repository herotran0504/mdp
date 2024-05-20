package miu.mdp.extra.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import miu.mdp.extra.data.MessageRepository
import miu.mdp.extra.model.Program
import javax.inject.Inject

@HiltViewModel
class ProgramViewModel @Inject constructor(
    private val repository: MessageRepository
) : ViewModel() {

    private val _programs = MutableLiveData<List<Program>>()
    val programs: LiveData<List<Program>> = _programs

    init {
        viewModelScope.launch {
            _programs.value = repository.getMessages()
        }
    }

}
