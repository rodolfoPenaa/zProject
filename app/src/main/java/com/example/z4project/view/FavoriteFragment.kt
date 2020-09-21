package com.example.z4project.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity
import com.example.z4project.view.adapters.FavoriteAdapter
import com.example.z4project.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_favorite.view.*

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
        val view:View = inflater.inflate(R.layout.fragment_favorite, container, false)
        view.favorite_fragment_recycledview.adapter = ilustratingFavADP
        view.favorite_fragment_recycledview.layoutManager = LinearLayoutManager(activity)
        favViewModel.exposeFromFavDDBB().observe(viewLifecycleOwner, Observer {
            ilustratingFavADP.updateFavVM(it)
        })

        val itemtouchH = object:
            ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Toast.makeText(context, "Erased", Toast.LENGTH_SHORT).show()
                val erasedItemPosition = viewHolder.adapterPosition
                val favItemErased = ilustratingFavADP.intToObject(erasedItemPosition)
                val objetoIlustration = toReturn(favItemErased)
                val goILustration = returnToAll(objetoIlustration)
                favViewModel.updateFromFav(goILustration)
                favViewModel.removeFromFav(favItemErased)
                Snackbar.make(
                    view.favorite_fragment_recycledview,
                    getString(R.string.UnderTacker),
                    Snackbar.LENGTH_LONG
                ).apply {
                    setAction("UNDO") {
                        favViewModel.saveFavorite(favItemErased)
                        favViewModel.undertacker(objetoIlustration)
                    }
                    setActionTextColor(Color.DKGRAY)
                }.show()
            }
        }
        val itemswipe = ItemTouchHelper(itemtouchH)
        itemswipe.attachToRecyclerView(view.favorite_fragment_recycledview)
        return view
    }

    override fun goIg(urlToGo: String) {
        val favgogo: Uri = Uri.parse(urlToGo)
        val ifavintent : Intent = Intent(Intent.ACTION_VIEW,favgogo)
        startActivity(ifavintent)
    }

    fun toReturn(fAll: IlustrationFavEntity):Ilustration {
        val all = Ilustration(id = fAll.id, autor = fAll.autor, url = fAll.url,fechapub = fAll.fechapub, caption = fAll.caption)
        return all
    }

    fun returnToAll(favOff: Ilustration):Ilustration {
        favOff.inFav = false
        return favOff
        }
}