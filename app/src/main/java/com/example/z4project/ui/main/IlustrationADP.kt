package com.example.z4project.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.z4project.R
import com.example.z4project.model.Ilustration
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_ilustration_list.view.*

class IlustrationADP(var mDATAset:List<Ilustration>):RecyclerView.Adapter<IlustrationADP.IlustrationHolder>(){

    fun updateViewModel(ilustrationList: List<Ilustration>){
        mDATAset=ilustrationList
        notifyDataSetChanged()

    }
class IlustrationHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val idText= itemView.idcode
    val auth= itemView.auth
    val dataTime= itemView.datime
    val piePhoto= itemView.piedefoto
    val ilustration0= itemView.ilustration
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IlustrationHolder {
        val view:View= LayoutInflater.from(parent.context).inflate(R.layout.item_ilustration_list,parent,false)
        return IlustrationHolder(view)
    }

    override fun onBindViewHolder(holder: IlustrationHolder, position: Int) {
    val ilustracion:Ilustration=mDATAset[position]
        holder.idText.text=ilustracion.id
        holder.auth.text=ilustracion.autor
        holder.dataTime.text=ilustracion.fechapub
        holder.piePhoto.text=ilustracion.caption
        //Glide.with(holder.itemView.context).load(mDATAset[position].url).into(holder.ilustration0)
        Picasso.get().load(mDATAset[position].url).resize(350,350).centerCrop().into(holder.ilustration0)
    }

    override fun getItemCount(): Int {
        return mDATAset.size
    }
}