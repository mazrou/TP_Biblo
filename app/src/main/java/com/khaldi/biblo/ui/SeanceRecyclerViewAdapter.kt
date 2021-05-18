package com.khaldi.biblo.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.khaldi.biblo.R
import com.khaldi.biblo.ui.model.Seance
import kotlinx.android.synthetic.main.seance_list_item.view.*

class SeanceRecyclerViewAdapter(
    private val values: List<Seance> ,
    val interaction: Interaction? = null
) : RecyclerView.Adapter<SeanceRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.seance_list_item, parent, false)
        return ViewHolder(view , interaction)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(values[position])

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(
        private val view: View ,
        val interaction: Interaction?
        ) : RecyclerView.ViewHolder(view) {

        fun bind(item : Seance) = with(view){
            seance_name_text_view.text = item.module?.name ?: ""
            time_text_view.text = item.time
            this.setOnClickListener {
                interaction?.onItemClicked(item , adapterPosition)
            }
        }
    }
    interface Interaction {
        fun onItemClicked(item : Seance , position :Int)
    }
}