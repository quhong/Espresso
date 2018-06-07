package com.test.demo

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.test.demo.db.Student

/**
 *
 * Created by quhong on 2018/6/6.
 */
class StudentPageAdapter : PagedListAdapter<Student, StudentViewHolder>(diff) {

    companion object {
        private val diff = object : DiffUtil.ItemCallback<Student>() {
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean =
                    oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        getItem(position)?.let {
            holder.label.text = String.format("id %d name %s age %d", it.id, it.name, it.age)
        }
    }
}