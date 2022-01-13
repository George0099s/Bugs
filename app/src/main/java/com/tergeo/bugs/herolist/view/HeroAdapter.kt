package com.tergeo.bugs.herolist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.tergeo.bugs.R
import com.tergeo.bugs.herolist.model.HeroModel


class HeroAdapter(
    private val glide: RequestManager,
    clickListener: OnHeroClickListener
)
    : RecyclerView.Adapter<HeroAdapter.HeroVH>() {

    private var items: List<HeroModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroVH =
        HeroVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        )

    override fun onBindViewHolder(holder: HeroVH, position: Int) {
        holder.bind(items[position+1])
    }

    override fun getItemCount(): Int = 0

    fun setItems(newList: List<HeroModel>) {
        items = newList
    }

    inner class HeroVH(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.nameText)
        private val team = view.findViewById<TextView>(R.id.teamText)
        private val image = view.findViewById<ImageView>(R.id.heroImage)

        fun bind(model: HeroModel) {
            view.setOnClickListener {

            }

            name.text = model.name
            team.text = model.team

            glide
                .load(model.imageUrl)
                .into(image)

        }
    }

    interface OnHeroClickListener {

        fun onHeroClick(hero: HeroModel)
    }
}