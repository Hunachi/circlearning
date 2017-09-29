package com.kurume_nct.studybattle.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kurume_nct.studybattle.listFragment.AnswerFragment
import com.kurume_nct.studybattle.viewModel.AnswerViewModel

import com.kurume_nct.studybattle.R
import com.kurume_nct.studybattle.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() , AnswerViewModel.Callback{

    lateinit var binding : ActivityAnswerBinding
    private var fin : Boolean

    init {
        fin = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_answer)
        binding.answerAct = AnswerViewModel(this, this)
        fin = intent.getBooleanExtra("fin", false)
        supportFragmentManager.beginTransaction()
                .replace(R.id.answers_fragment, AnswerFragment().newInstance(fin))
                .commit()
    }
}