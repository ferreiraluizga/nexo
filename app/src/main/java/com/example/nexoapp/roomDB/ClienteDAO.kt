package com.example.nexoapp.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ClienteDAO {
    @Upsert
    suspend fun upsertCliente(cliente: Cliente)

    @Delete
    suspend fun deleteCliente(cliente: Cliente)

    @Query("SELECT * FROM Cliente WHERE cpf_email = :cpfEmail")
    fun validarCliente(cpfEmail: String): Cliente
}

