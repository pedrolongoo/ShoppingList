package pedro.personalprojects.ShoppingList.ui.registerItemList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pedro.personalprojects.ShoppingList.dto.item.RegisterItemDto
import pedro.personalprojects.ShoppingList.repository.ItemRepository

class RegisterItemShoppingViewModel: ViewModel() {

    private val repository = ItemRepository()

    val onSaveComplete = MutableLiveData<Unit>()

    fun save(item: RegisterItemDto){
        viewModelScope.launch {
            repository.save(item)
            onSaveComplete.postValue(Unit)
        }
    }
}