package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.databinding.ListaDeProdutosBinding

class ListaDeProdutos : AppCompatActivity() {

    private lateinit var binding: ListaDeProdutosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListaDeProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lisView = binding.listView
        val produto = Produto("10", "Kaiser", "Bebida Alcoolica", 10)
        val listaProdutos = mutableSetOf<Produto>()
        listaProdutos.add(produto)
        val nomes = ArrayList<String>()
        nomes.add("Jose")
        nomes.add("Maria")
        nomes.add("Ronaldo")
        nomes.add("Carlos")


        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, nomes)
        lisView.adapter = arrayAdapter

        binding.voltar.setOnClickListener {
            // Faz algo e volta para a tela de Menu.
            val menu = Intent(this, Menu::class.java)
            startActivity(menu)
        }

    }
}