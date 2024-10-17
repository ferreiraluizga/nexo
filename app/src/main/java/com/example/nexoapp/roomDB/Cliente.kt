package com.example.nexoapp.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cliente(
    val nome: String,
    val telefone: String,
    val cpf_email: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
