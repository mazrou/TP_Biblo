package com.khaldi.biblo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khaldi.biblo.ui.model.Seance
import com.khaldi.biblo.ui.model.getListSeance

object ViewModel {
    val bookList : List<Seance> = getListSeance()
    val selectedBook : LiveData<Seance>
        get() =_selectedBook
    private val _selectedBook = MutableLiveData<Seance>()

    fun updateSelectedSeance(seance: Seance){
        _selectedBook.value = seance
    }
}