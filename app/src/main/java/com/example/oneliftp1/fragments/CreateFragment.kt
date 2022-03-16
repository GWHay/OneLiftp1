package com.example.oneliftp1.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.oneliftp1.OneLiftApplication
import com.example.oneliftp1.OneLiftViewModel
import com.example.oneliftp1.OneLiftViewModelFactory
import com.example.oneliftp1.R
import com.example.oneliftp1.activities.CreateWorkout

class CreateFragment: Fragment() {
   // val viewModel: OneLiftViewModel by activityViewModels{
    //    OneLiftViewModelFactory((application as OneLiftApplication).repository)
   // }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the view
        val view: View = inflater.inflate(R.layout.create_fragment, container, false)
        val btnCreate: Button = view.findViewById(R.id.btnCreate)

        btnCreate.setOnClickListener {

            activity?.let{

                val intent = Intent(it, CreateWorkout::class.java)
                it.startActivity(intent)}

        }
//
       //viewModel.addNewWorkout(0,"legs", "Me")


        return view
    }


}