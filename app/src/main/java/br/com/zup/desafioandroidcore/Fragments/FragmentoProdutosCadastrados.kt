package br.com.zup.desafioandroidcore.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.desafioandroidcore.Fragments.Adapter.ProdutoAdapter
import br.com.zup.desafioandroidcore.Model.Produto
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.databinding.FragmentProdutosCadastradosBinding

class ProdutosCadastrados : Fragment() {
    private lateinit var binding: FragmentProdutosCadastradosBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutosCadastradosBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adicionarListaProdutos()
    }
    private fun adicionarListaProdutos() {
        var listaProduto = mutableListOf<Produto>()
        var novaLista = arguments?.getParcelableArrayList<Produto>("PRODUTO")

        if (novaLista != null) {
           if (listaProduto.size == 0) {
               listaProduto = novaLista
           }
        }
        else {
            novaLista?.let { listaProduto.addAll(it) }
        }
        produtoAdapter.atualizarListaProduto(listaProduto)
        exibirRecycler()
    }
    private fun exibirRecycler(){
        binding.rvListaProdutosCadastrados.adapter = produtoAdapter
        binding.rvListaProdutosCadastrados.layoutManager = LinearLayoutManager(context)
    }

}