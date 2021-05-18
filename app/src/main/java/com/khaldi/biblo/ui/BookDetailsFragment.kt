package com.khaldi.biblo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import com.bumptech.glide.Glide
import com.khaldi.biblo.R

import kotlinx.android.synthetic.main.fragment_book_details.*


class BookDetailsFragment : Fragment(R.layout.fragment_book_details,) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModel.selectedBook.observe(viewLifecycleOwner , {
            description_txt_view.text = it.description
            author_txt_view.text = it.author
            title_txt_view.text = it.title
            Glide.with(this@BookDetailsFragment).load(it.image).into(book_image);
        })
    }
}