package com.example.z4project.view.adapters

import android.transition.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import com.example.z4project.model.IlustrationFavEntity
import kotlinx.android.synthetic.main.fragment_favorite.view.*
import kotlinx.android.synthetic.main.item_ilustration_list.view.*

class FavoriteAdapter(var mDATAset:List<IlustrationFavEntity>,
                      var eIntent: FavoriteAdapter.ToeIntent):RecyclerView.Adapter<FavoriteAdapter.FavHolder>(){

    fun updateFavVM(ilustrationList: List<IlustrationFavEntity>) {
        mDATAset = ilustrationList
        notifyDataSetChanged()
    }
    fun intToObject(itemposition:Int):IlustrationFavEntity{
        return mDATAset[itemposition]
    }

    val BASEURL: String = "https://corvalan.dev/evade/images/"

    inner class FavHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val auth = itemView.auth
        val authSay = itemView.auth_say
        val dataTime = itemView.datime
        val piePhoto = itemView.piedefoto
        val ilustration1 = itemView.ilustration
        val gotoinstagram = itemView.auth.setOnClickListener(this)
        val gogoIg = itemView.auth_say.setOnClickListener(this)


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
        val IlustrationHost = BASEURL + mDATAset[position].id
        holder.auth.text = favIlustration.autor
        holder.authSay.text = favIlustration.autor+":"
        Glide.with(holder.itemView.context).load(IlustrationHost).into(holder.ilustration1)
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