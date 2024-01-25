package com.example.presentation.features.kara

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.kara.Kara
import com.example.presentation.R
import com.example.presentation.databinding.ItemClanBinding
import com.example.presentation.extensions.click
import com.example.presentation.extensions.loadImage


class KaraAdapter(private val clickOnKara: (Kara) -> Unit) :
    PagingDataAdapter<Kara, KaraAdapter.CharacterViewHolder>(KaraComparator) {

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
        fun bind(kara: Kara) = with(binding) {
            tvClan.text = kara.name
            if (kara.images.isNotEmpty()) {
                imageCharacter.loadImage(kara.images[0], R.drawable.kara)
            } else {
                imageCharacter.loadImage(R.drawable.kara)
            }
            root.click {
                clickOnKara.invoke(kara)
            }
        }
    }


    object KaraComparator : DiffUtil.ItemCallback<Kara>() {
        override fun areItemsTheSame(oldItem: Kara, newItem: Kara): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Kara, newItem: Kara): Boolean {
            return oldItem == newItem
        }

    }


}
