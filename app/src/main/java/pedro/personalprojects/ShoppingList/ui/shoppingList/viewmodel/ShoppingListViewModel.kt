package pedro.personalprojects.ShoppingList.ui.shoppingList.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pedro.personalprojects.ShoppingList.dto.list.ListDto
import pedro.personalprojects.ShoppingList.repository.ListRepository

class ShoppingListViewModel : ViewModel() {
    private val repository = ListRepository()

    val shoppingList = MutableLiveData<List<ListDto>>()

    fun listAll() {
        viewModelScope.launch {
            val result = repository.findAll()
            shoppingList.postValue(result)
        }
    }

}