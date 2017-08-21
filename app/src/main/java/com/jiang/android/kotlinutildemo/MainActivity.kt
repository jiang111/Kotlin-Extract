package com.jiang.android.kotlinutildemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jyuesong.android.kotlin.extract.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp_saveString("sdf", "saf")
        val t = _async {
            Thread.sleep(3000)

            _runUI {
                hello.text = "3000"
            }
            Thread.sleep(2000)

            _runUI {
                hello.text = "4000"
            }
        }


        val json: String = """
            { "code" : "0",
  "text" : "hello world"
}
            """

        _json(msg = json)

        _v("sfd")

        _i(msg = "hadsfsdfs")

        hello.apply {
            text = "sd"
            setOnClickListener {
                _startActivityForResult<Main2Activity>(12, "id" to 5, "name" to "jiang", "age" to 12, "male" to true)
            }

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        _toast("requestCode:$requestCode resultCode:$resultCode")
    }
}
