package com.example.paletargb.Fragments

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.paletargb.R

class Static : Fragment() {

    var choose_color:Int = 0
    var listener: onFragmentStatic? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_static, container, false)

        return view
    }

    interface onFragmentStatic{
        fun ClickNextOrPrev( button_clicked: Int)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is onFragmentStatic) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}
