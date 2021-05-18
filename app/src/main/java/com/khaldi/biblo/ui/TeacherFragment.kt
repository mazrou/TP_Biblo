package com.khaldi.biblo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.khaldi.biblo.R
import kotlinx.android.synthetic.main.fragment_teacher.*


class TeacherFragment : Fragment(R.layout.fragment_teacher) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewModel.selectedBook.observe(viewLifecycleOwner , {
            teacher_txt_view.text = "${it.module?.teacher?.firstName} ${it.module?.teacher?.lastName} "
            grade_txt_view.text = it.module?.teacher?.grade
        })
    }
}