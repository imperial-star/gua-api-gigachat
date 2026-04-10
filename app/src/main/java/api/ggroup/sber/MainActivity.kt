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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import api.ggroup.sber.ui.theme.GigachatapiTheme

import gr3mp.giga.sber.auth.AccessToken

import api.ggroup.sber.BuildVars.client_id
import api.ggroup.sber.BuildVars.client_secret

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GigachatapiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    /*
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
     */
}
