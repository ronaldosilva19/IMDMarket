package com.example.imdmarket

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoProduto(contexto : Context) : SQLiteOpenHelper(contexto, NOME, null, VERSAO){

    companion object{
        private const val NOME = "dbproduto"
        private const val VERSAO = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(
                """
            CREATE TABLE produtos(
                codido INTEGER PRIMARY KEY,
                nome TEXT,
                descricao TEXT,
                estoque INT NOT NULL
            )
            """
            )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun salvarProduto(codigo : Long, nome: String, descricao: String, estoque: Int){
        val bancoProduto = this.writableDatabase
        val container = ContentValues()
        container.put("codigo", codigo)
        container.put("nome", nome)
        container.put("descricao", descricao)
        container.put("estoque", estoque)
        bancoProduto.insert("produtos", null, container)
        bancoProduto.close()
    }

    fun atualizarProduto(codigo: Long, nome: String, descricao: String, estoque: Int){
        val bancoProduto = this.writableDatabase
        val container = ContentValues()
        container.put("codigo", codigo)
        container.put("nome", nome)
        container.put("descricao", descricao)
        container.put("estoque", estoque)
        bancoProduto.update("produtos", container, "codigo=$codigo", null)
        bancoProduto.close()
    }

    fun deletarProduto(codigo: Long){
        val bancoProduto = this.writableDatabase
        bancoProduto.delete("produtos", "codigo=$codigo", null)
        bancoProduto.close()
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