package com.example.z4project.view

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import kotlinx.android.synthetic.main.item_ilustration_list.view.*
import java.net.URL

data class IlustrationADP(var mDATAset:List<Ilustration>,
                          var eIntent:ToEIntent):RecyclerView.Adapter<IlustrationADP.IlustrationHolder>(){

    private val BASEURL: String = "https://corvalan.dev/evade/images/"
    fun updateViewModel(ilustrationList: List<Ilustration>) {     //for update observer, usually for  Adapter with a empty List() in the destine.
        mDATAset = ilustrationList
        notifyDataSetChanged()

    }

    inner class IlustrationHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        //val idText = itemView.idcode
        val auth = itemView.auth
        val dataTime = itemView.datime
        val piePhoto = itemView.piedefoto
        val ilustration0 = itemView.ilustration
        val itemView = itemView.auth.setOnClickListener(this)
        override fun onClick(v: View?) {
            eIntent.goIgtent(mDATAset[adapterPosition].url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IlustrationHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ilustration_list, parent, false)

        return IlustrationHolder(view)
    }

    override fun onBindViewHolder(holder: IlustrationHolder, position: Int) {
        val ilustracion: Ilustration = mDATAset[position]
        //holder.idText.text = ilustracion.id
        holder.auth.text = ilustracion.autor
        holder.dataTime.text = ilustracion.fechapub
        holder.piePhoto.text = ilustracion.caption
        Glide.with(holder.itemView.context).load(BASEURL + mDATAset[position].id).into(holder.ilustration0)
        //Picasso.get().load(mDATAset[position].url).resize(250,250).centerInside().into(holder.ilustration0)
    }

    override fun getItemCount(): Int {
        return mDATAset.size
    }

    interface ToEIntent{
        fun goIgtent(urlGo: String)
    }
}