/*
* This code is a Java library implementation for Android for the GigaChat neural network.
*
* The code is distributed under the GNU GPL v.2 license.
* You can see a copy of the license in the root library folder.
*
* Copyright of the library Gleb Obitotsky 2026 <oximif174@gmail.com>
*/

package gr3mp.giga.sber.crypto;

import android.util.Base64;
import androidx.annotation.NonNull;

import java.nio.charset.StandardCharsets;

public class AuthorizationKey {

    @NonNull
    public static String AuthorizationHeader(String Client_ID, String Client_Secret) {
        String credentials = Client_ID + ":" + Client_Secret;

        String encodedCredentials = Base64.encodeToString(
                credentials.getBytes(StandardCharsets.UTF_8),
                Base64.NO_WRAP);

        return "Basic " + encodedCredentials;
    }
}
