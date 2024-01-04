package com.example.presentation.features.clans

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.data.clans.getImageFromClan
import com.example.domain.clans.Clan
import com.example.presentation.R
import com.example.presentation.databinding.ItemClanBinding
import com.example.presentation.extensions.click
import com.example.presentation.extensions.loadImage


class ClansAdapter(private val clickOnCharacter: (Clan) -> Unit) :
    PagingDataAdapter<Clan, ClansAdapter.CharacterViewHolder>(ClanComparator) {

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
        fun bind(clan: Clan) = with(binding) {
            root.click {
                clickOnCharacter(clan)
            }
            tvClan.text = clan.name
            val imageClan = getImageFromClan(clan.name)
            imageCharacter.loadImage(imageClan)
        }
    }

    object ClanComparator : DiffUtil.ItemCallback<Clan>() {
        override fun areItemsTheSame(oldItem: Clan, newItem: Clan): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Clan, newItem: Clan): Boolean {
            return oldItem == newItem
        }
    }


}
