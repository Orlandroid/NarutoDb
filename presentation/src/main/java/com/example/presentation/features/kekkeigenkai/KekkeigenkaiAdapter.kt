package com.example.presentation.features.kekkeigenkai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.kekkeigenkai.Kekkeigenkai
import com.example.presentation.databinding.ItemClanBinding


class KekkeigenkaiAdapter(private val clickOnKekkeigenkai: (Kekkeigenkai) -> Unit) :
    PagingDataAdapter<Kekkeigenkai, KekkeigenkaiAdapter.CharacterViewHolder>(KekkeigenkaiComparator) {

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
        fun bind(kekkeigenkai: Kekkeigenkai) = with(binding) {
            tvClan.text = kekkeigenkai.name
        }
    }


    object KekkeigenkaiComparator : DiffUtil.ItemCallback<Kekkeigenkai>() {
        override fun areItemsTheSame(oldItem: Kekkeigenkai, newItem: Kekkeigenkai): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Kekkeigenkai, newItem: Kekkeigenkai): Boolean {
            return oldItem == newItem
        }

    }


}
