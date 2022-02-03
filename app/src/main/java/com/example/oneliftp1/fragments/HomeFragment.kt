package com.example.oneliftp1.fragments

import android.os.Bundle
import android.telephony.SmsManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.oneliftp1.R

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the view
        val view: View = inflater.inflate(R.layout.home_fragment, container, false)
        val pNumber: TextView = view.findViewById(R.id.pNumber)
        val message: TextView = view.findViewById(R.id.message)
        val btnSend: Button = view.findViewById(R.id.btnSend)

        btnSend.setOnClickListener {

            var sms:SmsManager = SmsManager.getDefault()
            sms.sendTextMessage(pNumber.text.toString(),"me", message.text.toString(),null,null)
            //sendSMS(pNumber.text.toString(), message.text.toString())


        }

        return view
    }




}