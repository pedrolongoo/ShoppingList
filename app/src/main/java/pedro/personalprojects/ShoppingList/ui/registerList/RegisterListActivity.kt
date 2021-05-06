package pedro.personalprojects.ShoppingList.ui.registerList

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import pedro.personalprojects.ShoppingList.R
import pedro.personalprojects.ShoppingList.databinding.ActivityRegisterListBinding
import pedro.personalprojects.ShoppingList.dto.list.RegisterListDto
import pedro.personalprojects.ShoppingList.ui.registerList.viewmodel.RegisterListViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegisterListActivity: AppCompatActivity() {

    private val viewModel by viewModels<RegisterListViewModel>()

    private val binding by lazy {
        ActivityRegisterListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.onSaveComplete.observe(this, { onSaveComplete() })
    }

    private fun onSaveComplete() {
        setResult(RESULT_OK)
        finish()
    }

    private fun save() {
        if (validateInput()) {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            viewModel.save(
                RegisterListDto(
                    binding.etListName.text.toString(),
                    LocalDateTime.now().format(formatter).toString()
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
        fun newIntent(context: Context) = Intent(context, RegisterListActivity::class.java)
    }
}