/*
 * A Java library for the GigaChat API for Android
 *
 * The code is distributed under the GNU GPL v.2 license.
 * You can see a copy of the license in the root library folder.
 *
 * Copyright Gleb Obitotsky 2026 <oximif174@gmail.com>
 */

package gr3mp.giga.sber.client;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class NetworkService {
    private static NetworkService instance;
    private final OkHttpClient client;

    private NetworkService() {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static synchronized NetworkService getInstance() {
        if (instance == null) {
            instance = new NetworkService();
        }
        return instance;
    }

    public void execute(Request request, Callback callback) {
        client.newCall(request).enqueue(callback);
    }
}
