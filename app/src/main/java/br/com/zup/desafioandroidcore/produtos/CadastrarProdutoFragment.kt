package br.com.zup.desafioandroidcore.produtos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.desafioandroidcore.model.Produto
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.databinding.FragmentProdutoCadastrarBinding
import java.lang.Exception

class CadastrarProdutoFragment : Fragment() {
    private lateinit var binding: FragmentProdutoCadastrarBinding
    private val produtos = mutableListOf<Produto>()

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
        binding.btnMostrarProdutos.setOnClickListener {
            val bundle = bundleOf("PRODUTOS" to produtos)
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_produtoCadastrar3_to_produtosCadastrados2,bundle)
        }

    }

    private fun limparCampos() {
        binding.editTextNomeCadastroProduto.text.clear()
        binding.editQuantidadeProduto.text.clear()
        binding.editValorUnicoProduto.text.clear()
        binding.editReceita.text.clear()
    }

    private fun recuperarDadosEditText(): Produto? {
        val nomeProduto = binding.editTextNomeCadastroProduto.text.toString()
        val quantidadeProduto = binding.editQuantidadeProduto.text.toString()
        val valorUnitarioProduto = binding.editValorUnicoProduto.text.toString()
        val receitaProduto = binding.editReceita.text.toString()
        if (nomeProduto.isNotEmpty() && quantidadeProduto.isNotEmpty() && valorUnitarioProduto.isNotEmpty() && receitaProduto.isNotEmpty()) {
            return Produto(
                nomeProduto,
                quantidadeProduto.toDouble(),
                valorUnitarioProduto.toDouble(),
                receitaProduto
            )
        }
        else {
            binding.editTextNomeCadastroProduto.error = "O nome ?? um campo obrigat??rio"
            binding.editQuantidadeProduto.error = "A quantidade ?? um campo obrigat??rio"
            binding.editValorUnicoProduto.error = "O valor ??nico ?? um campo obrigat??rio"
            binding.editReceita.error = "A receita ?? um campo obrigat??rio"
        }
        return null
    }

    private fun adicionarProdutoItem() {
        val produto = recuperarDadosEditText()
        if (produto != null) {
            produtos.add(produto)
            Toast.makeText(context, "Produto cadastrado com sucesso!", Toast.LENGTH_LONG).show()
            limparCampos()
        }
    }
}