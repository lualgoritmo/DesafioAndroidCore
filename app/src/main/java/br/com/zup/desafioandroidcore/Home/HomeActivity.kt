package br.com.zup.desafioandroidcore.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.zup.desafioandroidcore.R
import br.com.zup.desafioandroidcore.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        val navHostFra = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val nav: NavController = navHostFra.navController
        NavigationUI.setupActionBarWithNavController(this, nav)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}