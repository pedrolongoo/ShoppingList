package pedro.personalprojects.ShoppingList.ui.registerItemList

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import pedro.personalprojects.ShoppingList.R
import pedro.personalprojects.ShoppingList.databinding.ActivityRegisterItemBinding
import pedro.personalprojects.ShoppingList.dto.item.RegisterItemDto
import pedro.personalprojects.ShoppingList.ui.registerItemList.viewmodel.RegisterItemShoppingViewModel
import pedro.personalprojects.ShoppingList.ui.registerList.RegisterListActivity
import java.time.format.DateTimeFormatter

class RegisterItemShoppingActivity: AppCompatActivity() {

    private val viewModel by viewModels<RegisterItemShoppingViewModel>()

    private val binding by lazy {
        ActivityRegisterItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.onSaveComplete.observe(this, { onSaveComplete() })
    }

    private fun onSaveComplete() {
        setResult(AppCompatActivity.RESULT_OK)
        finish()
    }

    private fun save() {
        if (validateInput()) {
            val extras = intent.extras
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            viewModel.save(
                RegisterItemDto(
                    extras!!.getInt("id"),
                    binding.etListName.text.toString(),
                    binding.etquantity.text.toString().toDouble()
                )
            )
        }
    }

    private fun validateInput(): Boolean {
        var isValid = true

        binding.tilName.error = if (binding.etListName.text.toString().trim().isEmpty()) {
            isValid = false
            "Nome da lista de compras obrigatório."
        } else {
            null
        }

        return isValid
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_register, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mnSave) {
            save()
            return true
        }

        return false
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, RegisterItemShoppingActivity::class.java)
    }
}