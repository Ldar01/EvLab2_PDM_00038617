package com.example.paletargb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.paletargb.Fragments.Dinamic
import com.example.paletargb.Fragments.Static.onFragmentStatic

class MainActivity : AppCompatActivity(), onFragmentStatic{

    var change_color:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun ClickNextOrPrev(button_clicked: View) {

    }

    /*override fun ClickPlusOrMinus(button_clicked: Int) {
        var cont :Int = 0
        when(button_clicked){
            R.id.button_plus ->{
                button_plus.setOnClickListener {
                    cont += 10
                    if(cont > 255){
                        cont = 0
                        panel_frame.setBackgroundColor(cont)
                    }else{
                        panel_frame.setBackgroundColor(cont)
                    }
                }
            }
            R.id.button_minus ->{
                button_minus.setOnClickListener {
                    cont -= 10
                    if(cont > 0){
                        panel_frame.setBackgroundColor(cont)
                    }else{
                        cont = 255
                        panel_frame.setBackgroundColor(cont)
                    }
                }
            }
        }

    }*/

    fun changeFragment(frag: Dinamic) {
        var fragManager = supportFragmentManager
        var transactionFrag = fragManager.beginTransaction()

        transactionFrag.replace(R.id.fragment_2, frag)
        transactionFrag.commit()
    }
}
