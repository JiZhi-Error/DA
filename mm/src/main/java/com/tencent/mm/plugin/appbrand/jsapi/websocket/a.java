package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Timer;

public final class a implements d {
    private com.tencent.mm.plugin.appbrand.s.a czW;
    private final String mGo;
    private int mGp;

    static /* synthetic */ void a(a aVar, e eVar) {
        AppMethodBeat.i(144265);
        aVar.d(eVar);
        AppMethodBeat.o(144265);
    }

    static /* synthetic */ void f(e eVar) {
        AppMethodBeat.i(144264);
        e(eVar);
        AppMethodBeat.o(144264);
    }

    public a(com.tencent.mm.plugin.appbrand.s.a aVar) {
        this.mGo = aVar.nhM;
        this.mGp = aVar.nhI;
        this.czW = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void release() {
        AppMethodBeat.i(144253);
        a(aby(AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.o(144253);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r12 = new java.net.URI(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0054, code lost:
        r5 = r18.optBoolean("tcpNoDelay", false);
        r8 = r18.optBoolean("perMessageDeflate", false);
        r19.put("User-Agent", r13.mGo);
        r2 = com.tencent.mm.plugin.appbrand.s.j.ap(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007a, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r2) != false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007c, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWcWssSocket", "protocols %s", r2);
        r19.put("Sec-WebSocket-Protocol", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0093, code lost:
        r2 = com.tencent.mm.plugin.appbrand.s.j.a(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009b, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r2) != false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009d, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWcWssSocket", "Origin %s", r2);
        r19.put("Origin", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b4, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00bc, code lost:
        if (com.tencent.luggage.h.l.C(r11, "ws://") == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00be, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00bf, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWcWssSocket", "connectSocket, taskId=%s, url= %s, appType = %d, timeout = %d, tcpNoDelay = %b, skipDimain = %b, perMessageDeflate = %b", r15, r11, java.lang.Integer.valueOf(r16), java.lang.Integer.valueOf(r17), java.lang.Boolean.valueOf(r5), java.lang.Boolean.valueOf(r6), java.lang.Boolean.valueOf(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.b(r14, r11, r12, r19, new com.tencent.mm.plugin.appbrand.jsapi.websocket.WssConfig(r17, r17, r5, r6, r16, r8), new java.util.ArrayList(), r13.czW);
        r3.a(new com.tencent.mm.plugin.appbrand.jsapi.websocket.a.AnonymousClass1(r13));
        r3.abz(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0129, code lost:
        if (com.tencent.luggage.h.l.C(r11, "ws://") != false) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0132, code lost:
        if (com.tencent.luggage.h.l.C(r11, "wss://") == false) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0134, code lost:
        r2 = new java.util.Timer();
        r4 = new com.tencent.mm.plugin.appbrand.jsapi.websocket.a.AnonymousClass2(r13);
        c(r3);
        r3.a(r2);
        r2.schedule(r4, (long) r17);
        r3.connect();
        com.tencent.matrix.trace.core.AppMethodBeat.o(144254);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0157, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0158, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", r2, "Exception: url %s", r11);
        r20.XT(r2.getMessage());
        com.tencent.matrix.trace.core.AppMethodBeat.o(144254);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0181, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0182, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", r2, "connect fail Exception", new java.lang.Object[0]);
        r20.XU("url not well format");
        com.tencent.matrix.trace.core.AppMethodBeat.o(144254);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x019e, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandNetworkWcWssSocket", "url error: %s not ws:// or wss://", r11);
        r20.XU("url not ws or wss");
        com.tencent.matrix.trace.core.AppMethodBeat.o(144254);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        r11 = r18.optString("url");
     */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r14, final java.lang.String r15, int r16, int r17, org.json.JSONObject r18, java.util.Map<java.lang.String, java.lang.String> r19, final com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a r20) {
        /*
        // Method dump skipped, instructions count: 445
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.websocket.a.a(java.lang.String, java.lang.String, int, int, org.json.JSONObject, java.util.Map, com.tencent.mm.plugin.appbrand.jsapi.websocket.d$a):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void a(e eVar) {
        AppMethodBeat.i(144255);
        if (eVar != null) {
            try {
                Log.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket");
                eVar.close();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", e2, "send error Exception", new Object[0]);
                e(eVar);
            }
            d(eVar);
        }
        AppMethodBeat.o(144255);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void a(e eVar, int i2, String str) {
        AppMethodBeat.i(144256);
        if (eVar != null) {
            try {
                Log.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket code:%d,reason:%s", Integer.valueOf(i2), str);
                eVar.bQ(str, i2);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", e2, "send error Exception", new Object[0]);
            }
            d(eVar);
        }
        AppMethodBeat.o(144256);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final boolean b(e eVar) {
        AppMethodBeat.i(144257);
        if (eVar != null) {
            boolean isOpen = eVar.isOpen();
            AppMethodBeat.o(144257);
            return isOpen;
        }
        AppMethodBeat.o(144257);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void a(e eVar, String str) {
        AppMethodBeat.i(144258);
        if (eVar != null) {
            eVar.abA(str);
        }
        AppMethodBeat.o(144258);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void a(e eVar, ByteBuffer byteBuffer) {
        AppMethodBeat.i(144259);
        if (eVar != null) {
            eVar.o(byteBuffer);
        }
        AppMethodBeat.o(144259);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final e aby(String str) {
        AppMethodBeat.i(144260);
        if (str == null) {
            AppMethodBeat.o(144260);
            return null;
        }
        synchronized (mGL) {
            try {
                Iterator it = mGL.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    if (str.equals(eVar.bjl())) {
                        return eVar;
                    }
                }
                AppMethodBeat.o(144260);
                return null;
            } finally {
                AppMethodBeat.o(144260);
            }
        }
    }

    private static void c(e eVar) {
        AppMethodBeat.i(144261);
        synchronized (mGL) {
            try {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(eVar.bjl())) {
                    mGL.clear();
                }
                mGL.add(eVar);
            } finally {
                AppMethodBeat.o(144261);
            }
        }
    }

    private synchronized void d(e eVar) {
        AppMethodBeat.i(144262);
        if (eVar == null) {
            AppMethodBeat.o(144262);
        } else {
            synchronized (mGL) {
                try {
                    mGL.remove(eVar);
                } finally {
                    AppMethodBeat.o(144262);
                }
            }
        }
    }

    private static void e(e eVar) {
        AppMethodBeat.i(144263);
        if (eVar == null) {
            AppMethodBeat.o(144263);
            return;
        }
        Timer bLn = eVar.bLn();
        Log.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to stop connectTimer");
        if (bLn != null) {
            bLn.cancel();
            eVar.a((Timer) null);
        }
        AppMethodBeat.o(144263);
    }
}
