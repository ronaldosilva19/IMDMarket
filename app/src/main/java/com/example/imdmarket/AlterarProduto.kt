package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.databinding.ActivityMainBinding
import com.example.imdmarket.databinding.AlterarProdutoBinding

class AlterarProduto : AppCompatActivity() {

    private lateinit var binding: AlterarProdutoBinding
    private lateinit var bancoProduto: BancoProduto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AlterarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bancoProduto = BancoProduto(this)


        binding.alterar.setOnClickListener {
            var codigoProduto = binding.alteraCodigo.text.toString()
            var nomeProduto = binding.nomeProduto.text.toString()
            var descricaoProduto = binding.descricaoProduto.text.toString()
            var estoqueProduto = binding.estoqueProduto.text.toString()

            if(codigoProduto.isNotEmpty() && nomeProduto.isNotEmpty() && descricaoProduto.isNotEmpty() && estoqueProduto.isNotEmpty()){
                // Faz algo e volta para a tela de Menu.
                bancoProduto.atualizarProduto(codigoProduto.toLong(), nomeProduto, descricaoProduto, estoqueProduto.toInt())
                Toast.makeText(this, "Produto com codigo $codigoProduto alterado com sucesso.", Toast.LENGTH_LONG).show()
                val menu = Intent(this, Menu::class.java)
                startActivity(menu)
            }else{
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_LONG).show()
            }
        }

        // Caso queira limpar todos campos, só clicar no botão de 'limpar'.
        binding.limpar.setOnClickListener {
            binding.alteraCodigo.setText("")
            binding.nomeProduto.setText("")
            binding.descricaoProduto.setText("")
            binding.estoqueProduto.setText("")
        }
    }
}