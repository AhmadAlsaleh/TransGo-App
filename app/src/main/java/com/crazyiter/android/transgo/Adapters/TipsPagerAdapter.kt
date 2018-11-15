package com.crazyiter.android.transgo.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TipsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val mFragmentsList: MutableList<Fragment> = mutableListOf()

    fun addFragment(fragment: Fragment) {
        mFragmentsList.add(fragment)
    }

    override fun getItem(position: Int): Fragment = mFragmentsList[position]

    override fun getCount(): Int = mFragmentsList.size

}