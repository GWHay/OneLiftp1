package com.example.oneliftp1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.oneliftp1.fragments.BrowseFragment
import com.example.oneliftp1.fragments.CreateFragment
import com.example.oneliftp1.fragments.HomeFragment
import com.example.oneliftp1.fragments.ShareFragment

class MyPageAdapter(fa: FragmentActivity, private val mNumOfTabs: Int) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return mNumOfTabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CreateFragment()
            2 -> BrowseFragment()
            3 -> ShareFragment()
            else -> HomeFragment()
        }
    }

}