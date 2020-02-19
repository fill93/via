package com.via.teste.ui.produtos

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.via.teste.R
import com.via.teste.model.Produto
import com.via.teste.model.ProdutosData
import com.via.teste.ui.produtos.adapter.AdapterCallBack
import com.via.teste.ui.produtos.adapter.AdapterProdutos
import com.via.teste.ui.produtos.detalhe.ProdutoDetAct
import com.via.teste.util.extDialogWindow
import com.via.teste.util.extHandleError
import kotlinx.android.synthetic.main.fragment_produtos.*
import org.koin.android.ext.android.inject

class ProdutosFragment : Fragment() , ProdutosContract.View , AdapterCallBack {

    override val presenter: ProdutosContract.Presenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_produtos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)

        setRecycleriew()
        presenter.getProdutos()

    }

    override fun showProdutos(produtosData : ProdutosData) {
        rv_produtos.adapter = AdapterProdutos(produtosData.produtos, this)
    }

    override fun showListaVazia() {
        activity?.extDialogWindow(getString(R.string.lista_vazia) , getString(R.string.continuar) ){
            Toast.makeText(activity,"Continuar press",Toast.LENGTH_SHORT).show()
        }
    }

    override fun produtoClicked(produto: Produto) {
        startActivity(Intent(context,ProdutoDetAct::class.java).apply {
            putExtra("PRODUTO",produto)
        })
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

    private fun setRecycleriew(){
        rv_produtos.layoutManager = GridLayoutManager(activity?.applicationContext,2)
    }

    override fun handleError(throwable: Throwable) {
        activity?.extHandleError(throwable)
    }

}

