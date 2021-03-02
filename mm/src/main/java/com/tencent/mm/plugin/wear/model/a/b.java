package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public interface b {
    byte[] a(Asset asset);

    void fVZ();

    GoogleApiClient fWa();

    HashSet<String> fWb();

    boolean fWc();

    void fWd();

    void finish();

    boolean isAvailable();

    boolean u(Uri uri);

    a w(String str, byte[] bArr);

    a x(String str, byte[] bArr);

    public static class a {
        public int code;
        public String errMsg;

        a() {
            this.code = 0;
        }

        a(byte b2) {
            this.code = 0;
            this.code = 131072;
        }
    }
}
