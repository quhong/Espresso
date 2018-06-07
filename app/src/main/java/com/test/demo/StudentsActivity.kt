package com.test.demo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.test.demo.db.SchoolViewModel
import kotlinx.android.synthetic.main.activity_student_list.*

/**
 *
 * Created by quhong on 2018/6/6.
 */
class StudentsActivity : AppCompatActivity() {

    lateinit var schoolViewModel: SchoolViewModel

    val adapter = StudentPageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)


        schoolViewModel = ViewModelProviders.of(this).get(SchoolViewModel::class.java)
        studentList.adapter = adapter
        studentList.layoutManager = LinearLayoutManager(this)

        schoolViewModel.pagerList.observe(this, Observer { adapter.submitList(it) })

        schoolViewModel.refreshState.observe(this, Observer { resource ->
            if (resource == null) {
                return@Observer
            }

            when (resource.status) {
                Status.LOADING -> {
                    refresh.isRefreshing = true
                }
                Status.SUCCESS -> {
                    refresh.isRefreshing = false
                }
                Status.ERROR -> {
                    Toast.makeText(this, resource.message, Toast.LENGTH_LONG).show()
                    refresh.isRefreshing = false
                }
            }

        })

        refresh.setOnRefreshListener {
            schoolViewModel.refresh()
        }
//        val students = studentDao.students()
//        Log.i("123", "list size ${students.size}")
//        Timber.d("list size ${students.size}")

    }
}