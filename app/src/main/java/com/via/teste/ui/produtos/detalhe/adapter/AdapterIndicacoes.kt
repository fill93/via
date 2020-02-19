package com.via.teste.ui.produtos.detalhe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.via.teste.R
import com.via.teste.model.Produto
import kotlinx.android.synthetic.main.adapter_produto.view.*

class AdapterIndicacoes (private val produtos : List<Produto>/*, private val callBack : AdapterCallBack*/) : RecyclerView.Adapter<AdapterIndicacoes.ViewHolder>() {

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : Produto) {

            Glide.with(itemView)
                .load(item.image)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder_image)
                .into(itemView.iv_produto)

            itemView.tv_nome.text = item.nome

            itemView.tv_valor_de.visibility = View.GONE
            itemView.tv_valor_por.visibility = View.GONE

            itemView.setOnClickListener {
                //callBack.produtoClicked(item)
                //TODO
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.adapter_produto, p0, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder : ViewHolder, i : Int) {
        holder.bind(produtos[i])
    }

    override fun getItemCount() = produtos.size

}