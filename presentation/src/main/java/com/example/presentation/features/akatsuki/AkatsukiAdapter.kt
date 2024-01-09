package com.example.presentation.features.akatsuki

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.akatsuki.Akatsuki
import com.example.presentation.databinding.ItemClanBinding


class AkatsukiAdapter(private val clickOnAkatsuki: (Akatsuki) -> Unit) :
    PagingDataAdapter<Akatsuki, AkatsukiAdapter.CharacterViewHolder>(AkatsukiComparator) {

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
        fun bind(akatsuki: Akatsuki) = with(binding) {
            tvClan.text = akatsuki.name
        }
    }


    object AkatsukiComparator : DiffUtil.ItemCallback<Akatsuki>() {
        override fun areItemsTheSame(oldItem: Akatsuki, newItem: Akatsuki): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Akatsuki, newItem: Akatsuki): Boolean {
            return oldItem == newItem
        }

    }


}
