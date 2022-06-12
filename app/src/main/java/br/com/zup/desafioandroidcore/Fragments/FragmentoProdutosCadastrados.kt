package br.com.zup.desafioandroidcore.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.desafioandroidcore.Fragments.Adapter.ProdutoAdapter
import br.com.zup.desafioandroidcore.Model.Produto
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.databinding.FragmentCadastrarProdutoBinding
import br.com.zup.desafioandroidcore.databinding.FragmentProdutosCadastradosBinding
import br.com.zup.desafioandroidcore.databinding.ProdutoItemBinding
import java.lang.Exception

class ProdutosCadastrados : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_produtos_cadastrados, container, false)
    }
}