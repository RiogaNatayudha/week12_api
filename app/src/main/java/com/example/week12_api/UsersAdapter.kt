package com.example.week12_api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week12_api.model.Hero
import com.example.week12_api.databinding.ItemUsersBinding
import com.squareup.picasso.Picasso

class UsersAdapter (var heros:List<Hero>): RecyclerView.Adapter<UsersAdapter.HeroViewHolder>()
{
    inner class HeroViewHolder(val binding: ItemUsersBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context))
        return HeroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return heros.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.itemView.apply {
            with(holder.binding){
                hero.text=heros[position].title
                Picasso.get().load(heros[position].image).into(gambar)
            }
        }
    }


}