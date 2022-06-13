package br.com.zup.desafioandroidcore.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Produto(var nome:String, var quantidade:Double, var valor:Double, var receiver:String):Parcelable