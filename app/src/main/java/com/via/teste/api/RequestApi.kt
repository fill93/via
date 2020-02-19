package com.via.teste.api
import com.via.teste.model.Produto
import com.via.teste.model.ProdutoDetalhes
import com.via.teste.model.ProdutosData
import io.reactivex.Single
import retrofit2.http.GET

interface RequestApi {

    @GET("5d1b4f0f34000074000006dd")
    fun getProdutos() : Single<ProdutosData>

    /**
     * Exclusiva para o Item de id : 2849249
     */
    @GET("5d1b4fd23400004c000006e1")
    fun getDetalheProduto() : Single<ProdutoDetalhes>

    @GET("5d1b507634000054000006ed")
    fun getIndicacoesDeProdutos() : Single<List<Produto>>

}