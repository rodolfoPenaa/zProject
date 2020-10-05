package com.example.z4project.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.z4project.R
import com.example.z4project.viewModel.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_init.view.*


class InitFragment : Fragment() {
    private val WELCOMEURL:String="https://rodolfopenaa.github.io/ep.1/v2zh0r4Pr0j3ct.jpg"
    private val WELCOMEURLS:String="https://picsum.photos/400"
    private lateinit var mViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel= ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_init, container, false)
        mViewModel.fetchPhrase()
        mViewModel.fromRepository.word0.observe(viewLifecycleOwner,{
            view.welcomewords.text = it.affirmation
            Log.d("me init", it.affirmation)
        })
        mViewModel.word1.observe(viewLifecycleOwner,{
            Toast.makeText(context, it,Toast.LENGTH_LONG).show()
        })

        Picasso.get()
            .load(WELCOMEURLS)
            .placeholder(R.drawable.img_charge_foreground)
            .resize(640,480)
            .into(view.introApp)
        view.igButton.setOnClickListener{
            findNavController().navigate(R.id.action_initFragment_to_mainFragment)
        }
        return view
    }

}