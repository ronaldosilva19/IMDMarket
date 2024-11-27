package com.example.imdmarket

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

import com.example.imdmarket.databinding.ListaDeProdutosBinding

class ListaDeProdutos : AppCompatActivity() {

    private lateinit var binding: ListaDeProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListaDeProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var produtos = mutableListOf<Produto>()

        // Apenas para visualizacao de teste.
        var contador = 1
        while(contador <= 20){
            produtos.add(Produto("100", "SterBom", "Agua mineral para saciar a sede", 10))
            contador++
        }
        var arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, produtos)
        binding.listView.adapter = arrayAdapter

        binding.voltar.setOnClickListener {
            // Faz algo e volta para a tela de Menu.
            val menu = Intent(this, Menu::class.java)
            startActivity(menu)
        }

    }

}