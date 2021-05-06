package pedro.personalprojects.ShoppingList.ui.listItem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pedro.personalprojects.ShoppingList.R
import pedro.personalprojects.ShoppingList.databinding.ItemProductBinding
import pedro.personalprojects.ShoppingList.dto.item.ItemDto
import java.time.format.DateTimeFormatter

class ItemShoppingAdapter : RecyclerView.Adapter<ItemShoppingAdapter.ItemShoppingViewHolder>(){

    var items = listOf<ItemDto>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemShoppingViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ItemShoppingViewHolder(item)
    }

    override fun onBindViewHolder(holder: ItemShoppingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ItemShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemProductBinding.bind(itemView)

        fun bind(item: ItemDto) {
            binding.tvName.text = item.itemName
            binding.tvQuantity.text = item.quantity.toString()
        }
    }
}