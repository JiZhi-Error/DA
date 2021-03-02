package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.e.d;
import com.tencent.mm.plugin.appbrand.ae.e.f;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import javax.net.ssl.X509TrustManager;

public final class b implements e {
    private String jEY;
    private ArrayList<String> mGA;
    private e.a mGB;
    private WcWss.a mGC;
    private a mGD = a.NOT_YET_CONNECTED;
    private String mGu;
    private URI mGv;
    private ArrayList mGw = new ArrayList();
    private ArrayList mGx = new ArrayList();
    private WssConfig mGy;
    private int mGz = -1;
    private Map<String, String> mHeaders;
    private Timer mTimer = null;
    private X509TrustManager mTrustManager;
    private String mUrl;

    public enum a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        public static a valueOf(String str) {
            AppMethodBeat.i(144272);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(144272);
            return aVar;
        }

        static {
            AppMethodBeat.i(144273);
            AppMethodBeat.o(144273);
        }
    }

    public b(String str, String str2, URI uri, Map<String, String> map, WssConfig wssConfig, ArrayList<String> arrayList, com.tencent.mm.plugin.appbrand.s.a aVar) {
        AppMethodBeat.i(144274);
        this.mGu = str;
        this.mUrl = str2;
        this.mGv = uri;
        this.mHeaders = map;
        this.mGy = wssConfig;
        this.mGA = arrayList;
        this.mTrustManager = j.b(aVar);
        if (this.mHeaders == null) {
            Log.e("MicroMsg.AppBrandWcWssSocket", "header is null");
            AppMethodBeat.o(144274);
            return;
        }
        for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
            this.mGw.add(entry.getKey());
            this.mGx.add(entry.getValue());
        }
        AppMethodBeat.o(144274);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void a(e.a aVar) {
        AppMethodBeat.i(144275);
        Log.i("MicroMsg.AppBrandWcWssSocket", "setCallBack");
        this.mGB = aVar;
        this.mGC = new WcWss.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.websocket.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss.a
            public final void onHandShake(String str, int i2, String[] strArr, String[] strArr2) {
                AppMethodBeat.i(144266);
                Log.i("MicroMsg.AppBrandWcWssSocket", "onHandShake group:%s, wssId:%s", str, Integer.valueOf(i2));
                b.this.mGB.a((com.tencent.mm.plugin.appbrand.ae.e.a) b.a(b.this, 1, strArr, strArr2));
                AppMethodBeat.o(144266);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss.a
            public final void onOpen(String str, int i2, boolean z, String[] strArr, String[] strArr2, int i3, String str2, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
                AppMethodBeat.i(175387);
                Log.i("MicroMsg.AppBrandWcWssSocket", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s, fetchStart:%d, domainLookupStart:%d, domainLookupEnd:%d, connectStart:%d, connectEnd:%d, rtt:%d, handshakeCost:%d, cost:%d", str, Boolean.valueOf(z), str2, Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9));
                if (z) {
                    b.this.mGD = a.OPEN;
                    f a2 = b.a(b.this, 2, strArr, strArr2);
                    b.this.mGB.a((h) a2, b.a(new String[]{"fetchStart", "domainLookupStart", "domainLookupEnd", "connectStart", "connectEnd", "rtt", "handshakeCost", "cost"}, new long[]{j2, j3, j4, j5, j6, j7, j8, j9}));
                    AppMethodBeat.o(175387);
                    return;
                }
                b.this.mGB.XT("onOpen fail code:" + i3 + ", msg:" + str2);
                AppMethodBeat.o(175387);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss.a
            public final void onMessage(String str, int i2, byte[] bArr, boolean z) {
                AppMethodBeat.i(144268);
                Log.d("MicroMsg.AppBrandWcWssSocket", "onMessage group:%s,wssId:%s,isText:%s", str, Integer.valueOf(i2), Boolean.valueOf(z));
                if (z) {
                    try {
                        b.this.mGB.aar(new String(bArr, ProtocolPackage.ServerEncoding));
                        AppMethodBeat.o(144268);
                    } catch (UnsupportedEncodingException e2) {
                        Log.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e2, "onmessage unsupport encoding UnsupportedEncodingException", new Object[0]);
                        AppMethodBeat.o(144268);
                    }
                } else {
                    b.this.mGB.k(ByteBuffer.wrap(bArr));
                    AppMethodBeat.o(144268);
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss.a
            public final void onClose(String str, int i2, int i3, String str2) {
                AppMethodBeat.i(144269);
                Log.i("MicroMsg.AppBrandWcWssSocket", "onClose group:%s,id:%s, reason:%s, code:%s", str, Integer.valueOf(i2), str2, Integer.valueOf(i3));
                b.this.mGD = a.CLOSED;
                b.this.mGB.ae(i3, str2);
                AppMethodBeat.o(144269);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss.a
            public final int doCertificateVerify(String str, byte[][] bArr) {
                AppMethodBeat.i(144270);
                Log.i("MicroMsg.AppBrandWcWssSocket", "certifivate verify for ".concat(String.valueOf(str)));
                try {
                    AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, EncryptUtil.KEY_ALGORITHM, str, 1, b.this.mTrustManager);
                    Log.i("MicroMsg.AppBrandWcWssSocket", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
                    if (verifyServerCertificates.getStatus() != 0) {
                        verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "ECDSA", str, 1, b.this.mTrustManager);
                        Log.i("MicroMsg.AppBrandWcWssSocket", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
                    }
                    if (verifyServerCertificates.getStatus() != 0) {
                        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 7, 1, false);
                    }
                    if (verifyServerCertificates.getStatus() == 0 && !verifyServerCertificates.isIssuedByHostMatched()) {
                        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 8, 1, false);
                    }
                    if (verifyServerCertificates.getStatus() == 0 && !verifyServerCertificates.isIssuedByKnownRoot()) {
                        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(972, 9, 1, false);
                    }
                    if (verifyServerCertificates.getStatus() != 0 || !verifyServerCertificates.isIssuedByKnownRoot()) {
                        AppMethodBeat.o(144270);
                        return -1;
                    }
                    AppMethodBeat.o(144270);
                    return 0;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e2, "doCertificateVerify Exception", new Object[0]);
                    AppMethodBeat.o(144270);
                    return -1;
                }
            }
        };
        AppMethodBeat.o(144275);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final String bjl() {
        return this.jEY;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void abz(String str) {
        this.jEY = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final Timer bLn() {
        return this.mTimer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void a(Timer timer) {
        this.mTimer = timer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void close() {
        AppMethodBeat.i(144276);
        Log.i("MicroMsg.AppBrandWcWssSocket", "close");
        bQ("default_close", 1000);
        AppMethodBeat.o(144276);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void bQ(String str, int i2) {
        AppMethodBeat.i(144277);
        Log.i("MicroMsg.AppBrandWcWssSocket", "close reason:%s,code:%s", str, Integer.valueOf(i2));
        if (this.mGz < 0) {
            this.mGB.XT("error socket id");
            AppMethodBeat.o(144277);
            return;
        }
        if (!(this.mGD == a.CLOSING || this.mGD == a.CLOSED)) {
            this.mGD = a.CLOSING;
        }
        WcWss.closeSocket(this.mGu, this.mGz, i2, str);
        AppMethodBeat.o(144277);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final boolean isOpen() {
        return this.mGD == a.OPEN;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void abA(String str) {
        AppMethodBeat.i(144278);
        Log.i("MicroMsg.AppBrandWcWssSocket", "send text");
        if (this.mGz < 0) {
            this.mGB.XT("error socket id");
            AppMethodBeat.o(144278);
            return;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(str.getBytes("UTF8"));
            byte[] bArr = new byte[wrap.remaining()];
            wrap.get(bArr);
            WcWss.sendBuffer(this.mGu, this.mGz, bArr, true);
            AppMethodBeat.o(144278);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e2, "unsupport encoding UnsupportedEncodingException", new Object[0]);
            this.mGB.XT("unsupport encoding");
            AppMethodBeat.o(144278);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void o(ByteBuffer byteBuffer) {
        AppMethodBeat.i(144279);
        Log.i("MicroMsg.AppBrandWcWssSocket", "send bytes");
        if (this.mGz < 0) {
            this.mGB.XT("error socket id");
            AppMethodBeat.o(144279);
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        WcWss.sendBuffer(this.mGu, this.mGz, bArr, false);
        AppMethodBeat.o(144279);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void connect() {
        AppMethodBeat.i(144280);
        Log.i("MicroMsg.AppBrandWcWssSocket", "connect");
        if (this.mHeaders == null) {
            this.mGB.XT("header is null");
            AppMethodBeat.o(144280);
            return;
        }
        this.mGz = WcWss.a(this.mGC, this.mGu, this.mUrl, this.mGw.toArray(), this.mGx.toArray(), this.mGy, this.mGA.toArray());
        if (this.mGz < 0) {
            this.mGB.XT("call connect fail code:" + this.mGz);
        }
        Log.i("MicroMsg.AppBrandWcWssSocket", "connect mWcWssId:%s", Integer.valueOf(this.mGz));
        AppMethodBeat.o(144280);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void setTcpNoDelay(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final void a(Socket socket) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    public final Socket getSocket() {
        return null;
    }

    static /* synthetic */ f a(b bVar, int i2, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(144281);
        if (i2 == 1) {
            String path = bVar.mGv.getPath();
            String query = bVar.mGv.getQuery();
            if (path == null || path.length() == 0) {
                path = FilePathGenerator.ANDROID_DIR_SEP;
            }
            if (query != null) {
                path = path + "?" + query;
            }
            int port = bVar.mGv.getPort();
            if (port == -1) {
                String scheme = bVar.mGv.getScheme();
                if (scheme.equals("wss")) {
                    port = JsApiPauseDownloadTask.CTRL_INDEX;
                } else if (scheme.equals("ws")) {
                    port = 80;
                } else {
                    Log.e("MicroMsg.AppBrandWcWssSocket", "getPort unkonow scheme:%s", scheme);
                }
            }
            String host = (port == -1 || port == 80) ? bVar.mGv.getHost() : bVar.mGv.getHost() + ":" + port;
            d dVar = new d();
            dVar.afO(path);
            dVar.put("Host", host);
            if (strArr == null || strArr2 == null) {
                Log.i("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", Integer.valueOf(i2));
                if (bVar.mHeaders != null) {
                    for (Map.Entry<String, String> entry : bVar.mHeaders.entrySet()) {
                        dVar.put(entry.getKey(), entry.getValue());
                    }
                } else {
                    Log.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake mHeaders is null type:%s", Integer.valueOf(i2));
                }
            } else if (strArr.length == strArr2.length) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    dVar.put(strArr[i3], strArr2[i3]);
                }
                Log.i("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey.length:%s, type:%s", Integer.valueOf(strArr.length), Integer.valueOf(i2));
            } else {
                Log.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", Integer.valueOf(i2));
            }
            AppMethodBeat.o(144281);
            return dVar;
        } else if (i2 == 2) {
            com.tencent.mm.plugin.appbrand.ae.e.e eVar = new com.tencent.mm.plugin.appbrand.ae.e.e();
            if (strArr == null || strArr2 == null) {
                Log.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", Integer.valueOf(i2));
            } else if (strArr.length == strArr2.length) {
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    eVar.put(strArr[i4], strArr2[i4]);
                }
            } else {
                Log.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", Integer.valueOf(i2));
            }
            AppMethodBeat.o(144281);
            return eVar;
        } else {
            Log.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake unknow type:%s", Integer.valueOf(i2));
            AppMethodBeat.o(144281);
            return null;
        }
    }

    static /* synthetic */ Map a(String[] strArr, long[] jArr) {
        AppMethodBeat.i(175388);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < 8; i2++) {
            hashMap.put(strArr[i2], Long.valueOf(jArr[i2]));
        }
        AppMethodBeat.o(175388);
        return hashMap;
    }
}
