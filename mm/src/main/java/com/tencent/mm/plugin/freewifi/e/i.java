package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.HttpURLConnection;

public final class i extends e implements a {
    protected String dmc;
    protected String extend;
    protected String sign;
    private int wPK = 0;
    protected String wPN;
    protected String wPO;
    private Uri wPP = Uri.parse(this.wPQ);
    private String wPQ = this.intent.getStringExtra("free_wifi_schema_uri");

    public i(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.i(24911);
        this.appId = this.wPP.getQueryParameter("appId");
        this.wPN = this.wPP.getQueryParameter("shopId");
        this.wPO = this.wPP.getQueryParameter("authUrl");
        this.extend = this.wPP.getQueryParameter("extend");
        this.dmc = this.wPP.getQueryParameter(AppMeasurement.Param.TIMESTAMP);
        this.sign = this.wPP.getQueryParameter("sign");
        Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.wPP, this.appId, this.wPN, this.wPO, this.extend, this.dmc, this.sign);
        AppMethodBeat.o(24911);
    }

    @Override // com.tencent.mm.plugin.freewifi.e.a
    public final void connect() {
        AppMethodBeat.i(24912);
        if (m.eP(this.ssid)) {
            Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)));
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.wPy;
            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.wRo = m.a(this.wPz, k.b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            AppMethodBeat.o(24912);
        } else if (m.eP(this.wPO)) {
            Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)));
            FreeWifiFrontPageUI freeWifiFrontPageUI2 = this.wPy;
            FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.FAIL;
            FreeWifiFrontPageUI.a aVar2 = new FreeWifiFrontPageUI.a();
            aVar2.wRo = m.a(this.wPz, k.b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI2.a(dVar2, aVar2);
            AppMethodBeat.o(24912);
        } else {
            StringBuilder sb = new StringBuilder(this.wPO);
            if (this.wPO.indexOf("?") == -1) {
                sb.append("?extend=").append(this.extend);
            } else {
                sb.append("&extend=").append(this.extend);
            }
            final String sb2 = sb.toString();
            j.dNq().dMZ().post(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.e.i.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(24906);
                    Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), sb2);
                    a.dMN();
                    a.a(sb2, new a.AbstractC1369a() {
                        /* class com.tencent.mm.plugin.freewifi.e.i.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                        public final void d(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.i(24904);
                            int responseCode = httpURLConnection.getResponseCode();
                            Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), Integer.valueOf(responseCode));
                            if (responseCode == 200) {
                                i.this.dNL();
                                AppMethodBeat.o(24904);
                            } else if (responseCode == 302) {
                                i.a(i.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.o(24904);
                            } else {
                                Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)));
                                FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.wPy;
                                FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                                aVar.wRo = m.a(i.this.wPz, k.b.ThreeThreeAuth, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                AppMethodBeat.o(24904);
                            }
                        }

                        @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                        public final void o(Exception exc) {
                            AppMethodBeat.i(24905);
                            Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), exc.getMessage(), m.m(exc));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.wPy;
                            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.wRo = m.a(i.this.wPz, k.b.ThreeThreeAuth, m.n(exc));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            AppMethodBeat.o(24905);
                        }
                    });
                    AppMethodBeat.o(24906);
                }
            });
            AppMethodBeat.o(24912);
        }
    }

    /* access modifiers changed from: protected */
    public final void dNL() {
        AppMethodBeat.i(24913);
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.e.i.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(24910);
                k.a dMF = k.dMF();
                dMF.ssid = i.this.ssid;
                dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol33");
                dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol33");
                dMF.dFd = i.this.dFd;
                dMF.quX = m.aw(i.this.intent);
                dMF.wNc = i.this.wPz;
                dMF.wNd = k.b.GetBackPage33.wNO;
                dMF.wNe = k.b.GetBackPage33.name;
                dMF.channel = m.az(i.this.intent);
                dMF.result = 0;
                dMF.dMH().dMG();
                Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), "", d.dNb(), d.dNf(), Integer.valueOf(d.dNc()));
                new f(i.this.ssid, m.axN("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.wPN, i.this.wPO, i.this.extend, i.this.dmc, i.this.sign).c(new com.tencent.mm.ak.i() {
                    /* class com.tencent.mm.plugin.freewifi.e.i.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(24909);
                        Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        k.a dMF = k.dMF();
                        dMF.ssid = i.this.ssid;
                        dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol33");
                        dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol33");
                        dMF.dFd = i.this.dFd;
                        dMF.quX = m.aw(i.this.intent);
                        dMF.wNc = m.ay(i.this.intent);
                        dMF.wNd = k.b.GetBackPage33Return.wNO;
                        dMF.wNe = k.b.GetBackPage33Return.name;
                        dMF.channel = m.az(i.this.intent);
                        dMF.result = i3;
                        dMF.resultMsg = str;
                        dMF.dMH().dMG();
                        if (i2 == 0 && i3 == 0) {
                            ih dNz = ((f) qVar).dNz();
                            if (dNz != null) {
                                Log.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb, dNz.KMv);
                                FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.wPy;
                                FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.SUCCESS;
                                FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                                bVar.wRL = dNz;
                                freeWifiFrontPageUI.a(dVar, bVar);
                                AppMethodBeat.o(24909);
                                return;
                            }
                            FreeWifiFrontPageUI freeWifiFrontPageUI2 = i.this.wPy;
                            FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.wRo = m.a(i.this.wPz, k.b.GetBackPage33Return, 20);
                            freeWifiFrontPageUI2.a(dVar2, aVar);
                            AppMethodBeat.o(24909);
                        } else if (i3 == -30032) {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", i.this.wPy.getString(R.string.dhr));
                            intent.setClass(i.this.wPy, FreeWifiErrorUI.class);
                            i.this.wPy.finish();
                            FreeWifiFrontPageUI freeWifiFrontPageUI3 = i.this.wPy;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiFrontPageUI3, bl.axQ(), "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            freeWifiFrontPageUI3.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiFrontPageUI3, "com/tencent/mm/plugin/freewifi/protocol/ProtocolThreeThree$3$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(24909);
                        } else {
                            FreeWifiFrontPageUI freeWifiFrontPageUI4 = i.this.wPy;
                            FreeWifiFrontPageUI.d dVar3 = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar2 = new FreeWifiFrontPageUI.a();
                            aVar2.wRn = R.string.dhm;
                            aVar2.wRo = m.a(i.this.wPz, k.b.GetBackPage33Return, i3);
                            freeWifiFrontPageUI4.a(dVar3, aVar2);
                            AppMethodBeat.o(24909);
                        }
                    }
                });
                AppMethodBeat.o(24910);
            }
        });
        AppMethodBeat.o(24913);
    }

    static /* synthetic */ void a(i iVar, String str) {
        AppMethodBeat.i(24914);
        iVar.wPK++;
        if (iVar.wPK > 3) {
            Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.aw(iVar.intent), Integer.valueOf(m.ax(iVar.intent)));
            FreeWifiFrontPageUI freeWifiFrontPageUI = iVar.wPy;
            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.wRo = m.a(iVar.wPz, k.b.ThreeThreeAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            AppMethodBeat.o(24914);
            return;
        }
        Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.aw(iVar.intent), Integer.valueOf(m.ax(iVar.intent)), str);
        if (m.eP(str)) {
            FreeWifiFrontPageUI freeWifiFrontPageUI2 = iVar.wPy;
            FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.FAIL;
            FreeWifiFrontPageUI.a aVar2 = new FreeWifiFrontPageUI.a();
            aVar2.wRo = m.a(iVar.wPz, k.b.ThreeThreeAuth, 34);
            freeWifiFrontPageUI2.a(dVar2, aVar2);
            AppMethodBeat.o(24914);
            return;
        }
        AnonymousClass2 r0 = new a.AbstractC1369a() {
            /* class com.tencent.mm.plugin.freewifi.e.i.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void d(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(24907);
                int responseCode = httpURLConnection.getResponseCode();
                Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    i.this.dNL();
                    AppMethodBeat.o(24907);
                } else if (responseCode == 302) {
                    i.a(i.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(24907);
                } else {
                    Log.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.wPy;
                    FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.wRo = m.a(i.this.wPz, k.b.ThreeThreeAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    AppMethodBeat.o(24907);
                }
            }

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void o(Exception exc) {
                AppMethodBeat.i(24908);
                Log.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.aw(i.this.intent), Integer.valueOf(m.ax(i.this.intent)), exc.getMessage(), m.m(exc));
                FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.wPy;
                FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.wRo = m.a(i.this.wPz, k.b.ThreeThreeAuth, m.n(exc));
                freeWifiFrontPageUI.a(dVar, aVar);
                AppMethodBeat.o(24908);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            a.dMN();
            a.a(str, parse.getEncodedQuery(), r0);
            AppMethodBeat.o(24914);
            return;
        }
        a.dMN();
        a.a(str, r0);
        AppMethodBeat.o(24914);
    }
}
