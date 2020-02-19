package com.via.teste.ui.produtos

import com.via.teste.api.ApiManager
import com.via.teste.vp.BasePresenter
import com.via.teste.vp.BaseView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ProdutosPresenter : ProdutosContract.Presenter {

    private lateinit var view: ProdutosContract.View
    private var disposable: Disposable? = null

    override fun getProdutos() {
        ApiManager.requestApi.getProdutos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view.showLoading()
            }
            .doAfterTerminate {
                view.hideLoading()
            }
            .subscribe(
                {
                    if(it.produtos.isNotEmpty()){
                        view.showProdutos(it)
                    } else {
                        view.showListaVazia()
                    }
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
        if(view is ProdutosContract.View){
            this.view = view
        }
    }

    private fun handleError(throwable: Throwable){
        view.handleError(throwable)
    }

}