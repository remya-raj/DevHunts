package com.remya.communityfordevelopers

import com.squareup.picasso.Picasso

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import com.remya.communityfordevelopers.databinding.ItemCardBinding
import com.remya.communityfordevelopers.models.ItemModel


class CardStackAdapter(items: List<ItemModel>) :
    RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {
    private var items: List<ItemModel>
    private lateinit var binding: ItemCardBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
//        val view: View = inflater.inflate(R.layout.item_card, parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var nama: TextView
        var usia: TextView
        var kota: TextView
        fun setData(data: ItemModel) {
            Picasso.get()
                .load(data.image)
                .fit()
                .centerCrop()
                .into(image)
            nama.setText(data.nama)
            usia.setText(data.usia)
            kota.setText(data.kota)
        }

        init {
            image = binding.itemImage
            nama = binding.itemName
            usia = binding.itemAge
            kota = binding.itemCity
        }
    }

    fun getItems(): List<ItemModel> {
        return items
    }

    fun setItems(items: List<ItemModel>) {
        this.items = items
    }

    init {
        this.items = items
    }
}