package br.com.zup.desafioandroidcore.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Produto(private var nomeProduto:String, private var quantidadeProduto:Int,
              private var valorUnitProduto:Double, private var receita:String): Parcelable {
    fun getNomeProduto() = this.nomeProduto
    fun quantidadeProduto() = this.quantidadeProduto
    fun valorUnitProduto() = this.valorUnitProduto
    fun getReceita() = this.receita
}