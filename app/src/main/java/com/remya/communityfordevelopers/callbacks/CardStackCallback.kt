package com.remya.communityfordevelopers.callbacks

import androidx.recyclerview.widget.DiffUtil
import com.remya.communityfordevelopers.ItemModel


class CardStackCallback(private val old: List<ItemModel>, private val baru: List<ItemModel>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return baru.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].image == baru[newItemPosition].image
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == baru[newItemPosition]
    }
}