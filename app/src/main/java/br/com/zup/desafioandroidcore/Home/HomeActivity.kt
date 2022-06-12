package br.com.zup.desafioandroidcore.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding
    }
}