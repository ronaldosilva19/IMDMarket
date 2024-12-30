package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.databinding.DeletarProdutoBinding

class DeletarProduto : AppCompatActivity() {

    private lateinit var binding: DeletarProdutoBinding
    private lateinit var bancoProduto: BancoProduto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DeletarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bancoProduto = BancoProduto(this)

        binding.deletar.setOnClickListener {
            var codigoProduto = binding.codigoProduto.text.toString()

            if(codigoProduto.isNotEmpty()){
                // Faz algo e volta para a tela de Menu.
                if(bancoProduto.deletarProduto(codigoProduto.toLong()) == 0) {
                    Toast.makeText(this, "Produto deletado com sucesso.", Toast.LENGTH_LONG).show()
                    val menu = Intent(this, Menu::class.java)
                    startActivity(menu)
                }else if(bancoProduto.deletarProduto(codigoProduto.toLong()) == 1){
                    Toast.makeText(this, "Produto com codigo informado nao foi cadastrado.", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Preencha o campo solicitado.", Toast.LENGTH_LONG).show()

            }
        }

        binding.limpar.setOnClickListener {
            binding.codigoProduto.setText("")
        }
    }
}