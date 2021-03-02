package com.tencent.smtt.export.external.interfaces;

import android.util.Pair;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.concurrent.Executor;

public interface IX5CoreNetwork {
    String getCanonicalUrl(String str);

    String getCoreExtraMessage();

    UrlRequest getX5UrlRequestProvider(String str, int i2, UrlRequest.Callback callback, Executor executor, boolean z, String str2, ArrayList<Pair<String, String>> arrayList, String str3, byte[] bArr, String str4, String str5);

    void resetSpdySession();

    void setPreConnect(String str, int i2);
}
