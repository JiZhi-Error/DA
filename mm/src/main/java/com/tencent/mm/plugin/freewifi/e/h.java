package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.HttpURLConnection;

public final class h extends e implements a {
    private String wPJ = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    private int wPK = 0;

    static /* synthetic */ void a(h hVar, int i2, String str) {
        AppMethodBeat.i(24902);
        hVar.bt(i2, str);
        AppMethodBeat.o(24902);
    }

    public h(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.i(24899);
        Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.wPJ);
        AppMethodBeat.o(24899);
    }

    @Override // com.tencent.mm.plugin.freewifi.e.a
    public final void connect() {
        AppMethodBeat.i(24900);
        Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.wPJ);
        final String str = this.wPJ;
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.e.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(24896);
                Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)), str);
                a.dMN();
                a.a(str, new a.AbstractC1369a() {
                    /* class com.tencent.mm.plugin.freewifi.e.h.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void d(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(24894);
                        int responseCode = httpURLConnection.getResponseCode();
                        Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)), Integer.valueOf(responseCode));
                        if (responseCode == 200) {
                            h.a(h.this, 0, "");
                            m.a(h.this.intent, h.this.dFd, h.this.wPz, h.this.channelId, h.this.wPy, "MicroMsg.FreeWifi.ProtocolThreeOne");
                            AppMethodBeat.o(24894);
                        } else if (responseCode == 302) {
                            h.a(h.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(24894);
                        } else {
                            Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.wPy;
                            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.wRo = m.a(h.this.wPz, k.b.ThreeOneAuth, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            h.a(h.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(24894);
                        }
                    }

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void o(Exception exc) {
                        AppMethodBeat.i(24895);
                        Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)), exc.getMessage(), m.m(exc));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.wPy;
                        FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                        aVar.wRo = m.a(h.this.wPz, k.b.ThreeOneAuth, m.n(exc));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        h.a(h.this, m.n(exc), m.l(exc));
                        AppMethodBeat.o(24895);
                    }
                });
                AppMethodBeat.o(24896);
            }
        });
        AppMethodBeat.o(24900);
    }

    private void bt(int i2, String str) {
        AppMethodBeat.i(24901);
        k.a dMF = k.dMF();
        dMF.ssid = this.ssid;
        dMF.bssid = m.axN("MicroMsg.FreeWifi.ProtocolThreeOne");
        dMF.dFe = m.axO("MicroMsg.FreeWifi.ProtocolThreeOne");
        dMF.dFd = this.dFd;
        dMF.wNb = this.appId;
        dMF.quX = m.aw(this.intent);
        dMF.wNc = 31;
        dMF.wNd = k.b.ThreeOneAuth.wNO;
        dMF.wNe = k.b.ThreeOneAuth.name;
        dMF.result = i2;
        dMF.resultMsg = str;
        dMF.channel = m.az(this.intent);
        dMF.dMH().c(this.intent, i2 != 0).dMG();
        AppMethodBeat.o(24901);
    }

    static /* synthetic */ void a(h hVar, String str) {
        AppMethodBeat.i(24903);
        hVar.wPK++;
        if (hVar.wPK > 3) {
            Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.aw(hVar.intent), Integer.valueOf(m.ax(hVar.intent)));
            FreeWifiFrontPageUI freeWifiFrontPageUI = hVar.wPy;
            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.wRo = m.a(hVar.wPz, k.b.ThreeOneAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.bt(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.o(24903);
            return;
        }
        Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.aw(hVar.intent), Integer.valueOf(m.ax(hVar.intent)), str);
        if (m.eP(str)) {
            FreeWifiFrontPageUI freeWifiFrontPageUI2 = hVar.wPy;
            FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.FAIL;
            FreeWifiFrontPageUI.a aVar2 = new FreeWifiFrontPageUI.a();
            aVar2.wRo = m.a(hVar.wPz, k.b.ThreeOneAuth, 34);
            freeWifiFrontPageUI2.a(dVar2, aVar2);
            hVar.bt(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.o(24903);
            return;
        }
        AnonymousClass2 r0 = new a.AbstractC1369a() {
            /* class com.tencent.mm.plugin.freewifi.e.h.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void d(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(24897);
                int responseCode = httpURLConnection.getResponseCode();
                Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    h.a(h.this, 0, "");
                    m.a(h.this.intent, h.this.dFd, h.this.wPz, h.this.channelId, h.this.wPy, "MicroMsg.FreeWifi.ProtocolThreeOne");
                    AppMethodBeat.o(24897);
                } else if (responseCode == 302) {
                    h.a(h.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(24897);
                } else {
                    Log.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.wPy;
                    FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.wRo = m.a(h.this.wPz, k.b.ThreeOneAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    h.a(h.this, 32, "INVALID_HTTP_RESP_CODE");
                    AppMethodBeat.o(24897);
                }
            }

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void o(Exception exc) {
                AppMethodBeat.i(24898);
                Log.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.aw(h.this.intent), Integer.valueOf(m.ax(h.this.intent)), exc.getMessage(), m.m(exc));
                FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.wPy;
                FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.wRo = m.a(h.this.wPz, k.b.ThreeOneAuth, m.n(exc));
                freeWifiFrontPageUI.a(dVar, aVar);
                h.a(h.this, m.n(exc), m.l(exc));
                AppMethodBeat.o(24898);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            a.dMN();
            a.a(str, parse.getEncodedQuery(), r0);
            AppMethodBeat.o(24903);
            return;
        }
        a.dMN();
        a.a(str, r0);
        AppMethodBeat.o(24903);
    }
}
