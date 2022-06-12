package br.com.zup.desafioandroidcore.Fragments.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.desafioandroidcore.Model.Produto
import br.com.zup.desafioandroidcore.databinding.ProdutoItemBinding

class ProdutoAdapter(private var listaProduto: MutableList<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.exibirInformacaoesNaTextView(produto)
    }

    override fun getItemCount(): Int {
        return listaProduto.size
    }

    class ViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirInformacaoesNaTextView(produto: Produto) {
            binding.txtMostrarNome.text = produto.getNomeProduto()
            binding.txtMostrarQuantidade.text = produto.quantidadeProduto().toString()
            binding.txtMostrarReceita.text = produto.getReceita()
        }
    }
    fun atualizarListaProduto(novaListaProduto: MutableList<Produto>) {
        if (listaProduto.size == 0) {
            listaProduto = novaListaProduto
        }
        else {
            listaProduto.addAll(novaListaProduto)
        }
        notifyDataSetChanged()
    }
}