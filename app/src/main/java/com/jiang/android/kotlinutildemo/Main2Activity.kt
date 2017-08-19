package com.jiang.android.kotlinutildemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

/**
 * Created by jiang on 2017/8/19.
 */
class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var id = intent.extras.getInt("id")
        var name = intent.extras.getString("name")
        var age = intent.extras.getInt("age")
        var male = intent.extras.getBoolean("male")

        _id.text = id.toString()
        _name.text = name
        _age.text = age.toString()
        _male.text = male.toString()
        setResult(100)

    }
}