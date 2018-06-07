package com.test.demo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 *
 * Created by quhong on 2018/6/6.
 */
class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val label: TextView = view.findViewById(android.R.id.text1)



    companion object {
        fun create(parent: ViewGroup): StudentViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(android.R.layout.simple_list_item_1, parent, false)
            return StudentViewHolder(view)
        }
    }
}