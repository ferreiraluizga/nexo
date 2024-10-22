package com.example.nexoclub.roomDB

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

    @Query("SELECT * FROM Cliente WHERE cpfEmail = :cpfEmail LIMIT 1")
    suspend fun validarCliente(cpfEmail: String): Cliente?
}

