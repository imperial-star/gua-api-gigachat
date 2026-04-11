/*
 * A Java library for the GigaChat API for Android
 *
 * The code is distributed under the GNU GPL v.2 license.
 * You can see a copy of the license in the root library folder.
 *
 * Copyright Gleb Obitotsky 2026 <oximif174@gmail.com>
 */

package gr3mp.giga.sber.auth;

import gr3mp.giga.sber.client.NetworkService;
import gr3mp.giga.sber.crypto.AuthorizationKey;
import okhttp3.Callback;
import okhttp3.Request;

public class Models {
    private static final String URL = "https://gigachat.devices.sberbank.ru/api/v1/models";
    public static void getModels(String accessToken, Callback callback) {
        Request request = new Request.Builder()
                .url(URL)
                .get()
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        NetworkService.getInstance().execute(request, callback);
    }
}
