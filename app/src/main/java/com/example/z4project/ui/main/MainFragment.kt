package com.example.z4project.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import com.example.z4project.model.Rclient
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.main_fragment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private var catchedList:List<Ilustration> = ArrayList<Ilustration>()

    private lateinit var mViewModel: MainViewModel
    private lateinit var ilustratingADP:IlustrationADP


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.refreshDATAserver()
        ilustratingADP= IlustrationADP(catchedList)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view:View = inflater.inflate(R.layout.main_fragment, container, false)
        view.recycled_container.adapter = ilustratingADP
        view.recycled_container.layoutManager = LinearLayoutManager(activity)

        mViewModel.getDATAr00m().observe(viewLifecycleOwner, Observer {
            Log.d("DEBUG", it.toString())
            ilustratingADP.updateViewModel(it)
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       //viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    }

}