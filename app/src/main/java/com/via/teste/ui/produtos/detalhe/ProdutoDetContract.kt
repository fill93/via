package com.via.teste.ui.produtos.detalhe

import com.via.teste.model.Produto
import com.via.teste.model.ProdutoDetalhes
import com.via.teste.vp.BasePresenter
import com.via.teste.vp.BaseView

interface ProdutoDetContract {

    interface View: BaseView<Presenter> {

        fun showDetalhesProduto(produtoDetalhes: ProdutoDetalhes)

        fun showLoading()

        fun hideLoading()

        fun showLoadingIndicacoes()

        fun hideLoadingIndicacoes()

        fun showIndicacoes( produtos : List<Produto> )

    }

    interface Presenter: BasePresenter {

        fun getDetalheProduto()

    }

}