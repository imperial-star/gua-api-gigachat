/*
 * A Java library for the GigaChat API for Android
 *
 * The code is distributed under the GNU GPL v.2 license.
 * You can see a copy of the license in the root library folder.
 *
 * Copyright Gleb Obitotsky 2026 <oximif174@gmail.com>
 */

package api.ggroup.sber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import api.ggroup.sber.ui.theme.GigachatapiTheme

import gr3mp.giga.sber.auth.AccessToken
import api.ggroup.sber.BuildVars.client_id
import api.ggroup.sber.BuildVars.client_secret

import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GigachatapiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GigaChatScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GigaChatScreen(modifier: Modifier = Modifier) {
    var resultText by remember { mutableStateOf("testToken") }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = resultText,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                isLoading = true
                resultText = "..."

                AccessToken.getAccessToken(
                    client_id,
                    client_secret,
                    "GIGACHAT_API_PERS",
                    object : Callback {
                        override fun onFailure(call: Call, e: IOException) {
                            resultText = "error net: ${e.message}"
                            isLoading = false
                        }

                        override fun onResponse(call: Call, response: Response) {
                            val body = response.body?.string() ?: "-"

                            resultText = if (response.isSuccessful) {
                                "Token :\n$body"
                            } else {
                                "Error server (${response.code}): $body"
                            }
                            isLoading = false
                        }
                    }
                )
            },
            enabled = !isLoading
        ) {
            Text(if (isLoading) "..." else "Token")
        }
    }
}