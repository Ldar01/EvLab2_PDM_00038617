package com.example.paletargb.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.paletargb.R
import kotlinx.android.synthetic.main.fragment_dinamic.*

class Dinamic : Fragment() {


    //var listener: onFragmentDinamic? = null

    private var color_id : Int = 0

    companion object{
        fun  newInstance(color_selection : Int): Dinamic {
            val newFragment = Dinamic()
            newFragment.color_id = color_selection
            return newFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        val view = inflater.inflate(R.layout.fragment_dinamic, container, false)

        panel_frame.setBackgroundColor(color_id)

        return view
    }
    /*
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is onFragmentDinamic) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface onFragmentDinamic{
        fun ClickPlusOrMinus( button_clicked: Int)
    }
    */
}
