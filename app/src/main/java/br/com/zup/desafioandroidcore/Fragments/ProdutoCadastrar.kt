package br.com.zup.desafioandroidcore.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.desafioandroidcore.Fragments.Adapter.ProdutoAdapter
import br.com.zup.desafioandroidcore.Model.Produto
import br.com.zup.desafioandroidcore.databinding.FragmentProdutoCadastrarBinding
import java.lang.Exception

class ProdutoCadastrar : Fragment() {
    private lateinit var binding: FragmentProdutoCadastrarBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProdutoCadastrarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCadastrarProduto.setOnClickListener {
            adicionarProdutoItem()
        }
    }


    private fun recuperarDadosEditText(): Produto? {
        val nomeProduto = binding.editTextNomeCadastroProduto.text.toString()
        val quantidadeProduto = binding.editQuantidadeProduto.text.toString()
        val valorUnitarioProduto = binding.editValorUnicoProduto.text.toString()
        val receitaProduto = binding.editReceita.text.toString()

        try {
            if (nomeProduto.isNotEmpty() && quantidadeProduto.isNotEmpty() && valorUnitarioProduto.isNotEmpty() && receitaProduto.isNotEmpty()) {
                return Produto(
                    nomeProduto,
                    quantidadeProduto.toInt(),
                    valorUnitarioProduto.toDouble(),
                    receitaProduto
                )
            }
        } catch (e: Exception) {
            binding.editReceita.error = "Campo Obrigatório"
        }
        return null
    }

    private fun adicionarProdutoItem() {
        val novaListaProduto = mutableListOf<Produto>()
        val produto = recuperarDadosEditText()
        if (produto != null) {
            novaListaProduto.add(produto)
        }
        produtoAdapter.atualizarListaProduto(novaListaProduto)
    }
}