package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class k {
    @Deprecated
    public static boolean a(HttpsURLConnection httpsURLConnection) {
        AppMethodBeat.i(234886);
        TrustManager[] trustManagerArr = {new X509TrustManager() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.e.k.AnonymousClass1 */

            @Override // javax.net.ssl.X509TrustManager
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                AppMethodBeat.i(234883);
                h.log(3, "SSLUtil", "checkClientTrusted");
                AppMethodBeat.o(234883);
            }

            @Override // javax.net.ssl.X509TrustManager
            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                AppMethodBeat.i(234884);
                if (a.bJK().cWq) {
                    for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
                        X509Certificate x509Certificate = x509CertificateArr[i2];
                        h.log(3, "SSLUtil", " Server certificate " + (i2 + 1) + ":");
                        h.log(3, "SSLUtil", "  Subject DN: " + x509Certificate.getSubjectX500Principal());
                        h.log(3, "SSLUtil", "  Issuer DN: " + x509Certificate.getIssuerX500Principal());
                        h.log(3, "SSLUtil", "  Signature Algorithm: " + x509Certificate.getSigAlgName());
                        h.log(3, "SSLUtil", "  Valid from: " + x509Certificate.getNotBefore());
                        h.log(3, "SSLUtil", "  Valid until: " + x509Certificate.getNotAfter());
                        h.log(3, "SSLUtil", "  Serial #: " + x509Certificate.getSerialNumber().toString(16));
                    }
                }
                AppMethodBeat.o(234884);
            }

            public final X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
        try {
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.e.k.AnonymousClass2 */

                public final boolean verify(String str, SSLSession sSLSession) {
                    AppMethodBeat.i(234885);
                    h.log(3, "SSLUtil", "verifying ".concat(String.valueOf(str)));
                    AppMethodBeat.o(234885);
                    return true;
                }
            });
            AppMethodBeat.o(234886);
            return true;
        } catch (Exception e2) {
            h.log(6, "SSLUtil", "disableSSLCertVerify failed ".concat(String.valueOf(e2)));
            AppMethodBeat.o(234886);
            return false;
        }
    }
}
