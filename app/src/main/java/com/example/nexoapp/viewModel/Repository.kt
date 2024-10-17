package com.example.nexoapp.viewModel

import com.example.nexoapp.roomDB.Cliente
import com.example.nexoapp.roomDB.ClienteDatabase

class Repository(private val db: ClienteDatabase) {
    suspend fun upsertCliente(cliente: Cliente) {
        db.clienteDAO().upsertCliente(cliente)
    }

    suspend fun deleteCliente(cliente: Cliente) {
        db.clienteDAO().deleteCliente(cliente)
    }

    fun validarCliente(cpfEmail: String) = db.clienteDAO().validarCliente(cpfEmail)
}