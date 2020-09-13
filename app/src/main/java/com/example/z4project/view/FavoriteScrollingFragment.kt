package com.example.z4project.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import com.example.z4project.viewModel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.view.*

class FavoriteScrollingFragment : Fragment(),IlustrationADP.ToEIntent {
    private var updateFavList:List<Ilustration> = ArrayList<Ilustration>()
    private lateinit var favViewModel: MainViewModel
    private lateinit var ilustratingFavADP: IlustrationADP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        favViewModel.exposeFromFavDDBB()
        ilustratingFavADP= IlustrationADP(updateFavList,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_favorite_scrolling, container, false)
        view.recycled_container.adapter = ilustratingFavADP
        view.recycled_container.layoutManager = LinearLayoutManager(activity)
        favViewModel.getDATAr00m().observe(viewLifecycleOwner, Observer {
            ilustratingFavADP.updateViewModel(it)
        })
        return view
    }

    override fun goIgtent(urlGo: String) {
        val favgogo: Uri = Uri.parse(urlGo)
        val ifavintent : Intent = Intent(Intent.ACTION_VIEW,favgogo)
        startActivity(ifavintent)
    }
}