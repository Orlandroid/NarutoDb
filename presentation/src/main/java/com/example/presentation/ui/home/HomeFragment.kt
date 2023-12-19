package com.example.presentation.ui.home

import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val adapter = HomeAdapter { clickOnMenu(it) }
    override fun setUpUi() {
        binding.recycler.adapter = adapter
        adapter.setData(setMenus())
    }

    private fun clickOnMenu(menu: HomeAdapter.MyMenu) {

    }

    private fun setMenus(): List<HomeAdapter.MyMenu> {
        return listOf(
            HomeAdapter.MyMenu(R.drawable.characters, "Characters"),
            HomeAdapter.MyMenu(R.drawable.clans, "Clans"),
            HomeAdapter.MyMenu(R.drawable.villages, "Villages"),
            HomeAdapter.MyMenu(R.drawable.kekkeigenkai, "Kekkeigenkai"),
            HomeAdapter.MyMenu(R.drawable.tailedbeasts, "Tailed Beasts"),
            HomeAdapter.MyMenu(R.drawable.teams, "Teams"),
            HomeAdapter.MyMenu(R.drawable.akatsuki, "Akatsuki"),
            HomeAdapter.MyMenu(R.drawable.kara, "Kara")
        )
    }

}