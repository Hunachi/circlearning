package com.kurume_nct.studybattle.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kurume_nct.studybattle.ListFragment.GroupListFragment

import com.kurume_nct.studybattle.R
import com.kurume_nct.studybattle.databinding.ActivityRankingBinding
import com.kurume_nct.studybattle.viewModel.RankingViewModel

class RankingActivity : AppCompatActivity(), RankingViewModel.Callback {

    lateinit var binding : ActivityRankingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_ranking)
        binding.ranking = RankingViewModel(this,this)
        val fragment = GroupListFragment().newInstance(0)
        val trancelation = supportFragmentManager.beginTransaction()
        trancelation.replace(R.id.ranking_list_content,fragment)
        trancelation.commit()
    }
}