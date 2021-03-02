package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends e implements a {
    private a wPE;
    private int wPF = 5;

    static /* synthetic */ void c(g gVar) {
        AppMethodBeat.i(24893);
        gVar.dNK();
        AppMethodBeat.o(24893);
    }

    public g(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
    }

    @Override // com.tencent.mm.plugin.freewifi.e.a
    public final void connect() {
        AppMethodBeat.i(24887);
        j.dNq().dMZ().post(new Runnable() {
            /* class com.tencent.mm.plugin.freewifi.e.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(24882);
                g.a(g.this);
                AppMethodBeat.o(24882);
            }
        });
        AppMethodBeat.o(24887);
    }

    private void dNK() {
        AppMethodBeat.i(24888);
        this.wPy.a(FreeWifiFrontPageUI.d.FAIL, FreeWifiFrontPageUI.a.wRK);
        AppMethodBeat.o(24888);
    }

    static String hu(String str, String str2) {
        String[] strArr;
        AppMethodBeat.i(24889);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
            AppMethodBeat.o(24889);
            return null;
        }
        String[] split = str.split("\\?");
        if (str2.length() > 0) {
            strArr = split[1].split("&");
        } else {
            strArr = split;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                if (str3.startsWith(str2)) {
                    String substring = str3.substring(str2.length());
                    AppMethodBeat.o(24889);
                    return substring;
                }
            }
        }
        AppMethodBeat.o(24889);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008f A[SYNTHETIC, Splitter:B:27:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab A[SYNTHETIC, Splitter:B:35:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String axW(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.e.g.axW(java.lang.String):java.lang.String");
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(24891);
        gVar.wPE = new a(gVar.ssid, gVar.wPy);
        gVar.wPE.a(new a.AbstractC1368a() {
            /* class com.tencent.mm.plugin.freewifi.e.g.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.freewifi.a.AbstractC1368a
            public final void onSuccess() {
                AppMethodBeat.i(24883);
                Log.i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", m.aw(g.this.intent), Integer.valueOf(m.ax(g.this.intent)));
                g.b(g.this);
                AppMethodBeat.o(24883);
            }

            @Override // com.tencent.mm.plugin.freewifi.a.AbstractC1368a
            public final void onFail(int i2) {
                AppMethodBeat.i(24884);
                g.c(g.this);
                AppMethodBeat.o(24884);
            }
        });
        AppMethodBeat.o(24891);
    }

    static /* synthetic */ void b(g gVar) {
        AppMethodBeat.i(24892);
        int i2 = gVar.wPF;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            Log.i("MicroMsg.FreeWifi.ProtocolOne", "now retry count = %d", Integer.valueOf(i3));
            String aqy = h.aqK().aqy();
            Log.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from cinfig : %s", aqy);
            if (Util.isNullOrNil(aqy)) {
                Log.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from config failed, use the default url : %s", "http://10.1.0.6/redirect");
                aqy = "http://10.1.0.6/redirect";
            }
            String axW = axW(aqy);
            Log.i("MicroMsg.FreeWifi.ProtocolOne", "get location from url : %s, %s", aqy, axW);
            if (Util.isNullOrNil(axW)) {
                Log.e("MicroMsg.FreeWifi.ProtocolOne", "get location from url failed : %s, %s", aqy, axW);
                try {
                    Thread.sleep(500);
                    i2 = i3;
                } catch (Exception e2) {
                    i2 = i3;
                }
            } else {
                String hu = hu(axW, "auth=");
                Log.i("MicroMsg.FreeWifi.ProtocolOne", "get apauthmessage from location : %s, %s", hu, axW);
                if (Util.isNullOrNil(hu)) {
                    Log.e("MicroMsg.FreeWifi.ProtocolOne", "get apauth message from location failed : %s", axW);
                } else {
                    String dNb = d.dNb();
                    Log.i("MicroMsg.FreeWifi.ProtocolOne", "get ap auth data : %s, url : %s, mac : %s", hu, gVar.pFJ, dNb);
                    if (!Util.isNullOrNil(hu)) {
                        new com.tencent.mm.plugin.freewifi.d.a(gVar.pFJ, gVar.ssid, dNb, "", hu, "", gVar.channelId, m.aw(gVar.intent)).c(new i() {
                            /* class com.tencent.mm.plugin.freewifi.e.g.AnonymousClass3 */

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                AppMethodBeat.i(24885);
                                Log.i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                if (i2 == 0 && i3 == 0) {
                                    com.tencent.mm.plugin.freewifi.d.a aVar = (com.tencent.mm.plugin.freewifi.d.a) qVar;
                                    String dNv = aVar.dNv();
                                    Log.i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", dNv);
                                    ih dNz = aVar.dNz();
                                    if (dNz != null) {
                                        Log.i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", dNz.KGX, dNz.oUJ, dNz.UserName, Integer.valueOf(dNz.KMt), dNz.KMu, dNz.keb);
                                        j.dNq().dMZ().post(new Runnable(dNv, dNz) {
                                            /* class com.tencent.mm.plugin.freewifi.e.g.AnonymousClass4 */
                                            final /* synthetic */ String wPH;
                                            final /* synthetic */ ih wPI;

                                            {
                                                this.wPH = r2;
                                                this.wPI = r3;
                                            }

                                            public final void run() {
                                                AppMethodBeat.i(24886);
                                                String axW = g.axW(this.wPH);
                                                Log.i("MicroMsg.FreeWifi.ProtocolOne", "get redirect location from loginurl : %s, %s", axW, this.wPH);
                                                if (!Util.isNullOrNil(axW)) {
                                                    String hu = g.hu(axW, "res=");
                                                    Log.i("MicroMsg.FreeWifi.ProtocolOne", "get connect result from location : %s, %s", hu, axW);
                                                    if (!Util.isNullOrNil(hu) && (hu.startsWith("success") || hu.startsWith("already"))) {
                                                        FreeWifiFrontPageUI freeWifiFrontPageUI = g.this.wPy;
                                                        FreeWifiFrontPageUI.d dVar = FreeWifiFrontPageUI.d.SUCCESS;
                                                        FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                                                        bVar.wRL = this.wPI;
                                                        freeWifiFrontPageUI.a(dVar, bVar);
                                                        AppMethodBeat.o(24886);
                                                        return;
                                                    }
                                                }
                                                g.c(g.this);
                                                AppMethodBeat.o(24886);
                                            }
                                        });
                                        AppMethodBeat.o(24885);
                                        return;
                                    }
                                    g.c(g.this);
                                    AppMethodBeat.o(24885);
                                    return;
                                }
                                g.c(g.this);
                                AppMethodBeat.o(24885);
                            }
                        });
                        AppMethodBeat.o(24892);
                        return;
                    }
                    gVar.dNK();
                    AppMethodBeat.o(24892);
                    return;
                }
            }
        }
        gVar.dNK();
        AppMethodBeat.o(24892);
    }
}
