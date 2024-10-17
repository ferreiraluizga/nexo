package com.example.nexoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nexoapp.ui.theme.backgroundLogin1
import com.example.nexoapp.ui.theme.backgroundLogin2
import com.example.nexoapp.ui.theme.buttonGreen

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    var cpfEmail by remember { mutableStateOf("") }

    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(backgroundLogin1, backgroundLogin2)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundBrush),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = 120.dp, horizontal = 28.dp)
                .fillMaxHeight()
        ) {
            // Logo NEXO (você pode substituir por Image caso tenha a logo)
            Image(painter = painterResource(R.drawable.nexo_logo), contentDescription = null)

            Spacer(modifier = Modifier.height(16.dp))

            // Texto "Fazer Login"
            Text(
                text = "Fazer Login",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Campo de texto para CPF/Email
            Text(text = "Digite seu CPF ou E-mail NEXOClub")
            TextField(
                value = cpfEmail,
                onValueChange = { cpfEmail = it },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão "Entrar"
            Button(
                onClick = { /* Ação do botão Entrar */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(buttonGreen)
                    .padding(8.dp)
                    .height(50.dp)
            ) {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = null, tint = Color.White)
                Text(text = "Entrar", color = Color.White, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
