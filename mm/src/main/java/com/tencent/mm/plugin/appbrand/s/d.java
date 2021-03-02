package com.tencent.mm.plugin.appbrand.s;

import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class d {
    final WeakReference<f> cAG;
    private final String mGo;
    int mgi = com.tencent.mm.plugin.appbrand.jsapi.o.b.a.mgg;
    private SSLContext nhR;
    public final ArrayList<e> nia = new ArrayList<>();
    public final Set<String> nib = new ConcurrentSkipListSet();
    public final Set<String> nic = new ConcurrentSkipListSet();
    int nid;
    final String nie;
    boolean nif = false;
    boolean nig = false;

    public interface a {
        void J(JSONObject jSONObject);

        void a(String str, Object obj, int i2, JSONObject jSONObject, Map map);

        void dC(String str, String str2);
    }

    public interface b {
        boolean btA();

        boolean btB();

        boolean btz();
    }

    static /* synthetic */ void a(d dVar, a aVar, String str, Object obj, int i2, JSONObject jSONObject, String str2, Map map) {
        AppMethodBeat.i(175393);
        dVar.a(aVar, str, obj, i2, jSONObject, str2, (HttpURLConnection) null, map);
        AppMethodBeat.o(175393);
    }

    static /* synthetic */ void a(d dVar, a aVar, String str, String str2, String str3) {
        AppMethodBeat.i(144334);
        dVar.a(aVar, str, str2, str3, (HttpURLConnection) null);
        AppMethodBeat.o(144334);
    }

    public d(f fVar, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(144320);
        this.cAG = new WeakReference<>(fVar);
        this.nie = Util.nullAsNil(fVar.getAppId());
        a aVar = (a) fVar.av(a.class);
        if (aVar == null) {
            Log.e("MicroMsg.AppBrandNetworkRequest", "<init> hy: config not found, appId(%s)", fVar.getAppId());
            this.mGo = "";
            AppMethodBeat.o(144320);
            return;
        }
        this.nid = aVar.cyK;
        this.mGo = aVar.nhM;
        this.nhR = j.a(aVar);
        this.mgi = i2;
        this.nif = z;
        this.nig = z2;
        AppMethodBeat.o(144320);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x08a9, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x08aa, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandNetworkRequest", "lm:read input stream failed : %s", r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x08c8, code lost:
        if ("gzip".equals(r21.getContentEncoding()) != false) goto L_0x08ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x08ca, code lost:
        r23 = new java.util.zip.GZIPInputStream(r21.getErrorStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x08d7, code lost:
        r23 = r21.getErrorStream();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x08dd, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x08de, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r2, "lm:read err stream failed", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x08ec, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x08ed, code lost:
        r17 = r6;
        r14 = false;
        r15 = 0;
        r20 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x16a3, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x16a4, code lost:
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x16fa, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x16fb, code lost:
        r17 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x1722, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x1723, code lost:
        r17 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:427:0x174a, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x174b, code lost:
        r17 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:439:0x1772, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:440:0x1773, code lost:
        r17 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x179a, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:452:0x179b, code lost:
        r17 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:463:0x17c2, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:464:0x17c3, code lost:
        r17 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:475:0x17ea, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x17eb, code lost:
        r17 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x08ec A[ExcHandler: UnsupportedEncodingException (e java.io.UnsupportedEncodingException), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0a67  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0af3  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0bbe  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0c1c A[SYNTHETIC, Splitter:B:200:0x0c1c] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0c21 A[SYNTHETIC, Splitter:B:203:0x0c21] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0c4a  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0cf7  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0d52  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0db0 A[SYNTHETIC, Splitter:B:224:0x0db0] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0db5 A[SYNTHETIC, Splitter:B:227:0x0db5] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0dde  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0dff  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0e5b A[SYNTHETIC, Splitter:B:239:0x0e5b] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0e60 A[SYNTHETIC, Splitter:B:242:0x0e60] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0eb8  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0f83  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0fe1 A[SYNTHETIC, Splitter:B:265:0x0fe1] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0fe6 A[SYNTHETIC, Splitter:B:268:0x0fe6] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x100f  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x10da  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x1138 A[SYNTHETIC, Splitter:B:286:0x1138] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x113d A[SYNTHETIC, Splitter:B:289:0x113d] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x1166  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x1231  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x128f A[SYNTHETIC, Splitter:B:307:0x128f] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x1294 A[SYNTHETIC, Splitter:B:310:0x1294] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x12bd  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x1388  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x13e6 A[SYNTHETIC, Splitter:B:328:0x13e6] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x13eb A[SYNTHETIC, Splitter:B:331:0x13eb] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x1414  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x14ed  */
    /* JADX WARNING: Removed duplicated region for block: B:349:0x154b A[SYNTHETIC, Splitter:B:349:0x154b] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x1550 A[SYNTHETIC, Splitter:B:352:0x1550] */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x1579  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x1607  */
    /* JADX WARNING: Removed duplicated region for block: B:377:0x16a3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x16fa A[ExcHandler: UnknownHostException (e java.net.UnknownHostException), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x1722 A[ExcHandler: ArrayIndexOutOfBoundsException (e java.lang.ArrayIndexOutOfBoundsException), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x174a A[ExcHandler: ProtocolException (e java.net.ProtocolException), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0399 A[SYNTHETIC, Splitter:B:42:0x0399] */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x1772 A[ExcHandler: ConnectException (e java.net.ConnectException), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x179a A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x039e A[SYNTHETIC, Splitter:B:45:0x039e] */
    /* JADX WARNING: Removed duplicated region for block: B:463:0x17c2 A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x17ea A[ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException), Splitter:B:74:0x0509] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0480 A[SYNTHETIC, Splitter:B:58:0x0480] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0485 A[SYNTHETIC, Splitter:B:61:0x0485] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.s.e r27) {
        /*
        // Method dump skipped, instructions count: 6203
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.d.a(com.tencent.mm.plugin.appbrand.s.e):void");
    }

    private void a(a aVar, String str, String str2, String str3, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(144322);
        a(str3, httpURLConnection);
        aVar.dC(str, str2);
        AppMethodBeat.o(144322);
    }

    private void a(a aVar, String str, Object obj, int i2, JSONObject jSONObject, String str2, HttpURLConnection httpURLConnection, Map map) {
        AppMethodBeat.i(175392);
        a(str2, httpURLConnection);
        aVar.a(str, obj, i2, jSONObject, map);
        AppMethodBeat.o(175392);
    }

    public final void b(e eVar) {
        AppMethodBeat.i(207100);
        Log.i("MicroMsg.AppBrandNetworkRequest", "lm:try to abortTask taskId:%s, appId:%s", eVar.jEY, this.nie);
        this.nib.add(eVar.jEY);
        a(eVar.jEY, eVar.niv);
        if (!Util.isNullOrNil(eVar.niw)) {
            CronetLogic.cancelCronetTask(eVar.niw);
        }
        AppMethodBeat.o(207100);
    }

    public final boolean acW(String str) {
        AppMethodBeat.i(207101);
        if (!this.nic.contains(str)) {
            AppMethodBeat.o(207101);
            return false;
        }
        this.nib.add(str);
        AppMethodBeat.o(207101);
        return true;
    }

    public final boolean acT(String str) {
        AppMethodBeat.i(144325);
        boolean contains = this.nib.contains(str);
        AppMethodBeat.o(144325);
        return contains;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(144326);
        EN(str);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
                httpURLConnection.disconnect();
                AppMethodBeat.o(144326);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e2, "removeTask Exception: id %s", str);
            }
        }
        AppMethodBeat.o(144326);
    }

    /* access modifiers changed from: package-private */
    public final boolean acX(String str) {
        AppMethodBeat.i(144327);
        if ((this.mgi != com.tencent.mm.plugin.appbrand.jsapi.o.b.a.mgg || !this.nif) && (this.mgi != com.tencent.mm.plugin.appbrand.jsapi.o.b.a.mgh || !this.nig)) {
            if (str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("DELETE")) {
                AppMethodBeat.o(144327);
                return true;
            }
            AppMethodBeat.o(144327);
            return false;
        } else if (str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("DELETE") || str.equalsIgnoreCase("PATCH")) {
            AppMethodBeat.o(144327);
            return true;
        } else {
            AppMethodBeat.o(144327);
            return false;
        }
    }

    public final void a(final f fVar, final int i2, final JSONObject jSONObject, final Map<String, String> map, final ArrayList<String> arrayList, final a aVar, final String str, final String str2) {
        AppMethodBeat.i(144328);
        this.nic.add(str);
        final AnonymousClass3 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.s.d.AnonymousClass3 */

            /* JADX WARNING: Code restructure failed: missing block: B:37:0x0153, code lost:
                r6 = r14.optBoolean("enableHttp2", false);
                r7 = r14.optBoolean("enableQuic", false);
                r8 = r14.optBoolean("enableCache", false);
                r9 = r14.optBoolean("enableProfile", true);
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkRequest", "request taskId %s, method %s,timeout %s, useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b, url %s ", r18, r5, java.lang.Integer.valueOf(r13), java.lang.Boolean.valueOf(r6), java.lang.Boolean.valueOf(r7), java.lang.Boolean.valueOf(r8), java.lang.Boolean.valueOf(r9), r1);
                r0 = new com.tencent.mm.plugin.appbrand.s.e(r1, r2, r13, r17, r5, r6, r7, r8);
                r0.jEZ = r15;
                r0.nis = r16;
                r0.nix = r19;
                r0.niu = r14.optString("responseType", "text");
                r0.jFh = r6;
                r0.jFi = r7;
                r0.niz = r8;
                r0.niA = r9;
                r2 = r12.nij.nia;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x01e7, code lost:
                monitor-enter(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkRequest", "lm:request mRequestTaskList.add, appId(%s) taskId(%s)", r12.nij.nie, r18);
                r12.nij.nia.add(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x0207, code lost:
                monitor-exit(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x0208, code lost:
                r0.jEY = r18;
                com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandNetworkRequest", "lm:request %s ,url %s", r18, r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x0226, code lost:
                if (r12.nij.mgi != com.tencent.mm.plugin.appbrand.jsapi.o.b.a.mgg) goto L_0x022e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x022c, code lost:
                if (r12.nij.nif != false) goto L_0x023c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x0234, code lost:
                if (r12.nij.mgi != com.tencent.mm.plugin.appbrand.jsapi.o.b.a.mgh) goto L_0x025b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x023a, code lost:
                if (r12.nij.nig == false) goto L_0x025b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x023c, code lost:
                com.tencent.mm.plugin.appbrand.s.d.a(r12.nij, r0);
                com.tencent.matrix.trace.core.AppMethodBeat.o(144319);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:56:0x0252, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x0254, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(144319);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x025a, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:60:0x025b, code lost:
                r12.nij.a(r0);
                com.tencent.matrix.trace.core.AppMethodBeat.o(144319);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 616
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.d.AnonymousClass3.run():void");
            }
        };
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.s.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(175391);
                try {
                    r1.run();
                } finally {
                    d.this.nic.remove(str);
                    AppMethodBeat.o(175391);
                }
            }
        });
        AppMethodBeat.o(144328);
    }

    private synchronized void EN(String str) {
        AppMethodBeat.i(144329);
        Log.i("MicroMsg.AppBrandNetworkRequest", "lm:removeTask %s", str);
        if (str == null) {
            AppMethodBeat.o(144329);
        } else {
            synchronized (this.nia) {
                try {
                    Iterator<e> it = this.nia.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        e next = it.next();
                        if (str.equals(next.jEY)) {
                            Log.i("MicroMsg.AppBrandNetworkRequest", "lm:real removeTask %s", next.jEY);
                            this.nia.remove(next);
                            break;
                        }
                    }
                } finally {
                    AppMethodBeat.o(144329);
                }
            }
        }
    }

    public final e acY(String str) {
        AppMethodBeat.i(144330);
        if (str == null) {
            AppMethodBeat.o(144330);
            return null;
        }
        synchronized (this.nia) {
            try {
                Iterator<e> it = this.nia.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (str.equals(next.jEY)) {
                        return next;
                    }
                }
                AppMethodBeat.o(144330);
                return null;
            } finally {
                AppMethodBeat.o(144330);
            }
        }
    }

    static /* synthetic */ void c(e eVar) {
        AppMethodBeat.i(144331);
        if (eVar != null) {
            Runnable runnable = eVar.mRunnable;
            Log.i("MicroMsg.AppBrandNetworkRequest", "try to stop connectTimer");
            if (runnable != null) {
                if (runnable instanceof com.tencent.f.i.b) {
                    ((com.tencent.f.i.b) runnable).cancel();
                }
                eVar.mRunnable = null;
            }
        }
        AppMethodBeat.o(144331);
    }

    static /* synthetic */ void a(d dVar, final e eVar) {
        AppMethodBeat.i(144333);
        final a aVar = eVar.nir;
        ArrayList<String> arrayList = eVar.nis;
        final long currentTimeMillis = System.currentTimeMillis();
        if (arrayList == null || j.c(arrayList, eVar.mUrl)) {
            Log.d("MicroMsg.AppBrandNetworkRequest", "sendCronetRequest cronet http request matchurl time " + (System.currentTimeMillis() - currentTimeMillis));
            ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 0, 1, false);
            Log.i("MicroMsg.AppBrandNetworkRequest", "sendCronetRequest prepare to send https request taskid is %s, url is %s, method is %s, timeour is %d", eVar.jEY, eVar.mUrl, eVar.csu, Integer.valueOf(eVar.mTimeout));
            AnonymousClass1 r4 = new CronetLogic.CronetTaskCallback() {
                /* class com.tencent.mm.plugin.appbrand.s.d.AnonymousClass1 */

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public final int onCronetReceiveHeader(CronetLogic.ResponseHeader responseHeader, int i2) {
                    return 0;
                }

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public final void onCronetTaskCompleted(String str, CronetLogic.CronetTaskResult cronetTaskResult) {
                    Object afI;
                    AppMethodBeat.i(144316);
                    Log.i("MicroMsg.AppBrandNetworkRequest", "cronet onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s,fileKey:%s", Integer.valueOf(cronetTaskResult.errorCode), cronetTaskResult.errorMsg, Integer.valueOf(cronetTaskResult.statusCode), Long.valueOf(cronetTaskResult.totalReceiveByte), eVar.jEY, eVar.niw, str);
                    if (cronetTaskResult.webPageProfile != null) {
                        Log.i("MicroMsg.AppBrandNetworkRequest", "cronet onCronetTaskCompleted profile, protocol:%s, ip:%s, port:%d", cronetTaskResult.webPageProfile.protocol, cronetTaskResult.webPageProfile.peerIP, Integer.valueOf(cronetTaskResult.webPageProfile.port));
                    } else {
                        Log.i("MicroMsg.AppBrandNetworkRequest", "cronet profile is empty");
                    }
                    d.c(eVar);
                    if (cronetTaskResult.errorCode == 0) {
                        JSONObject c2 = j.c(cronetTaskResult.getHeaderMapList(), 2);
                        aVar.J(c2);
                        int i2 = cronetTaskResult.statusCode;
                        if (i2 != 200) {
                            Log.e("MicroMsg.AppBrandNetworkRequest", "cronet failed code: %d,url is %s", Integer.valueOf(i2), eVar.mUrl);
                            if (j.rS(i2)) {
                                String str2 = cronetTaskResult.newLocation;
                                int i3 = eVar.nit;
                                if (!TextUtils.isEmpty(str2)) {
                                    if (i3 <= 0) {
                                        Log.w("MicroMsg.AppBrandNetworkRequest", "cronet reach the max redirect count(%d)", 15);
                                        if (!eVar.niy) {
                                            eVar.niy = true;
                                            if (eVar.niA) {
                                                d.a(d.this, aVar, "ok", "reach the max redirect count 15", i2, c2, eVar.jEY, j.a(cronetTaskResult.webPageProfile));
                                            } else {
                                                d.a(d.this, aVar, "ok", "reach the max redirect count 15", i2, c2, eVar.jEY, (Map) null);
                                            }
                                        } else {
                                            Log.e("MicroMsg.AppBrandNetworkRequest", "cronet onC2CDownloadCompleted max redirect already callback");
                                        }
                                        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 1, 1, false);
                                        AppMethodBeat.o(144316);
                                        return;
                                    }
                                    Log.i("MicroMsg.AppBrandNetworkRequest", "cronet redirect(%d) URL(%s) to URL(%s)", Integer.valueOf(i3), eVar.mUrl, str2);
                                    eVar.mUrl = str2;
                                    eVar.nit = i3 - 1;
                                    Log.i("MicroMsg.AppBrandNetworkRequest", "cronet now redirect count = %d", Integer.valueOf(eVar.nit));
                                    d.a(d.this, eVar);
                                    AppMethodBeat.o(144316);
                                    return;
                                }
                            }
                            ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 3, 1, false);
                        }
                        if ("arraybuffer".equals(eVar.niu)) {
                            afI = x.aP(cronetTaskResult.data);
                        } else {
                            afI = y.afI(cronetTaskResult.getDataString());
                        }
                        if (!eVar.niy) {
                            eVar.niy = true;
                            if (eVar.niA) {
                                d.a(d.this, aVar, "ok", afI, cronetTaskResult.statusCode, c2, eVar.jEY, j.a(cronetTaskResult.webPageProfile));
                            } else {
                                d.a(d.this, aVar, "ok", afI, cronetTaskResult.statusCode, c2, eVar.jEY, (Map) null);
                            }
                        } else {
                            Log.e("MicroMsg.AppBrandNetworkRequest", "cronet onC2CDownloadCompleted if already callback");
                        }
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        Log.d("cronet request time", "request time is ".concat(String.valueOf(currentTimeMillis)));
                        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1098, 99, currentTimeMillis, false);
                        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 8, 1, false);
                        ((o) e.N(o.class)).a(d.this.nie, eVar.nix, eVar.csu, eVar.mUrl, eVar.getDataSize(), cronetTaskResult.totalReceiveByte, i2, 1, eVar.bPz(), "", "");
                    } else {
                        if (!eVar.niy) {
                            eVar.niy = true;
                            d.a(d.this, aVar, "fail", cronetTaskResult.errorCode + ":" + cronetTaskResult.errorMsg, eVar.jEY);
                        } else {
                            Log.e("MicroMsg.AppBrandNetworkRequest", "onC2CDownloadCompleted else already callback");
                        }
                        ((o) e.N(o.class)).a(d.this.nie, eVar.nix, eVar.csu, eVar.mUrl, eVar.getDataSize(), 0, 0, 2, eVar.bPz(), "", "");
                        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 5, 1, false);
                        int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
                        if (netType == -1) {
                            ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 4, 1, false);
                        }
                        Log.i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d,url:%s", Integer.valueOf(netType), eVar.mUrl);
                    }
                    d.this.nib.remove(eVar.jEY);
                    AppMethodBeat.o(144316);
                }

                @Override // com.tencent.mars.cdn.CronetLogic.CronetTaskCallback
                public final void onDownloadProgressChanged(String str, CronetLogic.CronetDownloadProgress cronetDownloadProgress) {
                    AppMethodBeat.i(144317);
                    f fVar = d.this.cAG.get();
                    if (fVar == null || j.I(fVar)) {
                        Log.i("MicroMsg.AppBrandNetworkRequest", "onDownloadProgressChanged shouldStopTask fileKey:%s,taskid is %s,cronettaskid is %s", str, eVar.jEY, eVar.niw);
                        CronetLogic.cancelCronetTask(eVar.niw);
                        if (!eVar.niy) {
                            eVar.niy = true;
                            d.a(d.this, aVar, "fail", "interrupted", eVar.jEY);
                        } else {
                            Log.e("MicroMsg.AppBrandNetworkRequest", "onDownloadProgressChanged already callback");
                        }
                        d.c(eVar);
                        AppMethodBeat.o(144317);
                        return;
                    }
                    AppMethodBeat.o(144317);
                }
            };
            CronetLogic.CronetRequestParams cronetRequestParams = new CronetLogic.CronetRequestParams();
            cronetRequestParams.url = eVar.mUrl;
            cronetRequestParams.taskId = eVar.jEY;
            cronetRequestParams.followRedirect = false;
            cronetRequestParams.bodyData = eVar.mPostData;
            cronetRequestParams.method = eVar.csu;
            cronetRequestParams.useHttp2 = eVar.jFh;
            cronetRequestParams.useQuic = eVar.jFi;
            cronetRequestParams.useMemoryCache = eVar.niz;
            cronetRequestParams.cachePerformance = true;
            Map<String, String> map = eVar.jEZ;
            if (!map.containsKey("Accept-Encoding")) {
                map.put("Accept-Encoding", "gzip,compress,br,deflate");
            } else {
                Log.i("MicroMsg.AppBrandNetworkRequest", "startCronetHttpsRequest Accept-Encoding:%s", map.get("Accept-Encoding"));
            }
            map.put("charset", ProtocolPackage.ServerEncoding);
            map.put("User-Agent", dVar.mGo);
            if (dVar.acX(eVar.csu)) {
                map.put("Content-Length", Integer.toString(eVar.mPostData.length));
            }
            cronetRequestParams.makeRequestHeader(map);
            aVar.J(j.c(j.X(map), 1));
            AnonymousClass2 r5 = new com.tencent.f.i.b() {
                /* class com.tencent.mm.plugin.appbrand.s.d.AnonymousClass2 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    AppMethodBeat.i(179550);
                    String str = "AppBrandNetworkRequest@" + eVar.jEY;
                    AppMethodBeat.o(179550);
                    return str;
                }

                public final void run() {
                    AppMethodBeat.i(144318);
                    Log.e("MicroMsg.AppBrandNetworkRequest", "call cronet time out taskid:%s,timeout:%d,url:%s", eVar.jEY, Integer.valueOf(eVar.mTimeout), eVar.mUrl);
                    if (!eVar.niy) {
                        eVar.niy = true;
                        d.a(d.this, aVar, "fail", "timeout", eVar.jEY);
                    } else {
                        Log.e("MicroMsg.AppBrandNetworkRequest", "call cronet time out already callback");
                    }
                    ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 6, 1, false);
                    if (!Util.isNullOrNil(eVar.niw)) {
                        CronetLogic.cancelCronetTask(eVar.niw);
                    }
                    AppMethodBeat.o(144318);
                }
            };
            eVar.mRunnable = r5;
            h.RTc.o(r5, (long) eVar.mTimeout);
            cronetRequestParams.taskType = 1;
            CronetLogic.CronetHttpsCreateResult startCronetHttpTask = CronetLogic.startCronetHttpTask(cronetRequestParams, r4);
            Log.i("MicroMsg.AppBrandNetworkRequest", "startCronetHttpsRequest createRet is %d, taskId is %s", Integer.valueOf(startCronetHttpTask.createRet), startCronetHttpTask.taskId);
            if (startCronetHttpTask == null || startCronetHttpTask.createRet != 0) {
                ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 2, 1, false);
                AppMethodBeat.o(144333);
                return;
            }
            eVar.niw = startCronetHttpTask.taskId;
            ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1095, 7, 1, false);
            AppMethodBeat.o(144333);
            return;
        }
        dVar.a(aVar, "fail", "url not in domain list", eVar.jEY, (HttpURLConnection) null);
        ((o) e.N(o.class)).a(dVar.nie, eVar.nix, eVar.csu, eVar.mUrl, 0, 0, 0, 2, eVar.bPz(), "", "");
        Log.i("MicroMsg.AppBrandNetworkRequest", "sendCronetRequest not in domain url %s", eVar.mUrl);
        AppMethodBeat.o(144333);
    }
}
