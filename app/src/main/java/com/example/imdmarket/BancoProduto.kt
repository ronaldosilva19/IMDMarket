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

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun salvarProduto(codigo : Long, nome: String, descricao: String, estoque: Int): Int{
        val bancoProduto = writableDatabase
        val values = ContentValues().apply{
            put(COLUMM_ID, codigo)
            put(COLUMM_NAME, nome)
            put(COLUMM_DESCRICAO, descricao)
            put(COLUMM_ESTOQUE, estoque)
        }


        try {
            bancoProduto.insertOrThrow(TABLE_NAME, null, values)
            bancoProduto.close()
            return 0 // Inserido com sucesso.
        }catch (exception : Exception){
            return 1 // Ja cadastrado.
        }
    }

    fun atualizarProduto(codigo: Long, nome: String, descricao: String, estoque: Int): Int{
        if(buscarProdutoPorCodigo(codigo)) {
            val bancoProduto = writableDatabase
            val values = ContentValues().apply {
                put(COLUMM_ID, codigo)
                put(COLUMM_NAME, nome)
                put(COLUMM_DESCRICAO, descricao)
                put(COLUMM_ESTOQUE, estoque)
            }
            bancoProduto.update(TABLE_NAME, values, "$COLUMM_ID =?", arrayOf(codigo.toString()))
            bancoProduto.close()
            return 0 // atualizado com sucesso.
        }
        return 1 // produto com codigo nao cadastrado.
    }

    fun deletarProduto(codigo: Long): Int{
        if(buscarProdutoPorCodigo(codigo)){
            val bancoProduto = writableDatabase
            bancoProduto.delete(TABLE_NAME, "$COLUMM_ID = ?", arrayOf(codigo.toString()))
            bancoProduto.close()
            return 0 // removido com sucesso.
        }

        return 1 // Nao cadastrado.
    }

    fun listarProdutos() : ArrayList<Produto>{
        val bancoProduto = readableDatabase
        val cursor = bancoProduto.rawQuery("SELECT * FROM $TABLE_NAME", null)
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

    private fun buscarProdutoPorCodigo(codigo: Long): Boolean{
        val bancoProduto = readableDatabase
        val cursor = bancoProduto.rawQuery("SELECT COUNT(*) FROM $TABLE_NAME WHERE codigo = ?", arrayOf(codigo.toString()))

        var estaPresente = false
        cursor.use { pointer ->
            if(pointer.moveToFirst()){
                estaPresente = pointer.getInt(0) > 0
            }
        }
        return estaPresente
    }

}