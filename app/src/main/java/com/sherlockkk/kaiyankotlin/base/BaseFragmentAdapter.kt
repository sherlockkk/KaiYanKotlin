package com.sherlockkk.kaiyankotlin.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class BaseFragmentAdapter : FragmentStatePagerAdapter {

    private var fragments = ArrayList<Fragment>()
    private var titles = ArrayList<String>()

    constructor(fm: FragmentManager, fragments: ArrayList<Fragment>, titles: ArrayList<String>) : super(
        fm,
        BEHAVIOR_SET_USER_VISIBLE_HINT
    ) {
        this.fragments = fragments
        this.titles = titles
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}