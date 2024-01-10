package com.example.presentation.features.kara

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.kara.Kara
import com.example.presentation.databinding.ItemClanBinding


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
