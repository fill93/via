package com.via.teste.ui.produtos.detalhe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.via.teste.R
import com.via.teste.model.MaisInfoValores
import kotlinx.android.synthetic.main.adapter_caracteristicas.view.*

class AdapterCaracteristicas (private val caracteristicas : List<MaisInfoValores>) : RecyclerView.Adapter<AdapterCaracteristicas.ViewHolder>() {

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : MaisInfoValores) {

            itemView.tv_caracteristica.text = item.nome
            itemView.tv_valor.text = item.valor
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.adapter_caracteristicas, p0, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder : ViewHolder, i : Int) {
        holder.bind(caracteristicas[i])
    }

    override fun getItemCount() = caracteristicas.size

}