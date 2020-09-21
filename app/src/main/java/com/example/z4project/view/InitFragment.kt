package com.example.z4project.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.z4project.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_init.view.*


class InitFragment : Fragment() {
    private val WELCOMEURL:String="https://rodolfopenaa.github.io/ep.1/v2zh0r4Pr0j3ct.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_init, container, false)
        //Glide.with(view.context.applicationContext).load(WELCOMEURL).into(view.introApp)
        Picasso.get().load(WELCOMEURL).placeholder(R.drawable.img_charge_foreground).resize(640,480).into(view.introApp)
        view.igButton.setOnClickListener{
            findNavController().navigate(R.id.action_initFragment_to_mainFragment)
        }
        return view
    }

}