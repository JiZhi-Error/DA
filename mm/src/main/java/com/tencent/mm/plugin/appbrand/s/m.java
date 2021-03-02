package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;

public final class m {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    public f lqg;
    public String mGo;
    private boolean mgB = false;
    public int nhP;
    private String nhQ = (b.aKM() + "appbrand/");
    public SSLContext nhR;
    protected final ArrayList<String> nhS = new ArrayList<>();
    public final ArrayList<com.tencent.mm.plugin.appbrand.s.a.b> nhU = new ArrayList<>();
    private final Map<String, ConcurrentLinkedQueue<b.a>> niQ;
    public final Map<String, a> niR;
    public final ConcurrentLinkedQueue<com.tencent.mm.plugin.appbrand.s.a.b> niS = new ConcurrentLinkedQueue<>();

    public m(f fVar, boolean z) {
        AppMethodBeat.i(144431);
        this.lqg = fVar;
        this.nhP = Integer.MAX_VALUE;
        this.niQ = new Hashtable(10);
        this.niR = new HashMap();
        this.mgB = z;
        AppMethodBeat.o(144431);
    }

    public final Boolean adi(String str) {
        Boolean valueOf;
        AppMethodBeat.i(207109);
        synchronized (this.niR) {
            try {
                valueOf = Boolean.valueOf(this.niR.containsKey(str));
            } finally {
                AppMethodBeat.o(207109);
            }
        }
        return valueOf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0082, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0089, code lost:
        if (r14.niQ.get(r4) != null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008b, code lost:
        r2 = new java.util.concurrent.ConcurrentLinkedQueue<>();
        r2.offer(r20);
        r14.niQ.put(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x009a, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009b, code lost:
        r2 = new com.tencent.mm.plugin.appbrand.s.a.b(r14.lqg, r4, r5, r15.optString("filePath"), r14.mGo, r14.mgB, r15.optBoolean("enableHttp2", false), r15.optBoolean("enableQuic", false), r15.optBoolean("enableCache", false), r15.optBoolean("enableProfile", true), new com.tencent.mm.plugin.appbrand.s.m.AnonymousClass2(r14));
        r2.njn = r17;
        r2.timeout = r16;
        r2.isRunning = true;
        r2.nis = r18;
        r2.njo = r19;
        r2.nhR = r14.nhR;
        r2.jEY = r21;
        r2.nix = r22;
        r3 = r14.nhU;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00f7, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0100, code lost:
        if (r14.nhU.size() < r14.nhP) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0102, code lost:
        r4 = r14.niS;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0104, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r14.niS.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x010a, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x010b, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011d, code lost:
        r2 = r14.niQ.get(r4);
        r2.offer(r20);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "predownload the same task is working url:%s,size:%d", r4, java.lang.Integer.valueOf(r2.size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0144, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0145, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(144432);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x014d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x014f, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(144432);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0155, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0156, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0158, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(144432);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x015e, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x015f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0161, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(144432);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0167, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0168, code lost:
        r14.nhU.add(r2);
        com.tencent.mm.sdk.thread.ThreadPool.post(r2, "appbrand_predownload_thread");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0173, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0174, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(144432);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005e, code lost:
        r5 = r14.nhQ + com.tencent.mm.sdk.platformtools.MD5Util.getMD5String(r11) + "temp";
        r4 = com.tencent.mm.plugin.appbrand.s.j.adg(r11);
        r3 = r14.niQ;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(org.json.JSONObject r15, int r16, java.util.Map<java.lang.String, java.lang.String> r17, java.util.ArrayList<java.lang.String> r18, int r19, final com.tencent.mm.plugin.appbrand.s.b.a r20, final java.lang.String r21, java.lang.String r22) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.m.a(org.json.JSONObject, int, java.util.Map, java.util.ArrayList, int, com.tencent.mm.plugin.appbrand.s.b$a, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String filePath;
        String mimeType;
        long niU;
        int statusCode;
        String url;

        public a(String str, String str2, String str3, int i2, long j2) {
            this.filePath = str;
            this.mimeType = str2;
            this.url = str3;
            this.statusCode = i2;
            this.niU = j2;
        }
    }

    static /* synthetic */ void a(m mVar, String str) {
        AppMethodBeat.i(207110);
        if (str != null) {
            synchronized (mVar.nhU) {
                try {
                    Iterator<com.tencent.mm.plugin.appbrand.s.a.b> it = mVar.nhU.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.tencent.mm.plugin.appbrand.s.a.b next = it.next();
                        if (str.equals(next.jEY)) {
                            mVar.nhU.remove(next);
                            break;
                        }
                    }
                    if (mVar.nhU.size() < mVar.nhP && mVar.niS.peek() != null) {
                        com.tencent.mm.plugin.appbrand.s.a.b poll = mVar.niS.poll();
                        mVar.nhU.add(poll);
                        ThreadPool.post(poll, "appbrand_preload_download_thread");
                    }
                } finally {
                    AppMethodBeat.o(207110);
                }
            }
            return;
        }
        AppMethodBeat.o(207110);
    }
}
