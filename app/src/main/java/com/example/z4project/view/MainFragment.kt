package com.example.z4project.view


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity
import com.example.z4project.view.adapters.IlustrationADP
import com.example.z4project.viewModel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment(), IlustrationADP.ToEIntent {
    private var catchedUpdateList:List<Ilustration> = ArrayList<Ilustration>()
    private lateinit var mViewModel: MainViewModel
    private lateinit var ilustratingADP: IlustrationADP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.refreshDATAserver()
        ilustratingADP= IlustrationADP(catchedUpdateList,this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view:View = inflater.inflate(R.layout.main_fragment, container, false)
        view.recycled_container.adapter = ilustratingADP
        view.recycled_container.layoutManager = LinearLayoutManager(activity)
        mViewModel.getDATAr00m().observe(viewLifecycleOwner, Observer {
            ilustratingADP.updateViewModel(it)
        })
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_favoriteScrollingFragment)
        }
        return view
    }

    override fun goIgtent(urlGo: String) {
        val gogo: Uri = Uri.parse(urlGo)
        val iintent : Intent = Intent(Intent.ACTION_VIEW,gogo)
        startActivity(iintent)
    }
    override fun toInsertFavDDBB(favs: Ilustration) {
        val favorite = IlustrationFavEntity(id = favs.id, autor = favs.autor, url = favs.url,fechapub = favs.fechapub, caption = favs.caption)
        mViewModel.saveFavorite(favorite)
        Toast.makeText(activity,R.string.FavAdded,Toast.LENGTH_SHORT).show()
    }

    override fun changeToFav(favOn: Ilustration) {
        favOn.inFav = true
        CoroutineScope(Dispatchers.IO).launch {
            favOn.let {
                mViewModel.updateToFav(favOn)
            }
        }
    }

}