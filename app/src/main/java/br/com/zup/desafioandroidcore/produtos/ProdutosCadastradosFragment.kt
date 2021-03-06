package br.com.zup.desafioandroidcore.produtos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.produtos.adapter.ProdutoAdapter
import br.com.zup.desafioandroidcore.model.Produto
import br.com.zup.desafioandroidcore.databinding.FragmentProdutosCadastradosBinding

class ProdutosCadastrados : Fragment() {
    private lateinit var binding: FragmentProdutosCadastradosBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(),this::onClick)
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
        exibirRecyclerView()
    }
    fun onClick(produto:Produto) {
        val bundle = bundleOf("PRODUTO" to produto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_produtosCadastrados2_to_detalheProdutoFragment,bundle)
    }
    private fun exibirRecyclerView(){
        binding.rvListaProdutosCadastrados.adapter = produtoAdapter
        binding.rvListaProdutosCadastrados.layoutManager = LinearLayoutManager(context)
    }
    private fun recebendoDados() {
        val produtos = arguments?.getParcelableArrayList<Produto>("PRODUTOS")
        if (produtos != null) {
            produtoAdapter.atualizarListaProduto(produtos)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recebendoDados()
    }

}