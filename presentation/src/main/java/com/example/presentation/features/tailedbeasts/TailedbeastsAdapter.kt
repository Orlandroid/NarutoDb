package com.example.presentation.features.tailedbeasts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.tailedbeasts.TailedBeast
import com.example.domain.villages.VillagesWithImages
import com.example.presentation.R
import com.example.presentation.databinding.ItemClanBinding
import com.example.presentation.extensions.readRawJson


class TailedbeastsAdapter(private val clickOnTailedBeast: (TailedBeast) -> Unit) :
    PagingDataAdapter<TailedBeast, TailedbeastsAdapter.CharacterViewHolder>(VillageComparator) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CharacterViewHolder {
        return CharacterViewHolder(
            ItemClanBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    inner class CharacterViewHolder(private val binding: ItemClanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tailedBeast: TailedBeast) = with(binding) {
            tvClan.text = tailedBeast.name
        }
    }

    fun getImageVillage(villageName: String, context: Context): String {
        context.readRawJson<List<VillagesWithImages>>(R.raw.villages).forEach {
            if (it.name == villageName) {
                return it.image
            }
        }
        return ""
    }

    object VillageComparator : DiffUtil.ItemCallback<TailedBeast>() {
        override fun areItemsTheSame(oldItem: TailedBeast, newItem: TailedBeast): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TailedBeast, newItem: TailedBeast): Boolean {
            return oldItem == newItem
        }

    }


}
