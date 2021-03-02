package com.tencent.mm.plugin.mobile.verify.b;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mobile.verify.PluginMobileVerify;
import com.tencent.mm.plugin.mobile.verify.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.HttpURLConnection;
import java.net.URL;

public final class b extends a {
    private int iMt = 0;
    private String url;
    private a.AbstractC1483a zEG;
    private Network zEH;
    private ConnectivityManager.NetworkCallback zEI = new ConnectivityManager.NetworkCallback() {
        /* class com.tencent.mm.plugin.mobile.verify.b.b.AnonymousClass1 */

        public final void onAvailable(Network network) {
            AppMethodBeat.i(224129);
            super.onAvailable(network);
            Log.i("MicroMsg.GetMobileToken", "network %s is available", ((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(network).getTypeName());
            b.this.zEH = network;
            b.a(b.this);
            h.INSTANCE.dN(1360, 7);
            AppMethodBeat.o(224129);
        }

        public final void onUnavailable() {
            AppMethodBeat.i(224130);
            super.onUnavailable();
            Log.i("MicroMsg.GetMobileToken", "network %s is unavailable", ((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(b.this.zEH).getTypeName());
            b.this.zEH = null;
            h.INSTANCE.dN(1360, 6);
            AppMethodBeat.o(224130);
        }
    };

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(224140);
        bVar.elh();
        AppMethodBeat.o(224140);
    }

    public b(String str, String str2) {
        super(str);
        AppMethodBeat.i(224131);
        this.url = str2;
        this.zEG = ((PluginMobileVerify) g.ah(PluginMobileVerify.class)).getCallback(str);
        AppMethodBeat.o(224131);
    }

    @Override // com.tencent.mm.plugin.mobile.verify.b.a
    public final void run() {
        AppMethodBeat.i(224132);
        try {
            h.INSTANCE.dN(1360, 0);
            if (Util.isNullOrNil(q.getSimCountryIso()) || !NetStatusUtil.isMobileNetworkOpen(MMApplicationContext.getContext())) {
                if (Util.isNullOrNil(q.getSimCountryIso())) {
                    h.INSTANCE.dN(1360, 1);
                } else if (!NetStatusUtil.isMobileNetworkOpen(MMApplicationContext.getContext())) {
                    h.INSTANCE.dN(1360, 3);
                }
                Log.w("MicroMsg.GetMobileToken", "get mobile token failed, mobile network is not open");
                aFq(null);
                AppMethodBeat.o(224132);
                return;
            }
            elj();
            AppMethodBeat.o(224132);
        } catch (Exception e2) {
            Log.e("MicroMsg.GetMobileToken", "http exception:%s", e2.getMessage());
            aFq(null);
            AppMethodBeat.o(224132);
        }
    }

    private void aFq(String str) {
        AppMethodBeat.i(224133);
        Log.i("MicroMsg.GetMobileToken", "callback %s", str);
        if (!Util.isNullOrNil(str)) {
            h.INSTANCE.dN(1360, 8);
        } else {
            h.INSTANCE.dN(1360, 9);
        }
        if (this.zEG != null) {
            Bundle bundle = new Bundle();
            bundle.putString("session", this.sessionId);
            bundle.putString("token", str);
            this.zEG.F(bundle);
            this.zEG = null;
        }
        AppMethodBeat.o(224133);
    }

    private void elg() {
        AppMethodBeat.i(224134);
        try {
            Log.i("MicroMsg.GetMobileToken", "use mobile network directly");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();
            e(httpURLConnection);
            AppMethodBeat.o(224134);
        } catch (Exception e2) {
            Log.e("MicroMsg.GetMobileToken", "http exception:%s", e2.getMessage());
            aFq(null);
            AppMethodBeat.o(224134);
        }
    }

    private void elh() {
        AppMethodBeat.i(224135);
        try {
            Log.i("MicroMsg.GetMobileToken", "select mobile network");
            HttpURLConnection httpURLConnection = (HttpURLConnection) this.zEH.openConnection(new URL(this.url));
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();
            e(httpURLConnection);
            AppMethodBeat.o(224135);
        } catch (Exception e2) {
            Log.e("MicroMsg.GetMobileToken", "http exception:%s", e2.getMessage());
            aFq(null);
            AppMethodBeat.o(224135);
        }
    }

    private void eli() {
        AppMethodBeat.i(224136);
        h.INSTANCE.dN(1360, 5);
        Log.i("MicroMsg.GetMobileToken", "request mobile network");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12);
        builder.addTransportType(0);
        ((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).requestNetwork(builder.build(), this.zEI);
        AppMethodBeat.o(224136);
    }

    private void elj() {
        AppMethodBeat.i(224137);
        if (NetStatusUtil.isMobile(MMApplicationContext.getContext())) {
            h.INSTANCE.dN(1360, 2);
            elg();
            AppMethodBeat.o(224137);
        } else if (this.zEH == null) {
            eli();
            AppMethodBeat.o(224137);
        } else {
            elh();
            AppMethodBeat.o(224137);
        }
    }

    private void e(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(224138);
        int responseCode = httpURLConnection.getResponseCode();
        Log.i("MicroMsg.GetMobileToken", "httpCode %d, message %s, redirectCount %d", Integer.valueOf(responseCode), httpURLConnection.getResponseMessage(), Integer.valueOf(this.iMt));
        switch (responseCode) {
            case 200:
                aFq(f(httpURLConnection));
                AppMethodBeat.o(224138);
                return;
            case 302:
                if (this.iMt >= 2) {
                    Log.i("MicroMsg.GetMobileToken", "redirect exceed %d times", 2);
                    aFq("");
                    break;
                } else {
                    this.iMt++;
                    this.url = httpURLConnection.getHeaderField(FirebaseAnalytics.b.LOCATION);
                    Log.i("MicroMsg.GetMobileToken", "redirect to url: %s", this.url);
                    elj();
                    AppMethodBeat.o(224138);
                    return;
                }
        }
        AppMethodBeat.o(224138);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[SYNTHETIC, Splitter:B:12:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[Catch:{ IOException -> 0x0035 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String f(java.net.HttpURLConnection r8) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mobile.verify.b.b.f(java.net.HttpURLConnection):java.lang.String");
    }
}
