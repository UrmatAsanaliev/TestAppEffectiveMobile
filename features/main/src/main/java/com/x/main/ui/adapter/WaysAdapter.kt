package com.x.main.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.x.main.R
import com.x.main.databinding.ItemTicketsBinding
import com.x.main.model.TicketsOffersUI

class WaysAdapter: ListAdapter<TicketsOffersUI, WaysAdapter.WaysViewHolder>(WaysDiffUtil()) {


    override fun submitList(list: List<TicketsOffersUI>?) {
        val filteredList = list?.take(3)
        super.submitList(filteredList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WaysViewHolder(
            ItemTicketsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: WaysViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model, position)
    }


    class WaysViewHolder(private val binding: ItemTicketsBinding):
        ViewHolder(binding.root) {
            @SuppressLint("SetTextI18n")
            fun bind(model: TicketsOffersUI, position: Int) {
                binding.rvName.text = model.title
                binding.rvTime.text = model.timeRange.joinToString(separator = ", ")
                binding.rvPrice.text = model.price.value.toString() + " ₽"

                val backgroundRes = when (position) {
                    0 -> R.drawable.bg_circle_red
                    1 -> R.drawable.bg_circle_blue
                    2 -> R.drawable.bg_cirlce_white
                    else -> R.drawable.bg_circle_red
                }

                binding.rvColor.setBackgroundResource(backgroundRes)
            }
        }


    class WaysDiffUtil: DiffUtil.ItemCallback<TicketsOffersUI>() {
        override fun areItemsTheSame(
            oldItem: TicketsOffersUI,
            newItem: TicketsOffersUI) = oldItem == newItem


        override fun areContentsTheSame(
            oldItem: TicketsOffersUI,
            newItem: TicketsOffersUI) = oldItem == newItem


    }

}