package com.tencent.luggage.game.b.a;

import android.text.TextUtils;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.game.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public final class b extends c<c.AbstractC0167c> {
    private int bbs = 60000;
    private int bbt = 60000;
    private c.AbstractC0167c cuI;
    private final String mUserAgent;

    public b(c.AbstractC0167c cVar) {
        super(cVar);
        AppMethodBeat.i(222869);
        this.cuI = cVar;
        int LS = cVar.LS();
        int LU = cVar.LU();
        if (LS > 0 && LU > 0) {
            this.bbs = LS;
            this.bbt = LU;
            Log.i("AppBrandImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", Integer.valueOf(LS), Integer.valueOf(LU));
        }
        this.mUserAgent = cVar.getUserAgentString();
        AppMethodBeat.o(222869);
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final boolean accept(Object obj) {
        AppMethodBeat.i(222870);
        if (!(obj instanceof String)) {
            AppMethodBeat.o(222870);
            return false;
        } else if (((String) obj).startsWith(HttpWrapperBase.PROTOCAL_HTTP) || ((String) obj).startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            AppMethodBeat.o(222870);
            return true;
        } else {
            AppMethodBeat.o(222870);
            return false;
        }
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final b.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        AppMethodBeat.i(222871);
        b.a aVar = new b.a();
        String a2 = this.cuI.a(imageDecodeConfig.mReferrerPolicy);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            int i2 = 0;
            String str = (String) obj;
            while (true) {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                if (imageDecodeConfig != null && !TextUtils.isEmpty(a2)) {
                    httpURLConnection2.addRequestProperty("Referer", a2);
                }
                httpURLConnection2.setRequestProperty("User-Agent", this.mUserAgent);
                httpURLConnection2.setReadTimeout(this.bbt);
                httpURLConnection2.setConnectTimeout(this.bbs);
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode == 301 || responseCode == 302) {
                    String headerField = httpURLConnection2.getHeaderField(FirebaseAnalytics.b.LOCATION);
                    Log.i("AppBrandImageHttpFetcher", "redirect from[%s] to[%s]", str, headerField);
                    httpURLConnection2.disconnect();
                    if (headerField == null) {
                        httpURLConnection = null;
                        break;
                    }
                    int i3 = i2 + 1;
                    if (i2 >= 3) {
                        Log.e("AppBrandImageHttpFetcher", "too much redirection!");
                        aVar.errorMsg = MMApplicationContext.getContext().getString(R.string.a15);
                        httpURLConnection = null;
                        break;
                    }
                    i2 = i3;
                    str = headerField;
                } else {
                    if (responseCode < 200 || responseCode >= 300) {
                        aVar.errorMsg = String.format(MMApplicationContext.getContext().getString(R.string.a13), Integer.valueOf(responseCode));
                    }
                    httpURLConnection = httpURLConnection2;
                }
            }
            if (httpURLConnection == null || !TextUtils.isEmpty(aVar.errorMsg)) {
                bufferedInputStream = null;
            } else {
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            }
            bufferedInputStream2 = bufferedInputStream;
        } catch (SocketTimeoutException e2) {
            Log.e("AppBrandImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", obj, Integer.valueOf(this.bbs), Integer.valueOf(this.bbt), e2.toString());
            aVar.errorMsg = MMApplicationContext.getContext().getString(R.string.a16);
        } catch (Exception e3) {
            Log.e("AppBrandImageHttpFetcher", "fetch error. path = [%s], error = [%s]", obj, e3.toString());
            aVar.errorMsg = String.format(MMApplicationContext.getContext().getString(R.string.a14), e3.toString());
        }
        aVar.inputStream = bufferedInputStream2;
        AppMethodBeat.o(222871);
        return aVar;
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final String sS() {
        return "http";
    }
}
