package com.via.teste.ui.produtos.detalhe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.df.imageslider.CallOnClickSlider
import com.df.imageslider.SliderItem
import com.via.teste.R
import com.via.teste.model.Produto
import com.via.teste.model.ProdutoDetalhes
import com.via.teste.ui.produtos.detalhe.adapter.AdapterCaracteristicas
import com.via.teste.ui.produtos.detalhe.adapter.AdapterIndicacoes
import com.via.teste.util.extHandleError
import com.via.teste.util.extMoneyStr
import kotlinx.android.synthetic.main.activity_produto_det.*
import org.koin.android.ext.android.inject

class ProdutoDetAct : AppCompatActivity() , ProdutoDetContract.View , CallOnClickSlider {

    override val presenter: ProdutoDetContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto_det)
        presenter.attachView(this)

        //val produto = intent.getParcelableExtra("PRODUTO") as Produto
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initComponentes()
        presenter.getDetalheProduto()

    }

    override fun showDetalhesProduto(produtoDetalhes: ProdutoDetalhes) {
        supportActionBar?.title = produtoDetalhes.nome

        val listImageSlider = mutableListOf<SliderItem>()
        produtoDetalhes.modelo.padrao.imagens.map {
            listImageSlider.add(SliderItem(url = it.url))
        }

        slide_produto.setPages( listImageSlider , R.drawable.ic_placeholder_image )

        tv_nome.text = produtoDetalhes.nome
        tv_descricao.text = produtoDetalhes.descricao
        tv_valores_de.text = produtoDetalhes.modelo.padrao.preco.precoAnterior.extMoneyStr()
        tv_valores_por.text = produtoDetalhes.modelo.padrao.preco.precoAtual.extMoneyStr()
        tv_parcelamento.text = produtoDetalhes.modelo.padrao.preco.planoPagamento

        rv_caracteristicas.adapter = AdapterCaracteristicas(produtoDetalhes.maisInfos[0].valores.filter { it.valor.length < 300 })
    }

    override fun showIndicacoes( produtos : List<Produto> ) {
        rv_indicacoes.adapter = AdapterIndicacoes(produtos)
    }

    private fun initComponentes(){
        slide_produto.handleAnimate(3500)
        slide_produto.actionSetCall(this)

        rv_caracteristicas.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_indicacoes.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

    }

    override fun onClickSlider(item: SliderItem) {
        Toast.makeText(this,"Implemetar ação",Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
    }

    override fun showLoadingIndicacoes() {
        progress_indicacoes.visibility = View.VISIBLE
    }

    override fun hideLoadingIndicacoes() {
        progress_indicacoes.visibility = View.GONE
    }

    override fun handleError(throwable: Throwable) {
        extHandleError(throwable)
    }
}
