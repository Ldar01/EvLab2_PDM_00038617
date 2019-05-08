package com.example.paletargb

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.paletargb.Fragments.Dinamic
import com.example.paletargb.Fragments.Static.onFragmentStatic

class MainActivity : AppCompatActivity(), onFragmentStatic{

    private lateinit var dinamic_fragment: Dinamic
    private var counter = 0
    private val colors: IntArray = intArrayOf(Color.RED, Color.BLUE, Color.GREEN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    override fun ClickNext(v: View) {
        dinamic_fragment = Dinamic.newInstance(VerifyNextOrPrev(2))
        changeFragment(dinamic_fragment)
    }

    override fun ClickPrev(v: View) {
        dinamic_fragment = Dinamic.newInstance(VerifyNextOrPrev(1))
        changeFragment(dinamic_fragment)
    }

    fun VerifyNextOrPrev(button: Int) : Int{
        return when(button){
            1->{
               counter--
                if(counter<0) counter = 2
                    colors[counter]
            } else ->{
                counter++
                if(counter>2) counter = 0
                colors[counter]
            }
        }
    }

    fun changeFragment(frag: Dinamic) {
        var fragManager = supportFragmentManager
        var transactionFrag = fragManager.beginTransaction()

        transactionFrag.replace(R.id.fragment_2, frag)
        transactionFrag.commit()
    }
}
