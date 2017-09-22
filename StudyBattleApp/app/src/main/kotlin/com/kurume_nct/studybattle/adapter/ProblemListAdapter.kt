package com.kurume_nct.studybattle.adapter

import android.content.Context
import android.database.DataSetObserver
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kurume_nct.studybattle.BR
import com.kurume_nct.studybattle.R
import com.kurume_nct.studybattle.`object`.Problem
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter

class ProblemListAdapter(context: Context, val list: MutableList<Problem>, val callBack: (Int) -> Unit)
    : RecyclerView.Adapter<ProblemListAdapter.ProblemListHolder>(), StickyListHeadersAdapter {

    lateinit var view: View
    lateinit var holder: ProblemListAdapter.ProblemListHolder
    override fun onBindViewHolder(holder: ProblemListHolder, position: Int) {
        holder.binding.setVariable(BR.Item, list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProblemListHolder {
        view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_problem, parent, false)
        holder = ProblemListHolder(view)

        view.tag = ProblemListHolder(view)

        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            callBack(position)
        }
        return holder
    }

    inner class ProblemListHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ViewDataBinding = DataBindingUtil.bind(view)
    }

    override fun getItemCount(): Int = list.size

    fun itemId(position: Int) = list[position].id

    override fun isEmpty(): Boolean = list.isEmpty()

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_problem, parent, false)
        view.tag = ProblemListHolder(view)
        return view
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {}

    override fun getItem(position: Int) = list[position]

    override fun getViewTypeCount(): Int = list[list.size - 1].kind.toInt()

    override fun isEnabled(position: Int): Boolean = true

    override fun getHeaderId(position: Int): Long = list[position].kind

    override fun areAllItemsEnabled(): Boolean = true

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {}

    override fun getCount(): Int = list.size

    override fun getHeaderView(position: Int, convertView: View, parent: ViewGroup): View {
        val stView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.sticky_header, parent, false)
        holder = ProblemListHolder(view)
        view.tag = holder


        return view
    }

}