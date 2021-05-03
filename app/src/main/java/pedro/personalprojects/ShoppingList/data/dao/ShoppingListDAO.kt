package pedro.personalprojects.ShoppingList.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pedro.personalprojects.ShoppingList.data.entity.ShoppingList

@Dao
interface ShoppingListDAO {

    @Insert
    suspend fun save(shoppingList: ShoppingList)

    @Delete
    suspend fun delete(shoppingList: ShoppingList)

    @Query("select * from ShoppingList")
    suspend fun findAll(): List<ShoppingList>
}