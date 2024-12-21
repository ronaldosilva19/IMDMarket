package com.example.imdmarket

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoProduto(contexto : Context) : SQLiteOpenHelper(contexto, NOME, null, VERSAO){

    companion object{
        private const val NOME = "dbproduto"
        private const val VERSAO = 1
        private const val TABLE_NAME = "produtos"
        private const val COLUMM_ID = "codigo"
        private const val COLUMM_NAME = "nome"
        private const val COLUMM_DESCRICAO = "descricao"
        private const val COLUMM_ESTOQUE = "estoque"
    }

    override fun onCreate(db: SQLiteDatabase) {
            val criaTabela =
                """
            CREATE TABLE $TABLE_NAME(
                $COLUMM_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMM_NAME TEXT,
                $COLUMM_DESCRICAO TEXT,
                $COLUMM_ESTOQUE INT NOT NULL
            )
            """.trimIndent()
        db.execSQL(criaTabela)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun salvarProduto(codigo : Long, nome: String, descricao: String, estoque: Int){
        val bancoProduto = writableDatabase
        val container = ContentValues().apply{
            put("codigo", codigo)
            put("nome", nome)
            put("descricao", descricao)
            put("estoque", estoque)
        }
        bancoProduto.insert("produtos", null, container)
        bancoProduto.close()

    }

    fun atualizarProduto(codigo: Long, nome: String, descricao: String, estoque: Int): Int{
        val bancoProduto = writableDatabase
        val container = ContentValues().apply{
            put("codigo", codigo)
            put("nome", nome)
            put("descricao", descricao)
            put("estoque", estoque)
        }
        val resultado = bancoProduto.update("produtos", container, "codigo=$codigo", null)
        bancoProduto.close()
        return resultado
    }

    fun deletarProduto(codigo: Long): Int{
        val bancoProduto = this.writableDatabase
        val resultado = bancoProduto.delete("produtos", "codigo=$codigo", null)
        bancoProduto.close()
        return resultado
    }

    fun listarProdutos() : ArrayList<Produto>{
        val bancoProduto = this.readableDatabase
        val cursor = bancoProduto.rawQuery("SELECT * FROM produtos", null)
        var array = ArrayList<Produto>()
        if(cursor.count > 0){
            cursor.moveToFirst()
            do {
                var codigoProduto = cursor.getInt(0)
                var nomeProduto = cursor.getString(1)
                var descricaoProduto = cursor.getString(2)
                var estoqueProduto = cursor.getInt(3)
                array.add(Produto(codigoProduto, nomeProduto, descricaoProduto, estoqueProduto))
            }while(cursor.moveToNext())
        }
        cursor.close()
        bancoProduto.close()
        return array
    }

}