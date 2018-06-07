package com.test.demo.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 *
 * Created by quhong on 2018/6/6.
 */
@Entity(tableName = "students")
data class Student(
        @PrimaryKey val id: Long,
        val name: String,
        val age: Int
)