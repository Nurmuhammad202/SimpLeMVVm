package uz.vita.simplemvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.vita.simplemvvm.data.Repository
import uz.vita.simplemvvm.data.local.room.model.User
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private var repository: Repository) : ViewModel() {

    fun getUserLocal() = repository.getUserLocal()

    fun saveUserLocal(user: User) = viewModelScope.launch {
        repository.saveUser(user)
    }

    private var _userCard = MutableLiveData<Boolean>()
    val userCard: LiveData<Boolean> = _userCard
    fun getUserCard() = viewModelScope.launch {
        repository.getUserCard()
    }
}