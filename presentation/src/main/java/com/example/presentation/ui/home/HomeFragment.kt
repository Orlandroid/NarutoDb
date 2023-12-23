package com.example.presentation.ui.home

import androidx.navigation.fragment.findNavController
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
        findNavController().navigate(
            when (menu.position) {
                1 -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                2 -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                3 -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                4 -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                5 -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                6 -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                7 -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                8 -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                else -> {
                    throw IllegalArgumentException("The section to navigate was not found")
                }
            }
        )
    }

    private fun setMenus(): List<HomeAdapter.MyMenu> {
        return listOf(
            HomeAdapter.MyMenu(R.drawable.characters, "Characters", 1),
            HomeAdapter.MyMenu(R.drawable.clans, "Clans", 2),
            HomeAdapter.MyMenu(R.drawable.villages, "Villages", 3),
            HomeAdapter.MyMenu(R.drawable.kekkeigenkai, "Kekkeigenkai", 4),
            HomeAdapter.MyMenu(R.drawable.tailedbeasts, "Tailed Beasts", 5),
            HomeAdapter.MyMenu(R.drawable.teams, "Teams", 6),
            HomeAdapter.MyMenu(R.drawable.akatsuki, "Akatsuki", 7),
            HomeAdapter.MyMenu(R.drawable.kara, "Kara", 8)
        )
    }

}