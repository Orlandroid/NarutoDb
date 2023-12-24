package com.example.presentation.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.remote.User
import com.example.presentation.databinding.ItemCharacterBinding
import com.example.presentation.extensions.click


class UserAdapter(private val clickOnUser: (User) -> Unit) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var listOfCategories: List<User> = arrayListOf()

    fun setData(lista: List<User>) {
        listOfCategories = lista
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, clickOnUser: (User) -> Unit) = with(binding) {
            root.click {
                clickOnUser(user)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfCategories[position], clickOnUser)
    }

    override fun getItemCount(): Int {
        return listOfCategories.size
    }


}
