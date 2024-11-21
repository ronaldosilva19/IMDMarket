package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdmarket.databinding.AlterarSenhaBinding

class AlterarSenha : AppCompatActivity() {

    private lateinit var binding: AlterarSenhaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AlterarSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.alteraSenha.setOnClickListener {
            val novoLogin = binding.novoLogin.text.toString()
            val novaSenha = binding.userPassAltera.text.toString()
            val confirmaNovaSenha = binding.userPassConfirma.text.toString()

            if(novoLogin.isNotEmpty() && novaSenha.isNotEmpty() && confirmaNovaSenha.isNotEmpty()){
                if(!novoLogin.equals("admin")){
                    Toast.makeText(this, "Usuario deve ser por padrao 'admin'.", Toast.LENGTH_LONG).show()
                }else {
                    if (!novaSenha.equals(confirmaNovaSenha)) {
                        Toast.makeText(
                            this,
                            "Senhas nao conferem. Verifique e tente novamente.", Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(this, "Senha alterada com sucesso", Toast.LENGTH_LONG)
                            .show()

                        val telaLogin = Intent(this, MainActivity::class.java)
                        startActivity(telaLogin)
                    }
                }
            }else{
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_LONG).show()
            }
        }
    }
}