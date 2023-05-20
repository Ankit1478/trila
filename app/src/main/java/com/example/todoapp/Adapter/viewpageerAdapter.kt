package com.example.todoapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.ListFragment

class viewpageerAdapter(var manager:FragmentManager,var fragmentlist:ArrayList<Fragment>,var fragmentitle:ArrayList<String> ):FragmentPagerAdapter(manager){
    override fun getCount(): Int {
        return fragmentlist.size
    }
    override fun getItem(position: Int): Fragment {
       return fragmentlist.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return  fragmentitle.get(position)
    }
    fun addFragment(fragment: Fragment, title:String){
        fragmentlist.add(fragment)
        fragmentitle.add(title)
    }

}