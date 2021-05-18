package com.khaldi.biblo.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.khaldi.biblo.R
import com.khaldi.biblo.ui.model.Seance
import kotlinx.android.synthetic.main.fragment_seance_list.*

import kotlinx.android.synthetic.main.fragment_teacher.*
import kotlinx.android.synthetic.main.fragment_teacher.grade_txt_view
import kotlinx.android.synthetic.main.fragment_teacher.teacher_txt_view

class SeanceListFragment : Fragment( R.layout.fragment_seance_list,) , SeanceRecyclerViewAdapter.Interaction {

    private var columnCount = 1

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = SeanceRecyclerViewAdapter(ViewModel.bookList , this@SeanceListFragment)
        }
        if(resources.configuration.screenWidthDp > 600){
            ViewModel.selectedBook.observe(viewLifecycleOwner , {
                teacher_txt_view.text = "${it.module?.teacher?.firstName} ${it.module?.teacher?.lastName} "
                grade_txt_view.text = it.module?.teacher?.grade
                utility_txt_view.text = it.module?.utility
                name_txt_view.text = it.module?.name
                volume_txt_view.append(" ${it.module?.dureTotal} H")

            })
        }
    }

    override fun onItemClicked(item: Seance, position: Int) {
        ViewModel.updateSelectedSeance(item)
        if(resources.configuration.screenWidthDp <= 600){
            findNavController().navigate(R.id.to_module_detail)
        }

    }
}