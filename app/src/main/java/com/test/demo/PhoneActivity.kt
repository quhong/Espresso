package com.test.demo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_phone.*

/**
 *
 * Created by quhong on 2018/4/4.
 */

class PhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        btnCall.setOnClickListener {
            callPhone(etPhone.text.toString())
        }
    }

    private fun callPhone(number: String) {
        val hasCallPhonePermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED

        if (hasCallPhonePermission) {
            val intent = Intent(Intent.ACTION_CALL)
            val data = Uri.parse("tel:$number")
            intent.data = data
            startActivity(intent)
        } else {
            Toast.makeText(this, "没有权限", Toast.LENGTH_SHORT).show();
        }
    }

}