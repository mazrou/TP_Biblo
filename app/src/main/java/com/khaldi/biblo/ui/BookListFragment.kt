package com.khaldi.biblo.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.khaldi.biblo.R
import kotlinx.android.synthetic.main.fragment_book_details.*
import kotlinx.android.synthetic.main.fragment_book_list.*
import kotlinx.android.synthetic.main.fragment_book_list.author_txt_view
import kotlinx.android.synthetic.main.fragment_book_list.book_image
import kotlinx.android.synthetic.main.fragment_book_list.description_txt_view
import kotlinx.android.synthetic.main.fragment_book_list.title_txt_view

class BookListFragment : Fragment( R.layout.fragment_book_list,) , BookRecyclerViewAdapter.Interaction {

    private var columnCount = 1

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = BookRecyclerViewAdapter(ViewModel.bookList , this@BookListFragment)
        }
        if(resources.configuration.screenWidthDp > 600){
            ViewModel.selectedBook.observe(viewLifecycleOwner , {
                description_txt_view.text = it.description
                author_txt_view.text = it.author
                title_txt_view.text = it.title
                Glide.with(this@BookListFragment).load(it.image).into(book_image);
            })
        }
    }

    override fun onItemClicked(item: Book, position: Int) {
        ViewModel.updateSelectedBook  (item)
        if(resources.configuration.screenWidthDp <= 600){
            findNavController().navigate(R.id.to_detail)
        }

    }
}