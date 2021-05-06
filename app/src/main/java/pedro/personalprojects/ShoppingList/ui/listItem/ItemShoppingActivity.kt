package pedro.personalprojects.ShoppingList.ui.listItem

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import pedro.personalprojects.ShoppingList.R
import pedro.personalprojects.ShoppingList.databinding.ActivityProductListBinding
import pedro.personalprojects.ShoppingList.dto.list.ListDto
import pedro.personalprojects.ShoppingList.ui.listItem.adapter.ItemShoppingAdapter
import pedro.personalprojects.ShoppingList.ui.listItem.contract.ItemShoppingContract.Companion.EXTRA_SHOPPING_LIST
import pedro.personalprojects.ShoppingList.ui.listItem.viewmodel.ItemShoppingViewModel
import pedro.personalprojects.ShoppingList.ui.registerItemList.RegisterItemShoppingActivity
import pedro.personalprojects.ShoppingList.ui.registerList.RegisterListActivity

class ItemShoppingActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<ItemShoppingViewModel>()
    private lateinit var adapter: ItemShoppingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        val list = intent.getSerializableExtra(EXTRA_SHOPPING_LIST) as ListDto
        viewModel.list = list

        setupList()
        setupEvents()

        viewModel.findItems()
    }

    private fun setupEvents() {
        viewModel.productList.observe(this) { items ->
            this.adapter.items = items
        }

        viewModel.findItems()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_shopping_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnAdd) {
            registerResult.launch(RegisterItemShoppingActivity.newIntent(this).putExtra("id", viewModel.list.id))
            return true
        }

        return false
    }

    private val registerResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            viewModel.findItems()
        }
    }

    private fun setupList() {
        adapter = ItemShoppingAdapter()

        binding.rvItems.adapter = adapter
        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }

}