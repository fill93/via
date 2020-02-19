package com.via.teste.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

data class ProdutosData(
    @Json(name = "produtos")            val produtos : List<Produto>
)

@Parcelize
data class Produto(
    @Json(name = "id")                  val id: Long = 0,
    @Json(name = "sku")                 val ddd: Long = 0,
    @Json(name = "nome")                val nome: String = "",
    @Json(name = "disponivel")          val isDisponivel: Boolean = false,
    @Json(name = "descricao")           val descricao: String = "",
    @Json(name = "imagemUrl")           val image: String = "",
    @Json(name = "classificacao")       val classificacao: Double = 0.0,
    @Json(name = "preco")               val precoProduto : PrecoProduto?
) : Parcelable {

    /**
     * Função usada apenas p/ demonstração do Teste**
     */
    fun descontoMaiorQueZero() : Boolean {
        return precoProduto!!.descontoPercent >= 0
    }
}

@Parcelize
data class PrecoProduto(
    @Json(name = "planoPagamento")              val planoPagamento: String = "",
    @Json(name = "valorParcela")                val valorParcela: Double = 0.0,
    @Json(name = "precoAtual")                  val precoAtual: Double = 0.0,
    @Json(name = "precoAnterior")               val precoAnterior: Double = 0.0,
    @Json(name = "porcentagemDesconto")         val descontoPercent: Double = 0.0,
    @Json(name = "quantidadeMaximaParcelas")    val parcelasMax : Int = 0
) : Parcelable

data class ProdutoDetalhes(
    @Json(name = "id")                  val id: Long = 0,
    @Json(name = "nome")                val nome: String = "",
    @Json(name = "retiraEmLoja")        val isDisponivel: Boolean = false,
    @Json(name = "descricao")           val descricao: String = "",
    @Json(name = "categorias")          val categorias: List<Categoria>,
    @Json(name = "maisInformacoes")     val maisInfos : List<MaisInfos>,
    @Json(name = "marca")               val marca : Marca,
    @Json(name = "modelo")              val modelo : Modelo
)

data class Modelo(
    @Json(name = "padrao")              val padrao: Padrao
)

data class Padrao(
    @Json(name = "preco")               val preco: PrecoProduto,
    @Json(name = "imagens")             val imagens : List<Imagem>
)

data class Imagem(
    @Json(name = "id")                  val padrao: Long = 0,
    @Json(name = "url")                 val url : String = ""
)

data class Marca(
    @Json(name = "id")                  val id: Long = 0,
    @Json(name = "nome")                val nome: String = ""
)

data class Categoria(
    @Json(name = "id")                  val id : Long = 0,
    @Json(name = "descricao")           val descricao : String =""
)

data class MaisInfos(
    @Json(name = "descricao")           val descricao : String = "",
    @Json(name = "valores")             val valores : List<MaisInfoValores>
)

data class MaisInfoValores(
    @Json(name = "nome")                val nome: String = "",
    @Json(name = "valor")               val valor: String = ""
)

