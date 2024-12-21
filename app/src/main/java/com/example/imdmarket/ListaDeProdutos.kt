package com.example.imdmarket

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

import com.example.imdmarket.databinding.ListaDeProdutosBinding

class ListaDeProdutos : AppCompatActivity() {

    private lateinit var binding: ListaDeProdutosBinding
    private lateinit var bancoProduto: BancoProduto
    private lateinit var adapter: ArrayAdapter<Produto>
    private lateinit var produtos: ArrayList<Produto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListaDeProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bancoProduto = BancoProduto(this)
        produtos = bancoProduto.listarProdutos()
        adapter = ArrayAdapter(this, R.layout.simple_list_item_1, produtos)
        binding.listView.adapter = adapter

        binding.voltar.setOnClickListener {
            val menu = Intent(this, Menu::class.java)
            startActivity(menu)
        }

    }

}