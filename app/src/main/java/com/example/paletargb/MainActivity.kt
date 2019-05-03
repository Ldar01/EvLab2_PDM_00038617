package com.example.paletargb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.paletargb.Fragments.Dinamic
import com.example.paletargb.Fragments.Static
import com.example.paletargb.Fragments.Static.onFragmentStatic
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_static.*

class MainActivity : AppCompatActivity(), onFragmentStatic  {

    override fun ClickNextOrPrev() {

        val fragManager = supportFragmentManager
        val transaction_frag = fragManager.beginTransaction()



        var change_color = 0

        button_previous.setOnClickListener {
            if (change_color == 0){
                change_color = 2

                var dinamic_frag = Dinamic()

                transaction_frag.replace(R.id.fragment_2, dinamic_frag)

                transaction_frag.commit()

            }else{
                change_color -= 1
            }
        }
        button_next.setOnClickListener {
            if (change_color == 2){
                change_color = 0
            }else{
                change_color += 1
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ClickNextOrPrev()
    }
}
