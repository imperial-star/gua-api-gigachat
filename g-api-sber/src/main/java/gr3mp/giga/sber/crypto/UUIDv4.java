/*
 * A Java library for the GigaChat API for Android
 *
 * The code is distributed under the GNU GPL v.2 license.
 * You can see a copy of the license in the root library folder.
 *
 * Copyright of the library Gleb Obitotsky 2026 <oximif174@gmail.com>
 */

package gr3mp.giga.sber.crypto;

import androidx.annotation.NonNull;

import java.util.UUID;

public class UUIDv4 {
    @NonNull
    public static String RqUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
