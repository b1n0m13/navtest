package com.example.navtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment.view.*

class MyFragment : Fragment() {

    companion object {

        fun newInstance(index: Int): MyFragment =
            MyFragment().apply {
                arguments = Bundle(1).apply {
                    this.index = index
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w("MyFragment", "creating view for MyFragment ${arguments?.index}")

        val view = inflater.inflate(R.layout.fragment, container, false)
        view.fragment_title.text = "Fragment ${arguments?.index}"
        return view
    }

    var Bundle.index: Int
        get() = getInt("INDEX")
        set(value) = putInt("INDEX", value)
}