package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bancoProduto: BancoProduto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bancoProduto = BancoProduto(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.entrar.setOnClickListener {
            var login = binding.userLogin.text.toString() // pegadndo o texto e transformando em string.
            var senha = binding.userPass.text.toString()


            if(login.isNotEmpty() && senha.isNotEmpty()){
                if(login.equals("admin") && senha.equals("admin")){
                    Toast.makeText(this, "Login efetuado com sucesso.", Toast.LENGTH_LONG).show()
                    val menu = Intent(this, Menu::class.java)
                    startActivity(menu)
                }else{
                    Toast.makeText(this,"Usuario ou senha incorretos.", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_LONG).show()
            }
        }

        binding.esqueciSenha.setOnClickListener {
            val esquceuSenha = Intent(this, AlterarSenha::class.java)
            startActivity(esquceuSenha)
        }
    }
}