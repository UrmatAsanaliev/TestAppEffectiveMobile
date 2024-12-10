package com.x.main.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.x.main.R
import com.x.main.databinding.ItemMusicBinding
import com.x.main.model.OffersUI

class MusicAdapter:
    ListAdapter<OffersUI, MusicAdapter.MusicViewHolder>(MusicDiffUtil()) {

    private val images = listOf(
        R.drawable.music_img_1,
        R.drawable.music_img_2,
        R.drawable.music_img_3
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MusicViewHolder(
        ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model, images, position)
    }

    class MusicViewHolder(private val binding: ItemMusicBinding):
        ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: OffersUI, images: List<Int>, pos: Int) {
            binding.rvIcon.setImageResource(images[pos])
            binding.rvTitle.text = item.title
            binding.rvCity.text = item.town
            binding.rvPrice.text = "от ${item.price.value} ₽"
        }
    }

    class MusicDiffUtil: DiffUtil.ItemCallback<OffersUI>() {
        override fun areItemsTheSame(oldItem: OffersUI, newItem: OffersUI): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: OffersUI, newItem: OffersUI): Boolean =
            oldItem == newItem
    }


}