package com.example.presentation.features.villages

import android.content.Context
import androidx.navigation.fragment.navArgs
import com.example.domain.villages.Village
import com.example.domain.villages.VillagesWithImages
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentVillageDetailBinding
import com.example.presentation.extensions.changeToolbarTitle
import com.example.presentation.extensions.fromJson
import com.example.presentation.extensions.loadImage
import com.example.presentation.extensions.readRawJson
import com.example.presentation.features.MainActivity


class VillageDetailFragment :
    BaseFragment<FragmentVillageDetailBinding>(R.layout.fragment_village_detail) {

    private val args: VillageDetailFragmentArgs by navArgs()

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = args.village.fromJson<Village>().name
    )

    override fun setUpUi() {
        args.village.fromJson<Village>().let {
            val villageImage = getVillage(it.name, requireContext())
            villageImage?.let { village ->
                binding.imageVillage.loadImage(
                    urlImage = villageImage.image,
                    imageOnError = R.drawable.villages
                )
                binding.tvDescription.text = village.description
            }
            changeToolbarTitle(it.name)
        }

    }

    private fun getVillage(villageName: String, context: Context): VillagesWithImages? {
        context.readRawJson<List<VillagesWithImages>>(R.raw.villages).forEach {
            if (it.name == villageName) {
                return it
            }
        }
        return null
    }

}