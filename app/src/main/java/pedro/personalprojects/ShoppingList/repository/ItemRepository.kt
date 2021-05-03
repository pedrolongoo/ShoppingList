package pedro.personalprojects.ShoppingList.repository

import pedro.personalprojects.ShoppingList.data.db.ShoppingListDB
import pedro.personalprojects.ShoppingList.data.entity.Item
import pedro.personalprojects.ShoppingList.dto.item.ItemDto
import pedro.personalprojects.ShoppingList.dto.item.RegisterItemDto

class ItemRepository {

    private val dao = ShoppingListDB.instance.itemDao()

    suspend fun  findByList(listId: Int): List<ItemDto>{
        val items = dao.findByList(listId)

        return items.map { item ->
            ItemDto(item.itemName, item.quantity)
        }
    }

    suspend fun save(registerItem: RegisterItemDto) {
        val item = Item(registerItem.listId, registerItem.itemName, registerItem.quantity)
        dao.save(item)
    }

}
