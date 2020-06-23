package android.upstarts.util.adapter

import android.upstarts.databinding.CatalogItemBinding
import android.upstarts.domain.model.JeansModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CatalogAdapter(
    private val onProductClick: (productId: Long) -> Unit
) : ListAdapter<JeansModel, CatalogAdapter.ViewHolder>(CatalogDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CatalogItemBinding.inflate(layoutInflater)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item, onProductClick)
    }

    class ViewHolder(private val binding: CatalogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: JeansModel, clickListener: (productId: Long) -> Unit) {
            binding.model = model
            binding.productImage.setOnClickListener {
                clickListener(model.id)
            }
        }
    }

    class CatalogDiffCallback : DiffUtil.ItemCallback<JeansModel>() {
        override fun areItemsTheSame(oldItem: JeansModel, newItem: JeansModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JeansModel, newItem: JeansModel): Boolean {
            return oldItem == newItem
        }
    }

}