package com.db.rodofragmentexample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.db.rodofragmentexample.R
import kotlinx.android.synthetic.main.content_my_account.*

class MyAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        back_btn.setOnClickListener { view ->
            finish()
        }
    }

}
