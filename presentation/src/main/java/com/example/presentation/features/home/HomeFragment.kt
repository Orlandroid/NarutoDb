package com.example.presentation.features.home

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
            when (menu.menu) {
                HomeAdapter.MyMenusName.CHARACTERS -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                HomeAdapter.MyMenusName.CLANS -> {
                    HomeFragmentDirections.actionHomeFragmentToClansFragment()
                }

                HomeAdapter.MyMenusName.VILLAGES -> {
                    HomeFragmentDirections.actionHomeFragmentToVillagesFragment()
                }

                HomeAdapter.MyMenusName.KEKKEIGENNKAY -> {
                    HomeFragmentDirections.actionHomeFragmentToKekkeigenkaiFragment()
                }

                HomeAdapter.MyMenusName.TAILED_BEASTS -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                HomeAdapter.MyMenusName.TEAMS -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                HomeAdapter.MyMenusName.AKATSUKI -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }

                HomeAdapter.MyMenusName.KARA -> {
                    HomeFragmentDirections.actionHomeFragmentToCharactersFragment()
                }
            }
        )
    }

    private fun setMenus(): List<HomeAdapter.MyMenu> {
        return listOf(
            HomeAdapter.MyMenu(
                R.drawable.characters, "Characters", 1, HomeAdapter.MyMenusName.CHARACTERS
            ),
            HomeAdapter.MyMenu(R.drawable.clans, "Clans", 2, HomeAdapter.MyMenusName.CLANS),
            HomeAdapter.MyMenu(
                R.drawable.villages, "Villages", 3, HomeAdapter.MyMenusName.VILLAGES
            ),
            HomeAdapter.MyMenu(
                R.drawable.kekkeigenkai, "Kekkeigenkai", 4, HomeAdapter.MyMenusName.KEKKEIGENNKAY,

                ),
            HomeAdapter.MyMenu(
                R.drawable.tailedbeasts, "Tailed Beasts", 5, HomeAdapter.MyMenusName.TAILED_BEASTS
            ),
            HomeAdapter.MyMenu(R.drawable.teams, "Teams", 6, HomeAdapter.MyMenusName.TEAMS),
            HomeAdapter.MyMenu(
                R.drawable.akatsuki, "Akatsuki", 7, HomeAdapter.MyMenusName.AKATSUKI
            ),
            HomeAdapter.MyMenu(R.drawable.kara, "Kara", 8, HomeAdapter.MyMenusName.KARA)
        )
    }

}