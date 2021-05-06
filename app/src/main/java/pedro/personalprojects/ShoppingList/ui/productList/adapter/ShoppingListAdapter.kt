package pedro.personalprojects.ShoppingList.ui.productList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pedro.personalprojects.ShoppingList.R
import pedro.personalprojects.ShoppingList.databinding.ItemListBinding
import pedro.personalprojects.ShoppingList.databinding.ItemProductBinding
import pedro.personalprojects.ShoppingList.dto.list.ListDto

class ShoppingListAdapter : RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {

    lateinit var onItemSelected: (ListDto) -> Unit

    var items = listOf<ListDto>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ShoppingListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        holder.bindItem(items[position], onItemSelected)
    }

    override fun getItemCount() = items.size

    inner class ShoppingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemListBinding.bind(itemView)

        fun bindItem(list: ListDto, onItemSelected: (ListDto) -> Unit) {
            binding.tvName.text = list.name
            binding.tvDate.text = list.date
            binding.root.setOnClickListener { onItemSelected(list) }
        }

    }

}