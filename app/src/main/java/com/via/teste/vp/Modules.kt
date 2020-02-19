package com.via.teste.vp

import com.via.teste.ui.produtos.ProdutosContract
import com.via.teste.ui.produtos.ProdutosPresenter
import com.via.teste.ui.produtos.detalhe.ProdutoDetContract
import com.via.teste.ui.produtos.detalhe.ProdutoDetPresenter
import org.koin.dsl.module.applicationContext

//val utilsModule = applicationContext {
//    bean { NetWorkUtils( get() ) }
//    bean { PrefToken( get () ) }
//}

val produtosModule = applicationContext {
    factory { ProdutosPresenter (/*get () , get()*/) as ProdutosContract.Presenter }
    factory { ProdutoDetPresenter () as ProdutoDetContract.Presenter }
}