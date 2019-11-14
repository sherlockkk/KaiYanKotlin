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
        setFragments(fm, fragments, titles)
    }

    private fun setFragments(
        fm: FragmentManager,
        fragments: java.util.ArrayList<Fragment>,
        titles: java.util.ArrayList<String>
    ) {
        this.titles = titles
        if (this.fragments.isEmpty()) {
            val transaction = fm.beginTransaction()
            fragments.forEach { transaction.remove(it) }
            transaction.commitAllowingStateLoss()
            fm.executePendingTransactions()
        }
        this.fragments = fragments
        notifyDataSetChanged()
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