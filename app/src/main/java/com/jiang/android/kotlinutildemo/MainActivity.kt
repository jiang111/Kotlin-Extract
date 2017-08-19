package com.jiang.android.kotlinutildemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jyuesong.android.kotlin.extract.async
import com.jyuesong.android.kotlin.extract.runUI
import com.jyuesong.android.kotlin.extract.sp_saveString
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp_saveString("sdf", "saf")
        val t = async {
            Thread.sleep(3000)

            runUI {
                hello.text = "3000"
            }
            Thread.sleep(2000)

            runUI {
                hello.text = "4000"
            }
        }

        hello.apply {
            text="sd"
        }


    }
}
