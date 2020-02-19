package com.via.teste

import com.via.teste.model.PrecoProduto
import com.via.teste.model.Produto
import org.junit.Assert
import org.junit.Test

class ProdutoTeste {

    @Test
    fun descontoMaiorQueZero_isCorrect() {

        val produto_1 = Produto(precoProduto = PrecoProduto( descontoPercent = 0.0 ))
        val produto_2 = Produto(precoProduto = PrecoProduto( descontoPercent = 1.0 ))
        val produto_3 = Produto(precoProduto = PrecoProduto( descontoPercent = -1.0 ))

        Assert.assertTrue   (produto_1.descontoMaiorQueZero())
        Assert.assertTrue   (produto_2.descontoMaiorQueZero())
        Assert.assertFalse  (produto_3.descontoMaiorQueZero())
    }

}