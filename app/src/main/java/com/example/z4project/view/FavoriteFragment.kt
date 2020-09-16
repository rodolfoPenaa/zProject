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
import com.example.z4project.model.IlustrationFavEntity
import com.example.z4project.view.adapters.FavoriteAdapter
import com.example.z4project.view.adapters.IlustrationADP
import com.example.z4project.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_favorite_scrolling.view.*

class FavoriteFragment : Fragment(), FavoriteAdapter.ToeIntent{

    private var updateFavList : List<IlustrationFavEntity> = ArrayList<IlustrationFavEntity>()
    private lateinit var favViewModel: MainViewModel
    private lateinit var ilustratingFavADP: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        favViewModel.exposeFromFavDDBB()
        ilustratingFavADP= FavoriteAdapter(updateFavList,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_favorite_scrolling, container, false)
        view.favorite_fragment_recycledview.adapter = ilustratingFavADP
        view.favorite_fragment_recycledview.layoutManager = LinearLayoutManager(activity)
        favViewModel.exposeFromFavDDBB().observe(viewLifecycleOwner, Observer {
            ilustratingFavADP.updateFavVM(it)
        })
        return view
    }

    override fun goIg(urlToGo: String) {
        val favgogo: Uri = Uri.parse(urlToGo)
        val ifavintent : Intent = Intent(Intent.ACTION_VIEW,favgogo)
        startActivity(ifavintent)
    }


}