package com.x.main.ui.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.x.core.ext.calculateFlightTimeLegacy
import com.x.core.ext.formatToTimeOnly
import com.x.core.ext.gone
import com.x.core.ext.visible
import com.x.main.databinding.ItemTicketsPriceBinding
import com.x.main.model.TicketsUI

@RequiresApi(Build.VERSION_CODES.O)
class TicketAdapter: ListAdapter<TicketsUI, TicketAdapter.TicketViewHolder>(TicketDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TicketViewHolder(
        ItemTicketsPriceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }


    class TicketViewHolder(private val binding: ItemTicketsPriceBinding):
            ViewHolder(binding.root) {
                @SuppressLint("SetTextI18n")
                fun bind(model: TicketsUI) {
                    binding.txtPrice.text = model.price.value.toString() + " ₽"
                    binding.txtFirstDate.text = formatToTimeOnly(model.departure.date)
                    binding.txtSecondDate.text = formatToTimeOnly(model.arrival.date)
                    binding.txtVko.text = model.departure.airport
                    binding.txtAer.text = model.arrival.airport

                    val time = calculateFlightTimeLegacy(
                        departure = model.departure.date,
                        arrival = model.arrival.date
                    )

                    if (model.hasTransfer) {
                        binding.txtTime.text = "$time в пути / Без пересадок"
                    } else {
                        binding.txtTime.text = "$time в пути"
                    }

                    if (model.badge.isNullOrEmpty()) {
                        binding.blueCard.gone()
                    } else {
                        binding.blueCard.visible()
                    }

                }
            }

    class TicketDiffUtil: DiffUtil.ItemCallback<TicketsUI>() {
        override fun areItemsTheSame(oldItem: TicketsUI, newItem: TicketsUI) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: TicketsUI, newItem: TicketsUI) =
            oldItem == newItem
    }

}