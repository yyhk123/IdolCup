package com.min.idolcup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<RelativeLayout>(R.id.button1);
        val button2 = findViewById<RelativeLayout>(R.id.button2);

        button1.setOnClickListener {
            val intent = Intent(this, Game::class.java);
            intent.putExtra("sex", decideSex(1))
            startActivity(intent);
        }

        button2.setOnClickListener {
            val intent = Intent(this, Game::class.java);
            intent.putExtra("sex", decideSex(2))
            startActivity(intent);
        }

    }

    fun decideSex(sex: Int):Int{
        return sex;
    }
}