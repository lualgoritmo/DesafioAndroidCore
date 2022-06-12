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
import java.lang.Exception

class FragmentoCadastrarProduto : Fragment() {

    private lateinit var binding: FragmentCadastrarProdutoBinding
    private lateinit var nomeProduto: String
    private lateinit var quantidadeProduto: String
    private lateinit var valorUnitarioProduto: String
    private lateinit var receitaProduto: String

    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_produtos_cadastrados, container, false)
        binding.btnCadastrarProduto.setOnClickListener {
            adicionarItemProduto()
            limparCamposProduto()
        }
    }

    private fun adicionarItemProduto() {
        try {
            if (nomeProduto != null && quantidadeProduto != null && valorUnitarioProduto != null && receitaProduto != null) {
                this.nomeProduto = binding.editTextNomeCadastroProduto.toString()
                this.quantidadeProduto = binding.editQuantidadeProduto.toString()
                this.valorUnitarioProduto = binding.editValorUnicoProduto.toString()
                this.receitaProduto = binding.editReceita.toString()

                val produto = Produto(
                    nomeProduto,
                    quantidadeProduto.toInt(),
                    valorUnitarioProduto.toDouble(),
                    receitaProduto
                )
                val intent = Intent()
                intent.putExtra("PRODUTO", produto)
                startActivity(intent)
            }
        } catch (e: Exception) {

        }
    }

    private fun limparCamposProduto() {
        binding.editTextNomeCadastroProduto.text.clear()
        binding.editQuantidadeProduto.text.clear()
        binding.editValorUnicoProduto.text.clear()
        binding.editReceita.text.clear()
    }
}
