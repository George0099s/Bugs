package com.tergeo.bugs.herolist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tergeo.bugs.R
import com.tergeo.bugs.heroinfo.HeroInfoFragment
import com.tergeo.bugs.herolist.model.HeroModel
import com.tergeo.bugs.herolist.viewmodel.HeroViewModel

class MarvelHeroList : Fragment(
    R.layout.fragment_marvel_hero_list
), HeroAdapter.OnHeroClickListener {

    private lateinit var viewModel: HeroViewModel
    private var adapter: HeroAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.hero_recycler)
        recycler.adapter = adapter

        viewModel.heroListLiveData.observe(viewLifecycleOwner, { list ->
            adapter?.setItems(list)
        })
    }

    override fun onHeroClick(hero: HeroModel) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, HeroInfoFragment.newInstance(hero))
            .addToBackStack(null)
            .commit()
    }
}