package pedro.personalprojects.ShoppingList.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShoppingList")
data class ShoppingList(
    val date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
