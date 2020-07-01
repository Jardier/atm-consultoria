package com.android.atm.consultoria

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)

        //Ação de envio de email
        fab.setOnClickListener { view ->
           this.enviarEmail()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        //Configuração dos menus
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
            R.id.nav_contato, R.id.nav_sobre
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun enviarEmail() {
       // val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:85996218413"));
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("atendimento@atmconsultoria.com.br"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contatos feito pelo APP");
        intent.putExtra(Intent.EXTRA_TEXT,"Menssagem Automática");

        //tipo email
        intent.setType("message/rfc822");
//         intent.setType("text/plain");
//        intent.setType("application/pdf")
        //Lista os tipos de app que podem ser utilizados
       startActivity(Intent.createChooser(intent, "Escolha um App"));


    }
}
