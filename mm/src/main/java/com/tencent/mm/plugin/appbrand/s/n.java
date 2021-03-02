package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class n implements X509TrustManager {
    private LinkedList<X509TrustManager> niV = new LinkedList<>();
    private LinkedList<X509TrustManager> niW = new LinkedList<>();
    private KeyStore niX;
    private final boolean niY;
    private List<String> niZ = null;
    private KeyStore nja = null;
    private X509Certificate[] njb;

    public n(boolean z) {
        AppMethodBeat.i(144434);
        this.niY = z;
        try {
            this.niX = KeyStore.getInstance(KeyStore.getDefaultType());
            this.niX.load(null, null);
            AppMethodBeat.o(144434);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e2, "Exception: Local KeyStore init failed", new Object[0]);
            AppMethodBeat.o(144434);
        }
    }

    public final void G(InputStream inputStream) {
        AppMethodBeat.i(144435);
        if (this.niX == null) {
            Log.e("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
            AppMethodBeat.o(144435);
            return;
        }
        try {
            try {
                Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
                inputStream.close();
                this.niX.setCertificateEntry(new StringBuilder().append(((X509Certificate) generateCertificate).getSubjectDN()).toString(), generateCertificate);
                AppMethodBeat.o(144435);
            } catch (Throwable th) {
                inputStream.close();
                AppMethodBeat.o(144435);
                throw th;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e2, "Exception: initLocalSelfSignedCertificate", new Object[0]);
            AppMethodBeat.o(144435);
        }
    }

    public final void init() {
        AppMethodBeat.i(144436);
        long nowMilliSecond = Util.nowMilliSecond();
        bPH();
        bPI();
        bPJ();
        Log.d("MicroMsg.AppBrandX509TrustManager", "init() cost[%dms]", Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
        AppMethodBeat.o(144436);
    }

    @Override // javax.net.ssl.X509TrustManager
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        AppMethodBeat.i(144437);
        CertificateException certificateException = new CertificateException("Client Certification not supported");
        AppMethodBeat.o(144437);
        throw certificateException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01a0, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1011, 3, 1, false);
        com.tencent.matrix.trace.core.AppMethodBeat.o(144438);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01f6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01f7, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", r1, "Exception: check user verify certificate", new java.lang.Object[0]);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0272, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1011, 10, 1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x02af, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1011, 3, 1, false);
        com.tencent.matrix.trace.core.AppMethodBeat.o(144438);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02d2, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1011, 10, 1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0310, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1011, 3, 1, false);
        com.tencent.matrix.trace.core.AppMethodBeat.o(144438);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0333, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1011, 10, 1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x03b4, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check success");
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1011, 3, 1, false);
        com.tencent.matrix.trace.core.AppMethodBeat.o(144438);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x03d7, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandX509TrustManager", "checkServerTrusted self check fail");
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1011, 10, 1, false);
        com.tencent.matrix.trace.core.AppMethodBeat.o(144438);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x03f8, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x040d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x040e, code lost:
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0414, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0415, code lost:
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0418, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0419, code lost:
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x041c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x041d, code lost:
        r9 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x03d7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x040d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:48:0x01d2] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0414 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:48:0x01d2] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0418 A[ExcHandler: NoSuchAlgorithmException (e java.security.NoSuchAlgorithmException), Splitter:B:48:0x01d2] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x041c A[ExcHandler: KeyStoreException (e java.security.KeyStoreException), Splitter:B:48:0x01d2] */
    @Override // javax.net.ssl.X509TrustManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkServerTrusted(java.security.cert.X509Certificate[] r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 1056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.n.checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String):void");
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.njb;
    }

    private void bPH() {
        AppMethodBeat.i(144439);
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            int i2 = 0;
            while (trustManagers != null && i2 < trustManagers.length) {
                this.niV.add((X509TrustManager) trustManagers[i2]);
                i2++;
            }
            AppMethodBeat.o(144439);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e2, "Exception: init SystemTrustManager", new Object[0]);
            AppMethodBeat.o(144439);
        }
    }

    private void bPI() {
        AppMethodBeat.i(144440);
        if (this.niX == null) {
            AppMethodBeat.o(144440);
            return;
        }
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(this.niX);
            TrustManager[] trustManagers = instance.getTrustManagers();
            int i2 = 0;
            while (trustManagers != null && i2 < trustManagers.length) {
                this.niW.add((X509TrustManager) trustManagers[i2]);
                i2++;
            }
            AppMethodBeat.o(144440);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", e2, "Exception: init LocalTrustManager", new Object[0]);
            AppMethodBeat.o(144440);
        }
    }

    private void bPJ() {
        AppMethodBeat.i(144441);
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<X509TrustManager> it = this.niV.iterator();
        while (it.hasNext()) {
            X509Certificate[] acceptedIssuers = it.next().getAcceptedIssuers();
            if (acceptedIssuers != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Iterator<X509TrustManager> it2 = this.niW.iterator();
        while (it2.hasNext()) {
            X509Certificate[] acceptedIssuers2 = it2.next().getAcceptedIssuers();
            if (acceptedIssuers2 != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers2));
            }
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        this.njb = new X509Certificate[arrayList.size()];
        this.njb = (X509Certificate[]) arrayList.toArray(this.njb);
        Log.i("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
        AppMethodBeat.o(144441);
    }
}
