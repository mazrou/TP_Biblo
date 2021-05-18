package com.khaldi.biblo.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.khaldi.biblo.R
import kotlinx.android.synthetic.main.book_list_item.view.*


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class BookRecyclerViewAdapter(
    private val values: List<Book> ,
    val interaction: Interaction? = null
) : RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_list_item, parent, false)
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

        fun bind(item : Book) = with(view){
            title_text_view.text = item.title
            author_text_view.text = item.author
            this.setOnClickListener {
                interaction?.onItemClicked(item , adapterPosition)
            }
            Glide.with(this).load(item.image).into(image_view)
        }
    }
    interface Interaction {
        fun onItemClicked(item : Book , position :Int)
    }
}