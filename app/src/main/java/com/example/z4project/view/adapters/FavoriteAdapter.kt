package com.example.z4project.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity
import kotlinx.android.synthetic.main.item_ilustration_list.view.*

class FavoriteAdapter(var mDATAset:List<IlustrationFavEntity>,
                      var eIntent: FavoriteAdapter.ToeIntent):RecyclerView.Adapter<FavoriteAdapter.FavHolder>(){

    fun updateFavVM(ilustrationList: List<IlustrationFavEntity>) {     //for update observer, usually for  Adapter with a empty List() in the destine.
        mDATAset = ilustrationList
        notifyDataSetChanged()
    }
    private val BASEurl: String = "https://corvalan.dev/evade/images/"
    inner class FavHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val auth = itemView.auth
        val dataTime = itemView.datime
        val piePhoto = itemView.piedefoto
        val ilustration1 = itemView.ilustration
        val gotoinstagram = itemView.auth.setOnClickListener(this)
        override fun onClick(v: View?) {
            eIntent.goIg(mDATAset[adapterPosition].url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_ilustration_list,parent,false)
        return FavHolder(view)
    }

    override fun onBindViewHolder(holder: FavHolder, position: Int) {
        val favIlustration: IlustrationFavEntity = mDATAset[position]
        holder.auth.text = favIlustration.autor
        Glide.with(holder.itemView.context).load(BASEurl+mDATAset[position].id).into(holder.ilustration1)
        holder.dataTime.text = favIlustration.fechapub
        holder.piePhoto.text = favIlustration.caption
    }

    override fun getItemCount(): Int {
        return mDATAset.size
    }
    interface ToeIntent{
        fun goIg(urlToGo:String)
    }
}