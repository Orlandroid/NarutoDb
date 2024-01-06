package com.example.presentation.features.villages

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.villages.Village
import com.example.domain.villages.VillagesWithImages
import com.example.presentation.R
import com.example.presentation.databinding.ItemClanBinding
import com.example.presentation.extensions.click
import com.example.presentation.extensions.loadImage
import com.example.presentation.extensions.readRawJson


class VillagesAdapter(private val clickOnVillage: (Village) -> Unit) :
    PagingDataAdapter<Village, VillagesAdapter.CharacterViewHolder>(VillageComparator) {

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
        fun bind(village: Village) = with(binding) {
            tvClan.text = village.name
            val villageImage = getImageVillage(village.name, itemView.context)
            imageCharacter.loadImage(urlImage = villageImage, imageOnError = R.drawable.villages)
            root.click { clickOnVillage(village) }
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

    object VillageComparator : DiffUtil.ItemCallback<Village>() {
        override fun areItemsTheSame(oldItem: Village, newItem: Village): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Village, newItem: Village): Boolean {
            return oldItem == newItem
        }

    }


}
