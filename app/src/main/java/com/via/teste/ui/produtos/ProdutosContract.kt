package com.via.teste.ui.produtos

import com.via.teste.model.ProdutosData
import com.via.teste.vp.BasePresenter
import com.via.teste.vp.BaseView

interface ProdutosContract {

    interface View: BaseView<Presenter> {

        fun showProdutos(produtosData : ProdutosData)

        fun showListaVazia()

        fun showLoading()

        fun hideLoading()

    }

    interface Presenter: BasePresenter {

        fun getProdutos()

    }

}