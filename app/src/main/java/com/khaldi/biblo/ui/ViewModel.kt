package com.khaldi.biblo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object ViewModel {
    val bookList : List<Book> = getLisBook()
    val selectedBook : LiveData<Book>
        get() =_selectedBook
    private val _selectedBook = MutableLiveData<Book>()

    fun updateSelectedBook(book: Book){
        _selectedBook.value = book
    }
}