package com.example.tugaschapter6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaschapter6.tugas1.HitungBBNActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_tugas1.setOnClickListener {
            startActivity(Intent(this, HitungBBNActivity::class.java))
        }

    }
}