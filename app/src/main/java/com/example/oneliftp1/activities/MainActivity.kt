package com.example.oneliftp1.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.oneliftp1.MyPageAdapter
import com.example.oneliftp1.R
import com.example.oneliftp1.WorkoutDAO
import com.example.oneliftp1.WorkoutRoomDatabase
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.jar.Manifest

lateinit var db: WorkoutRoomDatabase
lateinit var dao: WorkoutDAO

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("create"))
        tabLayout.addTab(tabLayout.newTab().setText("browse"))
        tabLayout.addTab(tabLayout.newTab().setText("progress"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL


        val viewPager = findViewById<ViewPager2>(R.id.pager)
        val adapter = MyPageAdapter(this, 4)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Page " + (position + 1)
        }.attach()

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.RECEIVE_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.RECEIVE_SMS,
                    android.Manifest.permission.SEND_SMS
                ),
                111
            )
        } else
            receiveMsg()

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            receiveMsg()
        }

    }

    private fun receiveMsg() {
        var br = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                    for (sms in Telephony.Sms.Intents.getMessagesFromIntent(p1)) {
                        Toast.makeText(
                            applicationContext,
                            "hello" + sms.displayMessageBody,
                            Toast.LENGTH_LONG
                        ).show()


                    }
                }
            }

        }
        registerReceiver(br, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))

    }


}