package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j extends e implements a {
    String dmc = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    String openId = this.intent.getStringExtra("free_wifi_openid");
    String sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    private a wPE;
    private int wPK = 0;
    String wPU = this.intent.getStringExtra("free_wifi_tid");

    static /* synthetic */ void a(j jVar, int i2, String str) {
        AppMethodBeat.i(24934);
        jVar.bu(i2, str);
        AppMethodBeat.o(24934);
    }

    public j(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.i(24930);
        Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", m.aw(this.intent), Integer.valueOf(m.ax(this.intent)), this.openId, this.wPU, this.dmc, this.sign);
        AppMethodBeat.o(24930);
    }

    @Override // com.tencent.mm.plugin.freewifi.e.a
    public final void connect() {
        AppMethodBeat.i(24931);
        this.wPE = new a(this.ssid, this.wPy);
        com.tencent.mm.plugin.freewifi.model.j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.e.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(24915);
                j.a(j.this);
                AppMethodBeat.o(24915);
            }
        });
        AppMethodBeat.o(24931);
    }

    private void bu(int i2, String str) {
        AppMethodBeat.i(24932);
        k.a dMF = k.dMF();
        dMF.ssid = this.ssid;
        dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol32");
        dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol32");
        dMF.dFd = this.dFd;
        dMF.wNb = this.appId;
        dMF.quX = m.aw(this.intent);
        dMF.wNc = 32;
        dMF.wNd = k.b.ThreeTwoAuth.wNO;
        dMF.wNe = k.b.ThreeTwoAuth.name;
        dMF.result = i2;
        dMF.resultMsg = str;
        dMF.channel = m.az(this.intent);
        dMF.dMH().dMG();
        AppMethodBeat.o(24932);
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(24933);
        Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", m.aw(jVar.intent), Integer.valueOf(m.ax(jVar.intent)), jVar.ssid);
        jVar.wPE.a(new a.AbstractC1368a() {
            /* class com.tencent.mm.plugin.freewifi.e.j.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.freewifi.a.AbstractC1368a
            public final void onSuccess() {
                AppMethodBeat.i(24923);
                k.a dMF = k.dMF();
                dMF.ssid = j.this.ssid;
                dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol32");
                dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol32");
                dMF.dFd = j.this.dFd;
                dMF.wNb = j.this.appId;
                dMF.quX = m.aw(j.this.intent);
                dMF.wNc = m.ay(j.this.intent);
                dMF.wNd = k.b.AddNetwork.wNO;
                dMF.wNe = k.b.AddNetwork.name;
                dMF.result = 0;
                dMF.channel = m.az(j.this.intent);
                dMF.dMH().dMG();
                final String dMC = h.b.wMW.dMC();
                Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), j.this.ssid, dMC);
                AnonymousClass1 r1 = new a.AbstractC1369a() {
                    /* class com.tencent.mm.plugin.freewifi.e.j.AnonymousClass2.AnonymousClass1 */
                    int wPW = 0;
                    private final int wPX = 3;
                    private int wPY = 0;
                    private a.AbstractC1369a wPZ = new a.AbstractC1369a() {
                        /* class com.tencent.mm.plugin.freewifi.e.j.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                        public final void d(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.i(24916);
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)));
                                FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                                FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                                aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoBlack, 35);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                j.a(j.this, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                                AppMethodBeat.o(24916);
                            } else if (responseCode == 302) {
                                AnonymousClass1.a(AnonymousClass1.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.o(24916);
                            } else {
                                Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)));
                                FreeWifiFrontPageUI freeWifiFrontPageUI2 = j.this.wPy;
                                FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.FAIL;
                                FreeWifiFrontPageUI.a aVar2 = new FreeWifiFrontPageUI.a();
                                aVar2.wRo = m.a(j.this.wPz, k.b.ThreeTwoBlack, 32);
                                freeWifiFrontPageUI2.a(dVar2, aVar2);
                                j.a(j.this, 32, "INVALID_HTTP_RESP_CODE");
                                AppMethodBeat.o(24916);
                            }
                        }

                        @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                        public final void o(Exception exc) {
                            AppMethodBeat.i(24917);
                            Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), exc.getMessage(), m.m(exc));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoBlack, m.n(exc));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.a(j.this, m.n(exc), m.l(exc));
                            AppMethodBeat.o(24917);
                        }
                    };

                    {
                        AppMethodBeat.i(24918);
                        AppMethodBeat.o(24918);
                    }

                    static /* synthetic */ void a(AnonymousClass1 r1, String str) {
                        AppMethodBeat.i(24922);
                        r1.axX(str);
                        AppMethodBeat.o(24922);
                    }

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void d(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(24919);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)));
                            j.a(j.this, 0, "");
                            m.a(j.this.intent, j.this.dFd, j.this.wPz, j.this.channelId, j.this.wPy, "MicroMsg.FreeWifi.Protocol32");
                            AppMethodBeat.o(24919);
                        } else if (responseCode == 302) {
                            axX(httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(24919);
                        } else {
                            Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoBlack, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.b(j.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(24919);
                        }
                    }

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void o(Exception exc) {
                        AppMethodBeat.i(24920);
                        Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), exc.getMessage(), m.m(exc));
                        if (exc instanceof UnknownHostException) {
                            j.b(j.this, 102, m.l(exc));
                            Log.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.wPW);
                            int i2 = this.wPW + 1;
                            this.wPW = i2;
                            if (i2 <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.dMN();
                                    com.tencent.mm.plugin.freewifi.a.a.a(dMC, this);
                                    AppMethodBeat.o(24920);
                                } catch (InterruptedException e2) {
                                    Log.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", m.m(exc));
                                    j.b(j.this, 103, m.l(exc));
                                    FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                                    FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                                    aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoBlack, 103);
                                    freeWifiFrontPageUI.a(dVar, aVar);
                                    AppMethodBeat.o(24920);
                                }
                            } else {
                                FreeWifiFrontPageUI freeWifiFrontPageUI2 = j.this.wPy;
                                FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.FAIL;
                                FreeWifiFrontPageUI.a aVar2 = new FreeWifiFrontPageUI.a();
                                aVar2.wRo = m.a(j.this.wPz, k.b.ThreeTwoBlack, m.n(exc));
                                freeWifiFrontPageUI2.a(dVar2, aVar2);
                                j.b(j.this, m.n(exc), m.l(exc));
                                AppMethodBeat.o(24920);
                            }
                        } else {
                            FreeWifiFrontPageUI freeWifiFrontPageUI3 = j.this.wPy;
                            FreeWifiFrontPageUI.d dVar3 = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar3 = new FreeWifiFrontPageUI.a();
                            aVar3.wRo = m.a(j.this.wPz, k.b.ThreeTwoBlack, m.n(exc));
                            freeWifiFrontPageUI3.a(dVar3, aVar3);
                            j.b(j.this, m.n(exc), m.l(exc));
                            AppMethodBeat.o(24920);
                        }
                    }

                    private void axX(String str) {
                        AppMethodBeat.i(24921);
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String axL = m.axL(parse.getQueryParameter("extend"));
                        Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), str, queryParameter, axL);
                        if (m.eP(queryParameter)) {
                            this.wPY++;
                            if (this.wPY < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.dMN();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.wPZ);
                                AppMethodBeat.o(24921);
                                return;
                            }
                            Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoBlack, 36);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.a(j.this, 36, "BLACK_302_TIMES_EXCESS");
                            AppMethodBeat.o(24921);
                            return;
                        }
                        StringBuilder sb = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            sb.append("&extend=").append(axL);
                        } else {
                            sb.append("?extend=").append(axL);
                        }
                        sb.append("&openId=").append(m.axL(j.this.openId)).append("&tid=").append(m.axL(j.this.wPU)).append("&timestamp=").append(j.this.dmc).append("&sign=").append(j.this.sign);
                        j.a(j.this, sb.toString());
                        Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), sb.toString());
                        AppMethodBeat.o(24921);
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.dMN();
                com.tencent.mm.plugin.freewifi.a.a.a(dMC, r1);
                AppMethodBeat.o(24923);
            }

            @Override // com.tencent.mm.plugin.freewifi.a.AbstractC1368a
            public final void onFail(int i2) {
                AppMethodBeat.i(24924);
                Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), j.this.ssid, Integer.valueOf(i2));
                FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.wRo = m.a(j.this.wPz, k.b.AddNetwork, i2);
                freeWifiFrontPageUI.a(dVar, aVar);
                k.a dMF = k.dMF();
                dMF.ssid = j.this.ssid;
                dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol32");
                dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol32");
                dMF.dFd = j.this.dFd;
                dMF.wNb = j.this.appId;
                dMF.quX = m.aw(j.this.intent);
                dMF.wNc = m.ay(j.this.intent);
                dMF.wNe = k.b.AddNetwork.name;
                dMF.wNd = k.b.AddNetwork.wNO;
                dMF.result = i2;
                dMF.channel = m.az(j.this.intent);
                dMF.dMH().dMG();
                AppMethodBeat.o(24924);
            }
        });
        AppMethodBeat.o(24933);
    }

    static /* synthetic */ void b(j jVar, int i2, String str) {
        AppMethodBeat.i(24935);
        k.a dMF = k.dMF();
        dMF.ssid = jVar.ssid;
        dMF.bssid = m.axN("MicroMsg.FreeWifi.Protocol32");
        dMF.dFe = m.axO("MicroMsg.FreeWifi.Protocol32");
        dMF.dFd = jVar.dFd;
        dMF.wNb = jVar.appId;
        dMF.quX = m.aw(jVar.intent);
        dMF.wNc = 32;
        dMF.wNd = k.b.ThreeTwoAuth.wNO;
        dMF.wNe = k.b.ThreeTwoAuth.name;
        dMF.result = i2;
        dMF.resultMsg = str;
        dMF.channel = m.az(jVar.intent);
        dMF.dMH().dMG();
        AppMethodBeat.o(24935);
    }

    static /* synthetic */ void a(j jVar, final String str) {
        AppMethodBeat.i(24936);
        com.tencent.mm.plugin.freewifi.model.j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.e.j.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(24927);
                Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), str);
                com.tencent.mm.plugin.freewifi.a.a.dMN();
                com.tencent.mm.plugin.freewifi.a.a.a(str, new a.AbstractC1369a() {
                    /* class com.tencent.mm.plugin.freewifi.e.j.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void d(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(24925);
                        int responseCode = httpURLConnection.getResponseCode();
                        Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), Integer.valueOf(responseCode));
                        if (responseCode == 200) {
                            j.a(j.this, 0, "");
                            m.a(j.this.intent, j.this.dFd, j.this.wPz, j.this.channelId, j.this.wPy, "MicroMsg.FreeWifi.Protocol32");
                            AppMethodBeat.o(24925);
                        } else if (responseCode == 302) {
                            j.b(j.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(24925);
                        } else {
                            Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoAuth, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.a(j.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(24925);
                        }
                    }

                    @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
                    public final void o(Exception exc) {
                        AppMethodBeat.i(24926);
                        Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), exc.getMessage(), m.m(exc));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                        FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                        aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoAuth, m.n(exc));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        j.a(j.this, m.n(exc), m.l(exc));
                        AppMethodBeat.o(24926);
                    }
                });
                AppMethodBeat.o(24927);
            }
        });
        AppMethodBeat.o(24936);
    }

    static /* synthetic */ void b(j jVar, String str) {
        AppMethodBeat.i(24937);
        jVar.wPK++;
        if (jVar.wPK > 3) {
            Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.aw(jVar.intent), Integer.valueOf(m.ax(jVar.intent)));
            FreeWifiFrontPageUI freeWifiFrontPageUI = jVar.wPy;
            FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.wRo = m.a(jVar.wPz, k.b.ThreeTwoAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.bu(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.o(24937);
            return;
        }
        Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.aw(jVar.intent), Integer.valueOf(m.ax(jVar.intent)), str);
        if (m.eP(str)) {
            FreeWifiFrontPageUI freeWifiFrontPageUI2 = jVar.wPy;
            FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.FAIL;
            FreeWifiFrontPageUI.a aVar2 = new FreeWifiFrontPageUI.a();
            aVar2.wRo = m.a(jVar.wPz, k.b.ThreeTwoAuth, 34);
            freeWifiFrontPageUI2.a(dVar2, aVar2);
            jVar.bu(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.o(24937);
            return;
        }
        AnonymousClass4 r0 = new a.AbstractC1369a() {
            /* class com.tencent.mm.plugin.freewifi.e.j.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void d(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(24928);
                int responseCode = httpURLConnection.getResponseCode();
                Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    j.a(j.this, 0, "");
                    m.a(j.this.intent, j.this.dFd, j.this.wPz, j.this.channelId, j.this.wPy, "MicroMsg.FreeWifi.Protocol32");
                    AppMethodBeat.o(24928);
                } else if (responseCode == 302) {
                    j.b(j.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(24928);
                } else {
                    Log.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                    FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    j.a(j.this, 32, "INVALID_HTTP_RESP_CODE");
                    AppMethodBeat.o(24928);
                }
            }

            @Override // com.tencent.mm.plugin.freewifi.a.a.AbstractC1369a
            public final void o(Exception exc) {
                AppMethodBeat.i(24929);
                Log.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.aw(j.this.intent), Integer.valueOf(m.ax(j.this.intent)), exc.getMessage(), m.m(exc));
                FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.wPy;
                FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.wRo = m.a(j.this.wPz, k.b.ThreeTwoAuth, m.n(exc));
                freeWifiFrontPageUI.a(dVar, aVar);
                j.a(j.this, m.n(exc), m.l(exc));
                AppMethodBeat.o(24929);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            com.tencent.mm.plugin.freewifi.a.a.dMN();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), r0);
            AppMethodBeat.o(24937);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.dMN();
        com.tencent.mm.plugin.freewifi.a.a.a(str, r0);
        AppMethodBeat.o(24937);
    }
}
