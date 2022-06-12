package br.com.zup.desafioandroidcore.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.databinding.ActivityHomeBinding

class fragmentHome : Fragment() {
    private lateinit var binding: fragmentHome

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cadastrar_produto, container, false)
    }
}