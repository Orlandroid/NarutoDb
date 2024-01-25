package com.example.presentation.features.characters

import androidx.navigation.fragment.navArgs
import com.example.domain.common.Character
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentCharacterDetailBinding
import com.example.presentation.extensions.fromJson
import com.example.presentation.extensions.loadImageCircularProgress
import com.example.presentation.extensions.setTextFromHtml
import com.example.presentation.extensions.visible
import com.example.presentation.features.MainActivity


class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding>(R.layout.fragment_character_detail) {

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true,
        toolbarTitle = args.character.fromJson<Character>().name
    )

    private val args: CharacterDetailFragmentArgs by navArgs()
    override fun setUpUi() {
        bind(args.character.fromJson())
    }

    private fun bind(character: Character) = with(binding) {
        if (character.images.isNotEmpty()) {
            binding.imageCharacter.loadImageCircularProgress(
                url = character.images[0],
                imageOnError = R.drawable.characters
            )
        }
        tvName.setTextFromHtml(templateHTML(label = "Name", value = character.name))
        character.debut?.let {
            tvDebut.visible()
            tvDebut.setTextFromHtml(templateHTML(label = "Debut", value = it.getDebut() ?: ""))
        }
        character.personal?.age?.let {
            tvAge.visible()
            tvDebut.setTextFromHtml(templateHTML(label = "Age", value = it.getAge() ?: ""))
        }
        character.personal?.status?.let {
            tvStatus.visible()
            tvStatus.setTextFromHtml(templateHTML(label = "Status", value = it))
        }
        character.personal?.sex?.let {
            tvSex.visible()
            tvSex.setTextFromHtml(templateHTML(label = "Sex", value = it))
        }
        character.personal?.clan?.let {
            tvCla.visible()
            tvCla.setTextFromHtml(templateHTML(label = "Clan", value = it[0]))
        }
        character.jutsu?.let {
            tvJutsu.visible()
            tvJutsu.setTextFromHtml(templateHTML(label = "Jutsu", value = it[0]))
        }
    }

    private fun templateHTML(label: String, value: String) = """
        <b>$label</b>: $value
    """.trimIndent()


}