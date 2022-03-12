package com.example.rasmlar.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rasmlar.R
import com.example.rasmlar.databinding.DarsListBinding
import com.example.rasmlar.modules.WallpaperResult
import com.squareup.picasso.Picasso

class WallpAdapter (var list: List<WallpaperResult>,var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<WallpAdapter.Vh>() {

    inner class Vh(var darsListBinding: DarsListBinding) :
        RecyclerView.ViewHolder(darsListBinding.root){

        fun onBind(wallpaperResult: WallpaperResult) {

            Picasso.get().load(wallpaperResult.urls.small)
                .into(darsListBinding.rasm)
            darsListBinding.root.setOnClickListener {
                onItemClickListener.onItemClick(wallpaperResult)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(DarsListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener{
        fun onItemClick(wallpaperResult: WallpaperResult)
    }
}