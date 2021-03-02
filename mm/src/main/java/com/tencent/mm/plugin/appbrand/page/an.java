package com.tencent.mm.plugin.appbrand.page;

import android.net.http.SslCertificate;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;

public class an {
    ac cwK;
    private n nst;
    volatile String nsu;

    public an(ac acVar) {
        this.cwK = acVar;
    }

    public void cW(String str) {
    }

    public final boolean a(SslCertificate sslCertificate) {
        boolean z;
        AppMethodBeat.i(135249);
        if (this.cwK.getRuntime() == null) {
            AppMethodBeat.o(135249);
            return false;
        }
        if (this.nst == null) {
            this.nst = j.b((a) this.cwK.getRuntime().av(a.class));
        }
        if (this.nst == null) {
            AppMethodBeat.o(135249);
            return false;
        }
        Log.d("Luggage.AppBrandWebViewClient", "subjectDN: ".concat(String.valueOf(sslCertificate.getIssuedTo().getDName())));
        try {
            Field declaredField = sslCertificate.getClass().getDeclaredField("mX509Certificate");
            declaredField.setAccessible(true);
            try {
                this.nst.checkServerTrusted(new X509Certificate[]{(X509Certificate) declaredField.get(sslCertificate)}, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
                z = true;
            } catch (Exception e2) {
                Log.e("Luggage.AppBrandWebViewClient", "Certificate check failed: ".concat(String.valueOf(e2)));
                z = false;
            }
        } catch (Exception e3) {
            Log.e("Luggage.AppBrandWebViewClient", "Certificate check failed: ", e3);
            z = false;
        }
        AppMethodBeat.o(135249);
        return z;
    }

    public final WebResourceResponse adS(String str) {
        WebResourceResponse webResourceResponse = null;
        AppMethodBeat.i(135250);
        if (str == null) {
            AppMethodBeat.o(135250);
        } else if (!this.cwK.isRunning()) {
            AppMethodBeat.o(135250);
        } else {
            String str2 = this.nsu;
            if (TextUtils.isEmpty(str2)) {
                Log.e("Luggage.AppBrandWebViewClient", "getAppResourceResponse with reqURL[%s], hostURL isEmpty", str);
                AppMethodBeat.o(135250);
            } else {
                if (str.startsWith(str2)) {
                    webResourceResponse = bg.e(this.cwK.getRuntime(), str.replaceFirst(str2, ""));
                    if (webResourceResponse == null) {
                        Log.e("Luggage.AppBrandWebViewClient", "getAppResourceResponse %s not found", str);
                        webResourceResponse = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                        if (Build.VERSION.SDK_INT >= 21) {
                            webResourceResponse.setStatusCodeAndReasonPhrase(404, "NotFound");
                        }
                    }
                } else if (URLUtil.isAboutUrl(str) || URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str) || URLUtil.isDataUrl(str)) {
                    AppMethodBeat.o(135250);
                } else {
                    i<ByteBuffer> iVar = new i<>();
                    this.cwK.getRuntime().getFileSystem().b(str, iVar);
                    if (iVar.value != null) {
                        webResourceResponse = new WebResourceResponse("", "", new com.tencent.luggage.h.a(iVar.value));
                    }
                }
                Log.i("Luggage.AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", str);
                AppMethodBeat.o(135250);
            }
        }
        return webResourceResponse;
    }
}
