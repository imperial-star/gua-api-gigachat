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
import gr3mp.giga.sber.crypto.UUIDv4;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Callback;

public class AccessToken {
    private static final String URL = "https://ngw.devices.sberbank.ru:9443/api/v2/oauth";

    public static void getAccessToken(String Client_ID, String Client_Secret, String Scope, Callback callback) {

        final String authKey = AuthorizationKey.AuthorizationHeader(Client_ID, Client_Secret);
        final String rquid = UUIDv4.RqUID();

        RequestBody formBody = new FormBody.Builder()
                .add("scope", Scope)
                .build();

        Request request = new Request.Builder()
                .url(URL)
                .post(formBody)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "application/json")
                .addHeader("RqUID", rquid)
                .addHeader("Authorization", authKey)
                .build();

        NetworkService.getInstance().execute(request, callback);
    }
}
