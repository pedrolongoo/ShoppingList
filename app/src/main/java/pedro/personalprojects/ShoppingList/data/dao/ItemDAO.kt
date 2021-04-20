package pedro.personalprojects.ShoppingList.data.dao

import androidx.room.*
import pedro.personalprojects.ShoppingList.data.entity.Item

@Dao
interface ItemDAO {

    @Insert
    suspend fun save(item : Item)

    @Delete
    suspend fun delete(item: Item)

    @Update
    suspend fun update(item: Item)

    @Query("select * from items where listId = :listId order by id desc")
    suspend fun findByList(listId: Int): List<Item>
}