package com.tergeo.bugs.heroinfo

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.tergeo.bugs.R
import com.tergeo.bugs.herolist.model.HeroModel


class HeroInfoFragment : Fragment(R.layout.fragment_hero_info) {

    companion object {

        private const val HERO_ARG = "hero"

        fun newInstance(heroModel: HeroModel) =
            HeroInfoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(HERO_ARG, heroModel)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = view.findViewById<TextView>(R.id.nameText)
        val realName = view.findViewById<TextView>(R.id.realNameText)
        val team = view.findViewById<TextView>(R.id.teamText)
        val bio = view.findViewById<TextView>(R.id.bioText)
        val image = view.findViewById<ImageView>(R.id.heroImage)

        val hero = requireArguments().getSerializable("Hero") as HeroModel

        name.text = hero.name
        realName.text = hero.realName
        team.text = hero.team
        bio.text = hero.bio
        Glide.with(requireContext())
            .load(hero.imageUrl)
            .into(image)
    }
}