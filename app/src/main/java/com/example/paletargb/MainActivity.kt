package com.example.paletargb

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.paletargb.Fragments.Dinamic
import com.example.paletargb.Fragments.Static.onFragmentStatic
import kotlinx.android.synthetic.main.fragment_dinamic.*
import kotlinx.android.synthetic.main.fragment_static.*

class MainActivity : AppCompatActivity(), onFragmentStatic, Dinamic.onFragmentDinamic {

    var change_color:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ClickNextOrPrev(R.id.button_next)
    }
    override fun ClickNextOrPrev(button_clicked: Int) {

        val fragManager = supportFragmentManager
        val transactionFrag = fragManager.beginTransaction()

        when(button_clicked){
            R.id.button_previous -> {
                button_previous.setOnClickListener {
                    when(change_color){
                        0 -> {
                            change_color = 2
                            var dinamic_frag = Dinamic()
                            dinamic_frag.panel_frame.setBackgroundColor(Color.green(0))

                            Log.d("Click", "Click desde :v")
                            transactionFrag.replace(R.id.fragment_2, dinamic_frag)
                            transactionFrag.commit()
                        }
                        1 -> {
                            change_color =- 1
                            var dinamic_frag = Dinamic()
                            dinamic_frag.panel_frame.setBackgroundColor(Color.blue(0))
                            transactionFrag.replace(R.id.fragment_2, dinamic_frag)
                            transactionFrag.commit()
                        }
                        2 -> {
                            change_color =-1
                            var dinamic_frag = Dinamic()
                            dinamic_frag.panel_frame.setBackgroundColor(Color.red(0))
                            transactionFrag.replace(R.id.fragment_2, dinamic_frag)
                            transactionFrag.commit()
                        }
                    }
                }
            }
            R.id.button_next -> {
                button_next.setOnClickListener {
                    when(change_color){
                        0 -> {
                            change_color =+ 1
                            var dinamic_frag = Dinamic()
                            dinamic_frag.panel_frame.setBackgroundColor(Color.red(0))
                            transactionFrag.replace(R.id.fragment_2, dinamic_frag)
                            transactionFrag.commit()
                        }
                        1 -> {
                            change_color =+ 1
                            var dinamic_frag = Dinamic()
                            dinamic_frag.panel_frame.setBackgroundColor(Color.blue(0))
                            transactionFrag.replace(R.id.fragment_2, dinamic_frag)
                            transactionFrag.commit()
                        }
                        2 -> {
                            change_color = 0
                            var dinamic_frag = Dinamic()
                            dinamic_frag.panel_frame.setBackgroundColor(Color.green(0))
                            transactionFrag.replace(R.id.fragment_2, dinamic_frag)
                            transactionFrag.commit()
                        }
                    }
                }
            }
        }
    }

    override fun ClickPlusOrMinus(button_clicked: Int) {
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

    }
}
