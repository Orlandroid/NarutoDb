package com.example.presentation.features.imageViever

import androidx.navigation.fragment.navArgs
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentImageViewVerBinding
import com.example.presentation.extensions.loadImage
import com.example.presentation.features.MainActivity


class ImageViewVerFragment :
    BaseFragment<FragmentImageViewVerBinding>(R.layout.fragment_image_view_ver) {

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(showToolbar = true)

    private val args: ImageViewVerFragmentArgs by navArgs()

    override fun setUpUi() {
        binding.photoView.loadImage(args.imageUrl)
    }

}