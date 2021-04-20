package pedro.personalprojects.ShoppingList.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    val listId: Int,
    val itemName: String,
    val quantity: Double,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
