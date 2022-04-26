package com.example.tugaschapter6.tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.core.util.rangeTo
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import com.example.tugaschapter6.R
import kotlinx.android.synthetic.main.activity_hitung_bbnactivity.*

class HitungBBNActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_bbnactivity)

        bbnHandlerThread()

    }

    fun bbnHandlerThread(){
        val targetHandler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val getMessage = msg.obj as String
                tv_hasilbbn.text = getMessage
            }
        }

        Thread(Runnable {
            btn_hitungbbn.setOnClickListener {
                val berat_badan = et_beratbadan.text.toString().toDouble()
                val tinggi_badan = et_tinggibadan.text.toString().toDouble()

                val tinggibadankuadrat = tinggi_badan * tinggi_badan
                val hitungbbn = berat_badan / tinggibadankuadrat

                val hasilbbn = if (hitungbbn < 18.5){
                    "Kekurangan Berat Badan"
                } else if (hitungbbn in 18.5 .. 24.9){
                    "Normal (Ideal)"
                }else if (hitungbbn in 25.0 .. 29.9){
                    "Kelebihan Berat Badan"
                }else{
                    "Kegemukan (Obesitas)"
                }

                val message = Message.obtain()
                message.obj = hasilbbn
                message.target = targetHandler
                message.sendToTarget()
            }
        }).start()
    }
}