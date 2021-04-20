package pedro.personalprojects.ShoppingList.app

import android.app.Application
import pedro.personalprojects.ShoppingList.data.db.ShoppingListDB

class ShoppingListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ShoppingListDB.initialize(applicationContext)
    }
}