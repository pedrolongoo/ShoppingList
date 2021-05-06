package pedro.personalprojects.ShoppingList.ui.shoppingList

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import pedro.personalprojects.ShoppingList.R
import pedro.personalprojects.ShoppingList.databinding.ActivityShoppingListBinding
import pedro.personalprojects.ShoppingList.dto.list.ListDto
import pedro.personalprojects.ShoppingList.ui.listItem.contract.ItemShoppingContract
import pedro.personalprojects.ShoppingList.ui.shoppingList.adapter.ShoppingListAdapter
import pedro.personalprojects.ShoppingList.ui.shoppingList.viewmodel.ShoppingListViewModel
import pedro.personalprojects.ShoppingList.ui.registerList.RegisterListActivity

class ShoppingListActivity: AppCompatActivity() {

    private val viewModel: ShoppingListViewModel by viewModels()

    private lateinit var adapter : ShoppingListAdapter

    private val binding: ActivityShoppingListBinding by lazy {
        ActivityShoppingListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupList()
        setupEvents()
    }

    private fun setupList() {
        adapter = ShoppingListAdapter()
        adapter.onItemSelected = ::onListSelected

        binding.rvShoppingList.adapter = adapter
        binding.rvShoppingList.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingList.addItemDecoration(
            DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun onListSelected(list: ListDto) {
        itemResult.launch(list)
    }

    private val itemResult = registerForActivityResult(ItemShoppingContract()) {
        viewModel.listAll()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_shopping_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnAdd) {
            registerResult.launch(RegisterListActivity.newIntent(this))
            return true
        }

        return false
    }

    private val registerResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            viewModel.listAll()
        }
    }

    private fun setupEvents() {
        viewModel.shoppingList.observe(this) { medicines ->
            this.adapter.items = medicines
        }

        viewModel.listAll()
    }

}