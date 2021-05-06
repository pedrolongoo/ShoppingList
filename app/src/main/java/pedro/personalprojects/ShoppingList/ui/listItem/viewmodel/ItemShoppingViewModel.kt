package pedro.personalprojects.ShoppingList.ui.listItem.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pedro.personalprojects.ShoppingList.dto.item.ItemDto
import pedro.personalprojects.ShoppingList.dto.list.ListDto
import pedro.personalprojects.ShoppingList.repository.ItemRepository

class ItemShoppingViewModel: ViewModel() {

    lateinit var list: ListDto

    var productList = MutableLiveData<List<ItemDto>>()

    private val repository = ItemRepository()

    fun findItems(){
        viewModelScope.launch {
            val items = repository.findByList(list.id)
            productList.postValue(items)
        }
    }
}