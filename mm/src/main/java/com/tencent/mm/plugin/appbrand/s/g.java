package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class g {
    f lqg;
    final String mGo;
    SSLContext nhR;
    protected final ArrayList<String> nhS = new ArrayList<>();
    private int niC;
    private final ArrayList<h> niD = new ArrayList<>();

    public interface a {
        void J(JSONObject jSONObject);

        void aat(String str);

        void i(int i2, long j2, long j3);

        void j(int i2, String str, int i3);
    }

    public g(f fVar) {
        AppMethodBeat.i(144347);
        this.lqg = fVar;
        a aVar = (a) fVar.av(a.class);
        this.niC = aVar.cyL;
        this.mGo = aVar.nhM;
        this.nhR = j.a(aVar);
        AppMethodBeat.o(144347);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0060, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0062, code lost:
        r17.aat("fileName error");
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
        com.tencent.matrix.trace.core.AppMethodBeat.o(144348);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0083, code lost:
        r1 = new com.tencent.mm.plugin.appbrand.s.h(r13, r3, r4, r20, r11, r12, r17);
        r1.niH = r9;
        r1.jEZ = r15;
        r1.nis = r16;
        r1.isRunning = true;
        r1.jEY = r18;
        r1.nix = r19;
        r2 = r10.niD;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a4, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r10.niD.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00aa, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ab, code lost:
        com.tencent.mm.sdk.thread.ThreadPool.post(new com.tencent.mm.plugin.appbrand.s.g.b(r10, r1), "appbrand_upload_thread");
        com.tencent.matrix.trace.core.AppMethodBeat.o(144348);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00bd, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bf, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(144348);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c5, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, java.lang.String r12, java.lang.String r13, org.json.JSONObject r14, java.util.Map<java.lang.String, java.lang.String> r15, java.util.ArrayList<java.lang.String> r16, com.tencent.mm.plugin.appbrand.s.g.a r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.g.a(int, java.lang.String, java.lang.String, org.json.JSONObject, java.util.Map, java.util.ArrayList, com.tencent.mm.plugin.appbrand.s.g$a, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private void EN(String str) {
        AppMethodBeat.i(144349);
        if (str == null) {
            AppMethodBeat.o(144349);
            return;
        }
        synchronized (this.niD) {
            try {
                Iterator<h> it = this.niD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (str.equals(next.jEY)) {
                        this.niD.remove(next);
                        break;
                    }
                }
            } finally {
                AppMethodBeat.o(144349);
            }
        }
    }

    public final h ada(String str) {
        AppMethodBeat.i(144350);
        if (str == null) {
            AppMethodBeat.o(144350);
            return null;
        }
        synchronized (this.niD) {
            try {
                Iterator<h> it = this.niD.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (str.equals(next.jEY)) {
                        return next;
                    }
                }
                AppMethodBeat.o(144350);
                return null;
            } finally {
                AppMethodBeat.o(144350);
            }
        }
    }

    public final void a(h hVar) {
        AppMethodBeat.i(144351);
        if (hVar == null) {
            AppMethodBeat.o(144351);
            return;
        }
        this.nhS.add(hVar.jEY);
        hVar.isRunning = false;
        a(hVar.jEY, hVar.niv);
        AppMethodBeat.o(144351);
    }

    public final boolean acT(String str) {
        AppMethodBeat.i(144352);
        boolean contains = this.nhS.contains(str);
        AppMethodBeat.o(144352);
        return contains;
    }

    public class b implements Runnable {
        private h niE;

        public b(h hVar) {
            this.niE = hVar;
        }

        public final void run() {
            AppMethodBeat.i(144344);
            b(this.niE);
            AppMethodBeat.o(144344);
        }

        private static String dl(String str, String str2) {
            AppMethodBeat.i(144345);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(144345);
                return str2;
            }
            AppMethodBeat.o(144345);
            return str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:193:0x09f0, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x09f1, code lost:
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r3, "getInputStream error", new java.lang.Object[0]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0a08, code lost:
            if ("gzip".equals(r23.getContentEncoding()) != false) goto L_0x0a0a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0a0a, code lost:
            r25 = new java.util.zip.GZIPInputStream(r23.getErrorStream());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0a26, code lost:
            r25 = r23.getErrorStream();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:348:0x1049, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:349:0x104a, code lost:
            r25 = null;
            r26 = null;
            r8 = 0;
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:352:0x105d, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:353:0x105e, code lost:
            r25 = null;
            r12 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:366:0x1091, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:367:0x1092, code lost:
            r11 = r3;
            r25 = null;
            r26 = null;
            r23 = null;
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:372:0x10af, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:373:0x10b0, code lost:
            r11 = r3;
            r25 = null;
            r28 = r8;
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:382:0x10df, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:383:0x10e0, code lost:
            r11 = r3;
            r25 = null;
            r26 = null;
            r23 = null;
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:388:0x10fd, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:389:0x10fe, code lost:
            r11 = r3;
            r25 = null;
            r28 = r8;
            r12 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:400:0x113b, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:401:0x113c, code lost:
            r11 = r3;
            r25 = null;
            r26 = null;
            r23 = null;
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:404:0x114f, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:405:0x1150, code lost:
            r11 = r3;
            r25 = null;
            r28 = r8;
            r12 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:416:0x118d, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:417:0x118e, code lost:
            r11 = r3;
            r25 = null;
            r26 = null;
            r23 = null;
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:420:0x11a1, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:421:0x11a2, code lost:
            r11 = r3;
            r25 = null;
            r28 = r8;
            r12 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:432:0x11e1, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:433:0x11e2, code lost:
            r11 = r3;
            r17 = r24;
            r18 = null;
            r19 = null;
            r23 = null;
            r12 = 0;
            r22 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:436:0x11ff, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:437:0x1200, code lost:
            r11 = r3;
            r17 = r24;
            r18 = null;
            r19 = r26;
            r28 = r8;
            r12 = r21;
            r22 = 0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:273:0x0d6e  */
        /* JADX WARNING: Removed duplicated region for block: B:276:0x0d9a A[SYNTHETIC, Splitter:B:276:0x0d9a] */
        /* JADX WARNING: Removed duplicated region for block: B:279:0x0d9f A[SYNTHETIC, Splitter:B:279:0x0d9f] */
        /* JADX WARNING: Removed duplicated region for block: B:282:0x0da4 A[SYNTHETIC, Splitter:B:282:0x0da4] */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0ea7  */
        /* JADX WARNING: Removed duplicated region for block: B:302:0x0ed3 A[SYNTHETIC, Splitter:B:302:0x0ed3] */
        /* JADX WARNING: Removed duplicated region for block: B:305:0x0ed8 A[SYNTHETIC, Splitter:B:305:0x0ed8] */
        /* JADX WARNING: Removed duplicated region for block: B:308:0x0edd A[SYNTHETIC, Splitter:B:308:0x0edd] */
        /* JADX WARNING: Removed duplicated region for block: B:325:0x0f98  */
        /* JADX WARNING: Removed duplicated region for block: B:328:0x0fc4 A[SYNTHETIC, Splitter:B:328:0x0fc4] */
        /* JADX WARNING: Removed duplicated region for block: B:331:0x0fc9 A[SYNTHETIC, Splitter:B:331:0x0fc9] */
        /* JADX WARNING: Removed duplicated region for block: B:334:0x0fce A[SYNTHETIC, Splitter:B:334:0x0fce] */
        /* JADX WARNING: Removed duplicated region for block: B:348:0x1049 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:16:0x018a] */
        /* JADX WARNING: Removed duplicated region for block: B:352:0x105d A[ExcHandler: all (th java.lang.Throwable), PHI: r21 
          PHI: (r21v5 int) = (r21v0 int), (r21v6 int), (r21v6 int) binds: [B:112:0x06c3, B:178:0x09a3, B:195:0x0a00] A[DONT_GENERATE, DONT_INLINE], Splitter:B:112:0x06c3] */
        /* JADX WARNING: Removed duplicated region for block: B:388:0x10fd A[ExcHandler: SocketTimeoutException (r3v163 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), PHI: r21 
          PHI: (r21v4 int) = (r21v0 int), (r21v6 int), (r21v6 int) binds: [B:112:0x06c3, B:178:0x09a3, B:195:0x0a00] A[DONT_GENERATE, DONT_INLINE], Splitter:B:112:0x06c3] */
        /* JADX WARNING: Removed duplicated region for block: B:404:0x114f A[ExcHandler: SSLHandshakeException (r3v162 'e' javax.net.ssl.SSLHandshakeException A[CUSTOM_DECLARE]), PHI: r21 
          PHI: (r21v3 int) = (r21v0 int), (r21v6 int), (r21v6 int) binds: [B:112:0x06c3, B:178:0x09a3, B:195:0x0a00] A[DONT_GENERATE, DONT_INLINE], Splitter:B:112:0x06c3] */
        /* JADX WARNING: Removed duplicated region for block: B:420:0x11a1 A[ExcHandler: FileNotFoundException (r3v161 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), PHI: r21 
          PHI: (r21v2 int) = (r21v0 int), (r21v6 int), (r21v6 int) binds: [B:112:0x06c3, B:178:0x09a3, B:195:0x0a00] A[DONT_GENERATE, DONT_INLINE], Splitter:B:112:0x06c3] */
        /* JADX WARNING: Removed duplicated region for block: B:436:0x11ff A[ExcHandler: UnsupportedEncodingException (r3v160 'e' java.io.UnsupportedEncodingException A[CUSTOM_DECLARE]), PHI: r21 
          PHI: (r21v1 int) = (r21v0 int), (r21v6 int), (r21v6 int) binds: [B:112:0x06c3, B:178:0x09a3, B:195:0x0a00] A[DONT_GENERATE, DONT_INLINE], Splitter:B:112:0x06c3] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x032a  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0356 A[SYNTHETIC, Splitter:B:50:0x0356] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x035b A[SYNTHETIC, Splitter:B:53:0x035b] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0360 A[SYNTHETIC, Splitter:B:56:0x0360] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0400  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x042c A[SYNTHETIC, Splitter:B:70:0x042c] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x0431 A[SYNTHETIC, Splitter:B:73:0x0431] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0436 A[SYNTHETIC, Splitter:B:76:0x0436] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x057a  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x05a6 A[SYNTHETIC, Splitter:B:92:0x05a6] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x05ab A[SYNTHETIC, Splitter:B:95:0x05ab] */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x05b0 A[SYNTHETIC, Splitter:B:98:0x05b0] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(com.tencent.mm.plugin.appbrand.s.h r36) {
            /*
            // Method dump skipped, instructions count: 4683
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.g.b.b(com.tencent.mm.plugin.appbrand.s.h):void");
        }
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(144353);
        EN(str);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
                httpURLConnection.disconnect();
                AppMethodBeat.o(144353);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e2, "removeTask Exception: id %s", str);
            }
        }
        AppMethodBeat.o(144353);
    }

    public final void release() {
        AppMethodBeat.i(259486);
        synchronized (this.niD) {
            try {
                Iterator<h> it = this.niD.iterator();
                while (it.hasNext()) {
                    it.next().isRunning = false;
                }
                this.niD.clear();
            } finally {
                AppMethodBeat.o(259486);
            }
        }
    }

    static /* synthetic */ void a(g gVar, a aVar, String str, String str2, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(144354);
        gVar.a(str2, httpURLConnection);
        aVar.aat(str);
        AppMethodBeat.o(144354);
    }

    static /* synthetic */ void a(g gVar, a aVar, int i2, String str, int i3, String str2, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(144355);
        gVar.a(str2, httpURLConnection);
        aVar.j(i2, str, i3);
        AppMethodBeat.o(144355);
    }
}
