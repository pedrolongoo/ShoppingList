package pedro.personalprojects.ShoppingList.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "items",
        foreignKeys = arrayOf(
            ForeignKey(entity = ShoppingList::class, parentColumns = arrayOf("id"), childColumns = arrayOf("listId"), onDelete = ForeignKey.CASCADE)))
data class Item(
    val listId: Int,
    val itemName: String,
    val quantity: Double,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
