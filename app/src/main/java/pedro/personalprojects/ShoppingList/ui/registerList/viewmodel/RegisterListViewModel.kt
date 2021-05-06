package pedro.personalprojects.ShoppingList.ui.registerList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pedro.personalprojects.ShoppingList.dto.list.RegisterListDto
import pedro.personalprojects.ShoppingList.repository.ListRepository

class RegisterListViewModel : ViewModel() {
    private val repository = ListRepository()

    val onSaveComplete = MutableLiveData<Unit>()

    fun save(list: RegisterListDto){
        viewModelScope.launch {
            repository.save(list)
            onSaveComplete.postValue(Unit)
        }
    }
}