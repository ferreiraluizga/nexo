package com.example.nexoclub

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nexoclub.roomDB.Cliente
import com.example.nexoclub.viewModel.ClienteViewModel

@Composable
fun ProfileScreen(id_cli: Int, viewModel: ClienteViewModel) {
    // Estado para armazenar o cliente
    val clienteState = remember { mutableStateOf<Cliente?>(null) }

    // Efeito colateral para buscar o cliente
    LaunchedEffect(id_cli) {
        viewModel.buscarPorId(id_cli) { cliente ->
            clienteState.value = cliente
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Usuário",
                    modifier = Modifier.size(64.dp)
                )

                clienteState.value?.let { cliente ->
                    Text(text = "Id: ${cliente.id}")
                    Text(text = "Nome: ${cliente.nome}")
                    Text(text = "Telefone: ${cliente.telefone}")
                    Text(text = "CPF ou E-Mail: ${cliente.cpfEmail}")
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /* Ação para editar */ }) {
                Text(text = "Editar")
            }
            Button(onClick = { /* Ação para excluir */ }) {
                Text(text = "Excluir")
            }
        }
    }
}