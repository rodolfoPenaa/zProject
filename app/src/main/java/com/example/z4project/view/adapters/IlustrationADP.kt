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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class IlustrationADP(var mDATAset:List<Ilustration>,
                          var eIntent: ToEIntent
):RecyclerView.Adapter<IlustrationADP.IlustrationHolder>(){

    val BASEURL: String = "https://corvalan.dev/evade/images/"

    fun updateViewModel(ilustrationList: List<Ilustration>) {
        mDATAset = ilustrationList
        notifyDataSetChanged()
    }

    inner class IlustrationHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener,
        View.OnLongClickListener {
        val auth = itemView.auth
        val authSay = itemView.auth_say
        val dataTime = itemView.datime
        val piePhoto = itemView.piedefoto
        val ilustration0 = itemView.ilustration
        val itemtofavDDBB = itemView.ilustration.setOnLongClickListener(this)
        val itemViewforIntent = itemView.auth.setOnClickListener(this)
        val itemVforIntent = itemView.auth_say.setOnClickListener(this)

        override fun onClick(v: View?) {
            eIntent.goIgtent(mDATAset[adapterPosition].url)
        }
        override fun onLongClick(p0: View?): Boolean {
            eIntent.toInsertFavDDBB(mDATAset[adapterPosition])
            eIntent.changeToFav(mDATAset[adapterPosition])
        return true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IlustrationHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ilustration_list, parent, false)
        return IlustrationHolder(view)
    }

    override fun onBindViewHolder(holder: IlustrationHolder, position: Int) {
        val ilustracion: Ilustration = mDATAset[position]
        val IlustrationHost = BASEURL + mDATAset[position].id
        Glide.with(holder.itemView.context).load(IlustrationHost).into(holder.ilustration0)
        holder.auth.text = ilustracion.autor
        holder.authSay.text = ilustracion.autor
        holder.dataTime.text = ilustracion.fechapub
        holder.piePhoto.text = ilustracion.caption
    }

    override fun getItemCount(): Int {
        return mDATAset.size
    }

    interface ToEIntent{
        fun goIgtent(urlGo: String)
        fun toInsertFavDDBB(favs:Ilustration)
        fun changeToFav(favToOff:Ilustration)
    }
}