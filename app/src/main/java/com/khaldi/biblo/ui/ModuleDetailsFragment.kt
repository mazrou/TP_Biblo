package com.khaldi.biblo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View
import androidx.navigation.fragment.findNavController

import com.khaldi.biblo.R

import kotlinx.android.synthetic.main.fragment_module_details.*

class ModuleDetailsFragment : Fragment(R.layout.fragment_module_details,) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModel.selectedBook.observe(viewLifecycleOwner , {
            teacher_button.text = it.module?.teacher?.firstName
            utility_txt_view.text = it.module?.utility
            name_txt_view.text = it.module?.name
            volume_txt_view.append(" ${it.module?.dureTotal} H")

            teacher_button.setOnClickListener {
                findNavController().navigate(R.id.to_teacher)
            }
        })
    }
}