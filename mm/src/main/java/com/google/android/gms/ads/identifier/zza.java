package com.google.android.gms.ads.identifier;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

final class zza extends Thread {
    private final /* synthetic */ Map zzl;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzl = map;
    }

    public final void run() {
        AppMethodBeat.i(53029);
        new zzc();
        Map map = this.zzl;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            buildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        String uri = buildUpon.build().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    new StringBuilder(String.valueOf(uri).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(uri);
                }
            } finally {
                httpURLConnection.disconnect();
                AppMethodBeat.o(53029);
            }
        } catch (IndexOutOfBoundsException e2) {
            String message = e2.getMessage();
            new StringBuilder(String.valueOf(uri).length() + 32 + String.valueOf(message).length()).append("Error while parsing ping URL: ").append(uri).append(". ").append(message);
            AppMethodBeat.o(53029);
        } catch (IOException | RuntimeException e3) {
            String message2 = e3.getMessage();
            new StringBuilder(String.valueOf(uri).length() + 27 + String.valueOf(message2).length()).append("Error while pinging URL: ").append(uri).append(". ").append(message2);
            AppMethodBeat.o(53029);
        }
    }
}
