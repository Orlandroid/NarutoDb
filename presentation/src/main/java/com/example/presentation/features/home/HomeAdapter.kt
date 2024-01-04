package com.example.presentation.features.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.ItemMenuBinding
import com.example.presentation.extensions.click


class HomeAdapter(private val clickOnMenu: (MyMenu) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var listOfMenus: List<MyMenu> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listMenu: List<MyMenu>) {
        listOfMenus = listMenu
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(menu: MyMenu, clickOnMenu: (MyMenu) -> Unit) = with(binding) {
            root.click {
                clickOnMenu(menu)
            }
            textView2.text = menu.title
            image.setImageResource(menu.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfMenus[position], clickOnMenu)
    }

    override fun getItemCount() = listOfMenus.size

    data class MyMenu(
        val image: Int, val title: String, val position: Int
    )


}
