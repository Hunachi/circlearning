package com.kurume_nct.studybattle.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import com.kurume_nct.studybattle.ListFragment.MainListFragment
import com.kurume_nct.studybattle.R
import com.kurume_nct.studybattle.view.ProbemMainFragment

/**
 * Created by hanah on 9/18/2017.
 */
class MainPagerAdapter(mf: FragmentManager) : FragmentPagerAdapter(mf){

    private val mFragment = ArrayList<Fragment>()
    private val mf = mf

    init {
        mFragment.add(ProbemMainFragment.newInstance())
        mFragment.add(MainListFragment().newInstance(1))
        mFragment.add(MainListFragment().newInstance(2))
        mFragment.add(MainListFragment().newInstance(3))
    }

    override fun getItem(position: Int): Fragment {
        //transration de layout to connect do.
        Log.d("tab","hoho")
        val transration = mf.beginTransaction()
        val fragment = mFragment[position]
        transration.add(R.id.pager,fragment)
        return fragment
    }

    fun addFragment(fragment: Fragment){
        mFragment.add(fragment)
    }

    override fun getCount(): Int = mFragment.size

}