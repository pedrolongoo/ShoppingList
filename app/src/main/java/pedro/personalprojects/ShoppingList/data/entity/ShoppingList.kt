package pedro.personalprojects.ShoppingList.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoppingList")
data class ShoppingList(
    val name: String,
    val date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
