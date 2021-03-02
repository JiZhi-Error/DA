package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.trtc.TRTCCloudDef;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class m {
    private static AtomicInteger myV = new AtomicInteger(10000);
    private static AtomicInteger myW = new AtomicInteger(10000);
    private volatile boolean aFC;
    private final ExecutorService executorService;
    private int lkD;
    com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a mxs;
    private int myT = 0;
    private boolean myU = true;
    private final p myX;
    private Map<String, d> myY = new HashMap();
    private ConcurrentHashMap<String, e> myZ = new ConcurrentHashMap<>(8, 0.75f, 2);
    private Map<String, h> mza = new ConcurrentHashMap();
    private Map<String, h> mzb = new ConcurrentHashMap();
    private Map<String, h> mzc = new ConcurrentHashMap();
    private ServerSocket serverSocket;
    private Thread waitConnectionThread;

    static {
        AppMethodBeat.i(234815);
        AppMethodBeat.o(234815);
    }

    public m() {
        Object obj;
        AppMethodBeat.i(234805);
        final String cacheDir = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().getCacheDir();
        h.log(4, "VideoProxy", "initCache, cache dir:" + com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().getCacheDir());
        if (TextUtils.isEmpty(cacheDir)) {
            this.mxs = null;
            com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp.xw(-1);
            com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxa.xw(-1);
        } else {
            final long min = Math.min(h.abi(cacheDir), com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxl);
            h.log(4, "VideoProxy", "initCache, cache availableSpace=".concat(String.valueOf(min)));
            final com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h hVar = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h(min);
            com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.a(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(234801);
                    long j2 = 0;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        j2 = h.abj(cacheDir);
                    } catch (OutOfMemoryError e2) {
                        h.log(5, "VideoProxy", "initCache, calculate cacheSize OOM usedSpace set to 0");
                    }
                    long min = Math.min(j2 + min, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxl);
                    hVar.bGC = min;
                    h.log(4, "VideoProxy", "initCache, update cacheSize=" + min + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(234801);
                }
            }, "VideoProxy");
            this.mxs = new i(new o(cacheDir), hVar);
        }
        StringBuilder sb = new StringBuilder("initCache, cache:");
        if (this.mxs == null) {
            obj = BuildConfig.COMMAND;
        } else {
            obj = this.mxs;
        }
        h.log(4, "VideoProxy", sb.append(obj).toString());
        this.myX = new p();
        this.executorService = new m.b(TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        try {
            this.serverSocket = new ServerSocket(h.bKd(), 10, InetAddress.getByName(TRTCCloudDef.TRTC_SDK_VERSION));
            this.lkD = this.serverSocket.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.waitConnectionThread = new Thread(new c(countDownLatch), "video_proxy_wait_for_connection_thread");
            this.waitConnectionThread.start();
            countDownLatch.await();
            h.log(4, "VideoProxy", "proxy server start success, port:" + this.lkD);
            com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp.xw(0);
            com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxa.xw(0);
            AppMethodBeat.o(234805);
        } catch (IOException | IllegalStateException | InterruptedException e2) {
            this.executorService.shutdown();
            h.log(6, "VideoProxy", "proxy server start failed " + h.i(e2));
            com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp.xw(-2);
            com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxa.xw(-2);
            AppMethodBeat.o(234805);
        }
    }

    final class c implements Runnable {
        private CountDownLatch startSignal;

        public c(CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        public final void run() {
            AppMethodBeat.i(234804);
            this.startSignal.countDown();
            m.a(m.this);
            AppMethodBeat.o(234804);
        }
    }

    /* access modifiers changed from: package-private */
    public final class b implements Runnable {
        n mye;
        Future<?> mzk;
        CountDownLatch mzl;
        Socket socket;

        public b(Socket socket2, CountDownLatch countDownLatch) {
            this.socket = socket2;
            this.mzl = countDownLatch;
        }

        public final void run() {
            AppMethodBeat.i(234803);
            try {
                this.mzl.await();
            } catch (InterruptedException e2) {
                h.log(6, "VideoProxy", "SocketHandler run exception, reason " + h.i(e2));
            }
            this.mye = new n();
            this.mye.mzk = this.mzk;
            m.a(m.this, this.socket, this.mye);
            AppMethodBeat.o(234803);
        }
    }

    public final String bJU() {
        AppMethodBeat.i(234806);
        String str = "http://127.0.0.1:" + this.lkD;
        AppMethodBeat.o(234806);
        return str;
    }

    public final String a(String str, boolean z, boolean z2, String str2, int i2) {
        String str3;
        String str4 = null;
        AppMethodBeat.i(234807);
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxf || this.myT > 3 || this.executorService.isShutdown() || this.executorService.isTerminated()) {
            h.log(4, "VideoProxy", "getUrl, proxy disabled or server shutdown");
            com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxa.bJH();
            String abp = h.abp(str);
            AppMethodBeat.o(234807);
            return abp;
        }
        if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
            String abp2 = h.abp(str);
            if (h.abq(abp2)) {
                z2 = false;
                str = abp2;
            } else if (h.abr(abp2)) {
                z2 = false;
            } else {
                AppMethodBeat.o(234807);
                return abp2;
            }
        }
        if (h.aaW(str)) {
            if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxi) {
                h.log(4, "VideoProxy", "getUrl, hls proxy disabled");
                AppMethodBeat.o(234807);
                return str;
            }
            str2 = "application/vnd.apple.mpegurl";
            z2 = false;
        }
        String str5 = "";
        try {
            str5 = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            h.log(6, "VideoProxy", "invalid url " + h.i(e2));
        }
        if (TextUtils.isEmpty(str5)) {
            h.log(6, "VideoProxy", "url is empty ".concat(String.valueOf(str5)));
            AppMethodBeat.o(234807);
            return str;
        }
        String str6 = bJU() + FilePathGenerator.ANDROID_DIR_SEP + Uri.parse(str).getLastPathSegment() + "?url=" + str5;
        if (z2) {
            str6 = str6 + "&enableCache=1";
        }
        if (i2 == 90 || i2 == 10 || i2 == -1) {
            str6 = str6 + "&priority=" + i2;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                str3 = URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e3) {
                h.log(6, "VideoProxy", "unable to encode contentType ".concat(String.valueOf(str2)));
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                str6 = str6 + "&contentType=" + str3;
            }
        }
        if (z) {
            str4 = new StringBuilder().append(System.currentTimeMillis()).append(myV.getAndIncrement()).toString();
        }
        if (str4 != null) {
            str6 = str6 + "&id=" + str4;
        }
        if (this.myU) {
            try {
                str6 = str6 + "&secret=" + l.F("des", l.bKg(), h.abl(str));
            } catch (Exception e4) {
                h.log(6, "VideoProxy", "encode failed:" + h.i(e4));
                this.myU = false;
            }
        }
        h.log(4, "VideoProxy", "getUrl, url:" + str + ", proxyUrl:" + str6);
        AppMethodBeat.o(234807);
        return str6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x04a8 A[Catch:{ all -> 0x08df }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0556 A[Catch:{ all -> 0x05b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x05b7 A[SYNTHETIC, Splitter:B:161:0x05b7] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x05bc A[SYNTHETIC, Splitter:B:164:0x05bc] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x07c4  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0826  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.vfs.o a(com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e r33, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g r34, java.lang.String r35, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n r36) {
        /*
        // Method dump skipped, instructions count: 2317
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m.a(com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g, java.lang.String, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n):com.tencent.mm.vfs.o");
    }

    /* access modifiers changed from: package-private */
    public final class a {
        boolean ZB;
        long mzh;
        e mzi;
        o mzj;

        private a() {
            this.mzh = -1;
            this.ZB = false;
            this.mzi = null;
            this.mzj = null;
        }

        /* synthetic */ a(m mVar, byte b2) {
            this();
        }
    }

    private a a(e eVar, g gVar, String str, String str2, n nVar, Socket socket, String str3) {
        AppMethodBeat.i(234809);
        a aVar = new a(this, (byte) 0);
        aVar.mzh = 0;
        h.log(4, str2, "openDataSource, dataSpec=" + gVar.toString());
        if (!h.aaW(str)) {
            eVar.a(gVar);
        } else {
            o oVar = null;
            try {
                if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxr != null) {
                    oVar = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxr.dU(str);
                }
                if (oVar == null || !oVar.exists()) {
                    aVar.mzj = a(eVar, gVar, str, nVar);
                } else {
                    aVar.mzj = oVar;
                }
                if (aVar.mzj != null) {
                    h.log(4, str2, "openDataSource, localPlaylist generate success:" + aVar.mzj.toString());
                    AnonymousClass2 r19 = new k() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k
                        public final c bJP() {
                            AppMethodBeat.i(234802);
                            c abd = c.abd(com.tencent.mm.plugin.appbrand.jsapi.video.b.e.c.mzM);
                            AppMethodBeat.o(234802);
                            return abd;
                        }
                    };
                    r19.a(new g(Uri.fromFile(new File(s.k(aa.z(aVar.mzj.mUri), false))), gVar.bEP, gVar.position, gVar.length, gVar.key, gVar.flags, gVar.uuid, gVar.priority));
                    aVar.mzi = r19;
                } else {
                    if (nVar.priority == 90) {
                        aVar.mzh = h.G(18, -99999);
                        if (this.myY.get(str3) != null) {
                            new HashMap();
                            System.currentTimeMillis();
                        }
                    }
                    h.log(4, str2, "openDataSource, localPlaylist generate fail, see previous logs");
                    try {
                        socket.close();
                    } catch (IOException e2) {
                        h.a(6, str2, "openDataSource, socket close exception", e2);
                    }
                    this.myX.a(nVar);
                    if (nVar.xB(2)) {
                        nVar.xA(256);
                        h.log(4, str2, "openDataSource, videoRequest is interrupted:".concat(String.valueOf(nVar)));
                        nVar.bJW();
                    } else {
                        nVar.xA(CdnLogic.kAppTypeFestivalImage);
                    }
                    nVar.ifP = true;
                    aVar.ZB = true;
                    AppMethodBeat.o(234809);
                    return aVar;
                }
            } catch (g e3) {
                int i2 = 0;
                h.log(6, "VideoProxy/" + nVar.mzr, "openDataSource, localPlaylist generate livePlayListException ".concat(String.valueOf(e3)));
                if (e3.getCause() == null) {
                    i2 = 16;
                } else if (!(e3.getCause() instanceof l.b) && !(e3.getCause() instanceof l.c)) {
                    i2 = 17;
                }
                if (nVar.priority == 90 && i2 != 0) {
                    aVar.mzh = h.G((long) i2, -99999);
                    if (this.myY.get(str3) != null) {
                        System.currentTimeMillis();
                        new HashMap();
                    }
                }
                try {
                    socket.close();
                } catch (IOException e4) {
                    h.a(6, str2, "openDataSource, socket close exception", e4);
                }
                this.myX.a(nVar);
                if (nVar.xB(2)) {
                    nVar.xA(256);
                    h.log(4, str2, "openDataSource, videoRequest is interrupted:".concat(String.valueOf(nVar)));
                    nVar.bJW();
                } else {
                    nVar.xA(CdnLogic.kAppTypeFestivalImage);
                }
                nVar.ifP = true;
                aVar.ZB = true;
                AppMethodBeat.o(234809);
                return aVar;
            }
        }
        AppMethodBeat.o(234809);
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02df, code lost:
        r20 = r6.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02e7, code lost:
        if (com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.aaW(r40) == false) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02e9, code lost:
        r21 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02eb, code lost:
        r8 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.f.a(r0, r0, r18, r20, r21);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02f7, code lost:
        if (r6.equals(com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.myu) != false) goto L_0x02f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02f9, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, r31, "file type should not be unknown");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0302, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, r31, "write response, responseCode 416, totalLength=" + r28 + ", send response headers: " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.abs(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r33.write(r8.getBytes(com.tencent.mm.sdk.system.MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        r33.flush();
        r33.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x033b, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x033c, code lost:
        if (r5 != null) goto L_0x033e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x033e, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, r31, "uri:" + r42.eby + ", InvalidResponseCode: \r\n" + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.f.T(r0.bFD));
        r8 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.U(r0.bFD);
        r10 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.G((long) r0.responseCode, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0376, code lost:
        r4 = r5;
        r24 = r8;
        r18 = r10;
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0386, code lost:
        r42.bJX();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r39.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0405, code lost:
        if (r13.delete() == false) goto L_0x0407;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0407, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "write response, delete PlayListFile failed:" + r13.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0421, code lost:
        r8 = r4;
        r20 = r24;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0569, code lost:
        r42.bJX();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x05e3, code lost:
        if (r8.delete() == false) goto L_0x05e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x05e5, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "write response, delete PlayListFile failed:" + r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x05ff, code lost:
        r8 = r4;
        r20 = -99999;
        r18 = r10;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x06de, code lost:
        r21 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x06e2, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x06e3, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(4, r31, "write response, workaround 416 error ", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:?, code lost:
        r39.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0793, code lost:
        if ((r5 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.e) != false) goto L_0x0795;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0795, code lost:
        r0 = (com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.e) r5;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, r31, "uri:" + r42.eby + ", InvalidContentType: \r\n" + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.f.T(r0.bFD));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x07ca, code lost:
        if (r42.priority == 90) goto L_0x07cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x07cc, code lost:
        r24 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.U(r0.bFD);
        r10 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.G(3, r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x07da, code lost:
        r4 = r5;
        r18 = r10;
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x07e3, code lost:
        if ((r5 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.d) != false) goto L_0x07e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x07e5, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, r31, "uri:" + r42.eby + ", InvalidContent");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x080c, code lost:
        if (r42.priority == 90) goto L_0x080e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x080e, code lost:
        r4 = r5;
        r18 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.G(10, -99999);
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0820, code lost:
        if ((r5 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.g) != false) goto L_0x0822;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0822, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, r31, "uri:" + r42.eby + ", MalformedResponse");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0849, code lost:
        if (r42.priority == 90) goto L_0x084b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x084b, code lost:
        r4 = r5;
        r18 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.G(12, -99999);
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x085d, code lost:
        if ((r5 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.b) != false) goto L_0x085f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x085f, code lost:
        r42.xA(256);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "uri:" + r42.eby + " connect to server interrupted");
        r4 = r5;
        r18 = r10;
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0892, code lost:
        if ((r5 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.c) != false) goto L_0x0894;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0894, code lost:
        r42.xA(256);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "uri:" + r42.eby + " read interrupted");
        r4 = r5;
        r18 = r10;
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x08c7, code lost:
        if ((r5 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.h) != false) goto L_0x08c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x08c9, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "uri:" + r42.eby + ", unable to connect server: " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x08f8, code lost:
        if (r42.priority == 90) goto L_0x08fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x08fe, code lost:
        if ((r7 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c) != false) goto L_0x0900;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0900, code lost:
        r4 = ((com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c) r7).mxC;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0908, code lost:
        if ((r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j) != false) goto L_0x090a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x090a, code lost:
        r4 = ((com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j) r4).mxt;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x090e, code lost:
        if (r4 == null) goto L_0x0c47;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0927, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0928, code lost:
        if (r4 != false) goto L_0x092a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x092a, code lost:
        r4 = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x092c, code lost:
        r4 = r5;
        r18 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.G((long) r4, -99999);
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x093b, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, r31, "write response, cacheDataSource error:".concat(java.lang.String.valueOf(r7)));
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0950, code lost:
        if ((r7 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j) != false) goto L_0x0952;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0952, code lost:
        r4 = ((com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j) r7).mxt;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x095d, code lost:
        if (com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.isNetworkAvailable() != false) goto L_0x095f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x095f, code lost:
        r4 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0961, code lost:
        r4 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0966, code lost:
        if ((r5 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.a) != false) goto L_0x0968;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0968, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "uri:" + r42.eby + ", read upstream error1: " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0997, code lost:
        if (r42.priority == 90) goto L_0x0999;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0999, code lost:
        r4 = r5;
        r18 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.G((long) h(r5), -99999);
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x09ae, code lost:
        if ((r7 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k) == false) goto L_0x09f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x09b4, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "uri:" + r42.eby + ", read upstream error2: " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x09e3, code lost:
        if (r42.priority == 90) goto L_0x09e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x09e5, code lost:
        r4 = r5;
        r18 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.G(1404, -99999);
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x09f7, code lost:
        if ((r5 instanceof java.net.NoRouteToHostException) != false) goto L_0x09f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x09f9, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "uri:" + r42.eby + ", read upstream error3: " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0a28, code lost:
        if (r42.priority == 90) goto L_0x0a2a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0a2a, code lost:
        r4 = r5;
        r18 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.G(1, -99999);
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0a3c, code lost:
        if ((r5 instanceof java.io.InterruptedIOException) != false) goto L_0x0a3e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0a3e, code lost:
        r42.xA(256);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, r31, "uri:" + r42.eby + " is interrupted by system");
        r4 = r5;
        r18 = r10;
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0a73, code lost:
        if (r38.aFC != false) goto L_0x0a75;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0a75, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "response interrupted, proxy server has shutdown");
        r4 = r5;
        r18 = r10;
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x0a90, code lost:
        if (r5.getMessage().matches("(?i)^.*((ECONNRESET)|(EPIPE)|(reset)).*$") != false) goto L_0x0a92;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0a92, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "response interrupted, client closed connection");
        r4 = r5;
        r18 = r10;
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x0aad, code lost:
        if (r5.toString().contains("write byteCount err") != false) goto L_0x0aaf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x0aaf, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "response interrupted, socket write byteCount err");
        r4 = r5;
        r18 = r10;
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x0abf, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, r31, "uri:" + r42 + ", error occurred while sending data " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x0ae6, code lost:
        r4 = r5;
        r18 = r10;
        r6 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x0af9, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0afa, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(5, r31, "write response, socket close failed", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0b1d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x0b1e, code lost:
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(5, r31, "write response, socket close failed", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0bc8, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0bc9, code lost:
        r9 = r4;
        r8 = null;
        r10 = null;
        r7 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0bd7, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0bd8, code lost:
        r9 = r4;
        r10 = null;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x0bf1, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x0bf2, code lost:
        r8 = null;
        r10 = 0;
        r5 = true;
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x0c0a, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x0c0b, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x0c0f, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0c10, code lost:
        r13 = null;
        r10 = 0;
        r15 = r27;
        r7 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x0c29, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x0c2a, code lost:
        r13 = r8;
        r15 = r27;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0c47, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0c4a, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x0c4d, code lost:
        r8 = -99999;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x0c51, code lost:
        r6 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0287, code lost:
        r0 = (com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.f) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0291, code lost:
        if (r42.priority == 90) goto L_0x0293;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0297, code lost:
        if (r0.responseCode == 416) goto L_0x0299;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0299, code lost:
        r18 = -1;
        r8 = r38.myX.bP(r12, -1).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02ac, code lost:
        if (r8.hasNext() != false) goto L_0x02ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02ae, code lost:
        r6 = r8.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02ba, code lost:
        if (r6.equals(r42) != false) goto L_0x02a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02c6, code lost:
        r18 = r6.getTotalLength();
        r6 = r6.bJP();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0386 A[Catch:{ all -> 0x0be5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03c0 A[SYNTHETIC, Splitter:B:129:0x03c0] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0569 A[Catch:{ all -> 0x0beb }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x05df  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0729 A[SYNTHETIC, Splitter:B:225:0x0729] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0791  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x0b29  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0b34  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0bc8 A[ExcHandler: all (r4v14 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:15:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0bd7 A[ExcHandler: all (r4v138 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:39:0x0147] */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x0c0a A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:39:0x0147] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0287 A[Catch:{ all -> 0x06ee }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.net.Socket r39, java.lang.String r40, java.io.OutputStream r41, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n r42) {
        /*
        // Method dump skipped, instructions count: 3165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m.a(java.net.Socket, java.lang.String, java.io.OutputStream, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n):void");
    }

    private static int h(Throwable th) {
        int i2;
        AppMethodBeat.i(234811);
        if (th.toString().toLowerCase().contains("unexpected end of stream")) {
            i2 = 6;
        } else if (th.getCause() == null || !(th.getCause() instanceof SocketTimeoutException)) {
            i2 = 7;
        } else {
            i2 = 14;
        }
        AppMethodBeat.o(234811);
        return i2;
    }

    public final long aba(String str) {
        AppMethodBeat.i(234812);
        if (TextUtils.isEmpty(str) || this.mxs == null) {
            AppMethodBeat.o(234812);
            return 0;
        }
        long aba = this.mxs.aba(h.abl(str));
        AppMethodBeat.o(234812);
        return aba;
    }

    static /* synthetic */ void a(m mVar) {
        String str;
        String str2;
        ExecutorService executorService2;
        String str3;
        String str4;
        AppMethodBeat.i(234813);
        h.log(3, "VideoProxy", "proxy server wait for request");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = mVar.serverSocket.accept();
                CountDownLatch countDownLatch = new CountDownLatch(1);
                b bVar = new b(accept, countDownLatch);
                Future<?> submit = mVar.executorService.submit(bVar);
                m.b bVar2 = (m.b) mVar.executorService;
                ((ThreadPoolExecutor) mVar.executorService).setCorePoolSize(bVar2.getActiveCount() + bVar2.getQueue().size() + 2);
                bVar.mzk = submit;
                countDownLatch.countDown();
            } catch (SocketException e2) {
                if (mVar.serverSocket.isClosed()) {
                    h.log(3, "VideoProxy", "proxy server is closed");
                } else {
                    h.log(6, "VideoProxy", "proxy server is quit, reason SOCKET:" + h.i(e2));
                }
                return;
            } catch (IOException e3) {
                h.log(6, "VideoProxy", "proxy server is quit, reason IO:" + h.i(e3));
                return;
            } catch (OutOfMemoryError e4) {
                h.log(6, "VideoProxy", "proxy server is quit, reason OOM:" + h.i(e4));
                return;
            } finally {
                h.log(3, "VideoProxy", "shutdown thread pool");
                mVar.executorService.shutdownNow();
                h.log(3, "VideoProxy", "proxy server stopped");
                AppMethodBeat.o(234813);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m r28, java.net.Socket r29, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n r30) {
        /*
        // Method dump skipped, instructions count: 661
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m.a(com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m, java.net.Socket, com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n):void");
    }
}
