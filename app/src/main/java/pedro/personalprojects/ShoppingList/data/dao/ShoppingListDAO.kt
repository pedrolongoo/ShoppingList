package pedro.personalprojects.ShoppingList.data.dao


import androidx.room.*
import pedro.personalprojects.ShoppingList.data.entity.ShoppingList

@Dao
interface ShoppingListDAO {

    @Insert
    suspend fun save(shoppingList: ShoppingList)

    @Delete
    suspend fun delete(shoppingList: ShoppingList)

    @Query("select * from shoppingList")
    suspend fun findAll(): List<ShoppingList>
}