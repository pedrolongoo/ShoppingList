package pedro.personalprojects.ShoppingList.ui.listItem.contract

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import pedro.personalprojects.ShoppingList.dto.list.ListDto
import pedro.personalprojects.ShoppingList.ui.listItem.ItemShoppingActivity

class ItemShoppingContract : ActivityResultContract<ListDto, Unit>() {

    override fun createIntent(context: Context, input: ListDto?) : Intent {
        return Intent(context, ItemShoppingActivity::class.java)
            .putExtra(EXTRA_SHOPPING_LIST, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?) = Unit

    companion object {
        const val EXTRA_SHOPPING_LIST = "list"
    }
}