package com.example.nexoapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexoapp.roomDB.Cliente
import kotlinx.coroutines.launch

class ClienteViewModel(private val repository: Repository): ViewModel() {
    //fun validarCliente(cpfEmail: String) = repository.validarCliente(cpfEmail))

    fun upsertCliente(cliente: Cliente) {
        viewModelScope.launch {
            repository.upsertCliente(cliente)
        }
    }

    fun deleteCliente(cliente: Cliente) {
        viewModelScope.launch {
            repository.deleteCliente(cliente)
        }
    }
}