package com.example.oneliftp1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.oneliftp1.R

class ShareFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the view
        val view: View = inflater.inflate(R.layout.progress_fragment, container, false)



        return view
    }
}