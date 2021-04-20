package pedro.personalprojects.ShoppingList.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pedro.personalprojects.ShoppingList.data.dao.ItemDAO
import pedro.personalprojects.ShoppingList.data.dao.ShoppingListDAO
import pedro.personalprojects.ShoppingList.data.entity.Item
import pedro.personalprojects.ShoppingList.data.entity.ShoppingList

@Database(
    entities = [Item::class, ShoppingList::class],
    version = 1)

abstract class ShoppingListDB : RoomDatabase() {

    abstract fun itemDao(): ItemDAO

    abstract fun ShoppingListDAO(): ShoppingListDAO

    companion object {
        private const val DATABASE_NAME = "db_shoppinglist"
        private lateinit var mInstance: ShoppingListDB

        val instance
            get() = mInstance

        fun initialize(context: Context){
            mInstance = Room.databaseBuilder(context, ShoppingListDB::class.java, DATABASE_NAME).build()
        }
    }
}