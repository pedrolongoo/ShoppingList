package pedro.personalprojects.ShoppingList.repository

import pedro.personalprojects.ShoppingList.data.dao.ShoppingListDAO
import pedro.personalprojects.ShoppingList.data.db.ShoppingListDB
import pedro.personalprojects.ShoppingList.data.entity.ShoppingList
import pedro.personalprojects.ShoppingList.dto.list.ListDto
import pedro.personalprojects.ShoppingList.dto.list.RegisterListDto

class ListRepository {

    private val dao = ShoppingListDB.instance.ShoppingListDAO()

    suspend fun save(shoppingList: RegisterListDto){
        val entity = ShoppingList(shoppingList.date, shoppingList.name)
        dao.save(entity)
    }

    suspend fun findAll(): List<ListDto> {
        val lists = dao.findAll()

        return lists.map { item ->
            ListDto(
                item.id ?: 0,
                item.name,
                item.date
            )
        }
    }

}