package com.via.teste.ui.produtos.detalhe

import com.via.teste.api.ApiManager
import com.via.teste.vp.BasePresenter
import com.via.teste.vp.BaseView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ProdutoDetPresenter : ProdutoDetContract.Presenter  {

    private lateinit var view: ProdutoDetContract.View
    private var disposable: Disposable? = null

    override fun getDetalheProduto() {
        ApiManager.requestApi.getDetalheProduto()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view.showLoading()
            }
            .doAfterTerminate {
                view.hideLoading()
                getIndicacoesDeProdutos()
            }
            .subscribe(
                {
                    view.showDetalhesProduto(it)
                },
                ::handleError
            )
            .also { disposable = it }
    }

    private fun getIndicacoesDeProdutos() {
        ApiManager.requestApi.getIndicacoesDeProdutos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view.showLoadingIndicacoes()
            }
            .doAfterTerminate {
                view.hideLoadingIndicacoes()
            }
            .subscribe(
                {
                    view.showIndicacoes(it)
                },
                ::handleError
            )
            .also { disposable = it }
    }

    override fun start() {}

    override fun stop() {
        disposable?.dispose()
    }

    override fun attachView(view: BaseView<BasePresenter>) {
        if(view is ProdutoDetContract.View){
            this.view = view
        }
    }

    private fun handleError(throwable: Throwable){
        view.handleError(throwable)
    }

}