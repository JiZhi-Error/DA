package com.tencent.mm.plugin.appbrand.s;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class k implements d {
    private SSLSocketFactory liT;
    protected final ArrayList<e> mGL = new ArrayList<>();
    private final String mGo;
    private int mGp;
    private boolean niN;

    public interface a {
        void a(f fVar, String str, com.tencent.mm.plugin.appbrand.jsapi.o.e eVar);

        void d(f fVar, String str);
    }

    public interface b {
        void XT(String str);

        void XU(String str);

        void ae(int i2, String str);

        void bAN();

        void bAO();

        void k(ByteBuffer byteBuffer);
    }

    public interface c {
        boolean Uw(String str);

        boolean btz();
    }

    static /* synthetic */ void a(k kVar, e eVar) {
        AppMethodBeat.i(144418);
        kVar.d(eVar);
        AppMethodBeat.o(144418);
    }

    static /* synthetic */ void g(e eVar) {
        AppMethodBeat.i(144417);
        e(eVar);
        AppMethodBeat.o(144417);
    }

    public k(a aVar) {
        AppMethodBeat.i(144405);
        SSLContext a2 = j.a(aVar);
        if (a2 != null) {
            this.liT = a2.getSocketFactory();
        }
        this.mGo = aVar.nhM;
        this.mGp = aVar.nhI;
        this.niN = aVar.cyQ;
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "mTLSSkipHostnameCheck is %b", Boolean.valueOf(this.niN));
        AppMethodBeat.o(144405);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r4 = new java.net.URI(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0054, code lost:
        r11 = r17.optBoolean("tcpNoDelay", false);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b, taskId=%s", r8, java.lang.Integer.valueOf(r16), java.lang.Boolean.valueOf(r11), r14);
        r18.put("User-Agent", r12.mGo);
        r2 = com.tencent.mm.plugin.appbrand.s.j.ap(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0090, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r2) != false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0092, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", r2);
        r18.put("Sec-WebSocket-Protocol", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a9, code lost:
        r2 = com.tencent.mm.plugin.appbrand.s.j.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b1, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r2) != false) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00b3, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", r2);
        r18.put("Origin", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2 = new com.tencent.mm.plugin.appbrand.s.k.AnonymousClass1(r12, r4, new com.tencent.mm.plugin.appbrand.ae.b.d(), r18, r16);
        r2.abz(r14);
        r2.setTcpNoDelay(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00e9, code lost:
        if (com.tencent.luggage.h.l.C(r8, "ws://") == false) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00eb, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", r8);
        r2.a(new java.net.Socket(java.net.Proxy.NO_PROXY));
        r2.connect();
        c(r2);
        r3 = new java.util.Timer();
        r4 = new com.tencent.mm.plugin.appbrand.s.k.AnonymousClass2(r12);
        r2.a(r3);
        r3.schedule(r4, (long) r16);
        com.tencent.matrix.trace.core.AppMethodBeat.o(144406);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0127, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0128, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", r2, "Exception: url %s", r8);
        r19.XT(r2.getMessage());
        com.tencent.matrix.trace.core.AppMethodBeat.o(144406);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0151, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0152, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", r2, "Exception: connect fail", new java.lang.Object[0]);
        r19.XU("url not well format");
        com.tencent.matrix.trace.core.AppMethodBeat.o(144406);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0175, code lost:
        if (com.tencent.luggage.h.l.C(r8, "wss://") == false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0177, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0188, code lost:
        if (r12.liT == null) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x018a, code lost:
        r3 = r12.liT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x018c, code lost:
        r2.a(r3.createSocket());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x019a, code lost:
        if (r13.equals("wx577c74fb940daaea") != false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01a3, code lost:
        if (r13.equals("wx850d691fd02de8a1") == false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01a5, code lost:
        r3 = (javax.net.ssl.SSLSocket) r2.getSocket();
        r4 = r3.getSupportedCipherSuites();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01af, code lost:
        if (r4 == null) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01b1, code lost:
        r3.setEnabledCipherSuites(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01b4, code lost:
        r2.connect();
        c(r2);
        r3 = new java.util.Timer();
        r4 = new com.tencent.mm.plugin.appbrand.s.k.AnonymousClass3(r12);
        r2.a(r3);
        r3.schedule(r4, (long) r16);
        com.tencent.matrix.trace.core.AppMethodBeat.o(144406);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01d7, code lost:
        r3 = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01de, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", r8);
        r19.XU("url not ws or wss");
        com.tencent.matrix.trace.core.AppMethodBeat.o(144406);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0046, code lost:
        r8 = r17.optString("url");
     */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r13, final java.lang.String r14, int r15, int r16, org.json.JSONObject r17, java.util.Map<java.lang.String, java.lang.String> r18, final com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a r19) {
        /*
        // Method dump skipped, instructions count: 509
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.k.a(java.lang.String, java.lang.String, int, int, org.json.JSONObject, java.util.Map, com.tencent.mm.plugin.appbrand.jsapi.websocket.d$a):void");
    }

    private void c(e eVar) {
        AppMethodBeat.i(144407);
        synchronized (this.mGL) {
            try {
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(eVar.bjl())) {
                    this.mGL.clear();
                }
                this.mGL.add(eVar);
            } finally {
                AppMethodBeat.o(144407);
            }
        }
    }

    private synchronized void d(e eVar) {
        AppMethodBeat.i(144408);
        if (eVar == null) {
            AppMethodBeat.o(144408);
        } else {
            synchronized (this.mGL) {
                try {
                    this.mGL.remove(eVar);
                } finally {
                    AppMethodBeat.o(144408);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void a(e eVar) {
        AppMethodBeat.i(144409);
        if (eVar != null) {
            try {
                Log.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                eVar.close();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", e2, "Exception: send error", new Object[0]);
                e(eVar);
            }
            d(eVar);
        }
        AppMethodBeat.o(144409);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void a(e eVar, int i2, String str) {
        AppMethodBeat.i(144410);
        if (eVar != null) {
            try {
                Log.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                eVar.bQ(str, i2);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", e2, "Exception: send error", new Object[0]);
            }
            d(eVar);
        }
        AppMethodBeat.o(144410);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final boolean b(e eVar) {
        AppMethodBeat.i(144411);
        if (eVar != null) {
            boolean isOpen = eVar.isOpen();
            AppMethodBeat.o(144411);
            return isOpen;
        }
        AppMethodBeat.o(144411);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void a(e eVar, String str) {
        AppMethodBeat.i(144412);
        if (eVar != null) {
            eVar.abA(str);
        }
        AppMethodBeat.o(144412);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void a(e eVar, ByteBuffer byteBuffer) {
        AppMethodBeat.i(144413);
        eVar.o(byteBuffer);
        AppMethodBeat.o(144413);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final void release() {
        AppMethodBeat.i(144414);
        a(aby(AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.o(144414);
    }

    private static void e(e eVar) {
        AppMethodBeat.i(144415);
        if (eVar == null) {
            AppMethodBeat.o(144415);
            return;
        }
        Timer bLn = eVar.bLn();
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
        if (bLn != null) {
            bLn.cancel();
            eVar.a((Timer) null);
        }
        AppMethodBeat.o(144415);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.d
    public final e aby(String str) {
        AppMethodBeat.i(144416);
        if (str == null) {
            AppMethodBeat.o(144416);
            return null;
        }
        synchronized (this.mGL) {
            try {
                Iterator<e> it = this.mGL.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (str.equals(next.bjl())) {
                        return next;
                    }
                }
                AppMethodBeat.o(144416);
                return null;
            } finally {
                AppMethodBeat.o(144416);
            }
        }
    }
}
