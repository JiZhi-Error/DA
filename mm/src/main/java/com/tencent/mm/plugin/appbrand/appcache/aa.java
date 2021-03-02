package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseLongArray;
import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.luggage.h.l;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.abf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class aa {
    private static volatile boolean kLE = false;
    private static final SparseLongArray kLF = new SparseLongArray();
    private static final long kLG = TimeUnit.MINUTES.toMillis(5);
    private static final ConcurrentHashMap<String, d<ArrayList<String>>> kLH = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(161747);
        AppMethodBeat.o(161747);
    }

    public static boolean bvK() {
        AppMethodBeat.i(230559);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_preconnect_servicewechat_cdn_at_attrsync, false);
        AppMethodBeat.o(230559);
        return a2;
    }

    public static void bvL() {
        AppMethodBeat.i(44304);
        if (kLE) {
            AppMethodBeat.o(44304);
            return;
        }
        kLE = true;
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.appbrand.appcache.aa.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "PkgNetworkOpt.triggerPreConnect";
            }

            public final void run() {
                AppMethodBeat.i(44303);
                try {
                    String str = AppBrandGlobalSystemConfig.bzP().lcR;
                    if (!TextUtils.isEmpty(str)) {
                        aa.CS(str);
                        aa.Vd(l.dL(str));
                        boolean unused = aa.kLE = false;
                        AppMethodBeat.o(44303);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.PkgNetworkOpt", e2, "triggerPreConnect", new Object[0]);
                } finally {
                    boolean unused2 = aa.kLE = false;
                    AppMethodBeat.o(44303);
                }
            }
        });
        AppMethodBeat.o(44304);
    }

    static ArrayList<String> Vd(final String str) {
        AppMethodBeat.i(161745);
        if (TextUtils.isEmpty(str)) {
            Log.w("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with EMPTY host");
            ArrayList<String> arrayList = new ArrayList<>(0);
            AppMethodBeat.o(161745);
            return arrayList;
        }
        Log.i("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with host[%s]", str);
        d<ArrayList<String>> dVar = kLH.get(str);
        if (dVar == null) {
            dVar = h.RTc.a(new Callable<ArrayList<String>>() {
                /* class com.tencent.mm.plugin.appbrand.appcache.aa.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ ArrayList<String> call() {
                    AppMethodBeat.i(230558);
                    ArrayList<String> bvO = bvO();
                    AppMethodBeat.o(230558);
                    return bvO;
                }

                private ArrayList<String> bvO() {
                    AppMethodBeat.i(230557);
                    try {
                        ArrayList<String> arrayList = new ArrayList<>();
                        g.aAg().hqi.iMw.getHostByName(str, arrayList);
                        AppMethodBeat.o(230557);
                        return arrayList;
                    } catch (Throwable th) {
                        ArrayList<String> arrayList2 = new ArrayList<>(0);
                        AppMethodBeat.o(230557);
                        return arrayList2;
                    }
                }
            }, "MicroMsg.PkgNetworkOpt");
            kLH.put(str, dVar);
        }
        try {
            ArrayList<String> arrayList2 = dVar.get(500, TimeUnit.MILLISECONDS);
            AppMethodBeat.o(161745);
            return arrayList2;
        } catch (Throwable th) {
            Log.e("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost await future t=%s", th);
            ArrayList<String> arrayList3 = new ArrayList<>(0);
            AppMethodBeat.o(161745);
            return arrayList3;
        }
    }

    static /* synthetic */ void CS(final String str) {
        long j2;
        AppMethodBeat.i(230560);
        if (((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_preconnect_servicewechat_cdn, true)) {
            if (TextUtils.isEmpty(str)) {
                Log.w("MicroMsg.PkgNetworkOpt", "preConnectHost with EMPTY url");
                AppMethodBeat.o(230560);
                return;
            }
            synchronized (kLF) {
                try {
                    j2 = kLF.get(str.hashCode(), 0);
                } finally {
                    AppMethodBeat.o(230560);
                }
            }
            if (Util.milliSecondsToNow(j2) < kLG) {
                Log.i("MicroMsg.PkgNetworkOpt", "preConnectHost, hit interval control, url:%s, lastPreConnectedTimestamp:%d", str, Long.valueOf(j2));
                AppMethodBeat.o(230560);
                return;
            }
            Log.i("MicroMsg.PkgNetworkOpt", "preConnectHost, task start, url:%s", str);
            abf abf = new abf();
            abf.eiy.event = 1;
            EventCenter.instance.asyncPublish(abf, Looper.getMainLooper());
            CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
            c2CDownloadRequest.httpMethod = "HEAD";
            c2CDownloadRequest.url = str;
            c2CDownloadRequest.fileKey = str;
            CdnLogic.startCronetSimpleRequest(c2CDownloadRequest, new CdnLogic.DownloadCallback() {
                /* class com.tencent.mm.plugin.appbrand.appcache.aa.AnonymousClass2 */

                @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
                public final void onDownloadProgressChanged(String str, long j2, long j3, boolean z) {
                }

                @Override // com.tencent.mars.cdn.CdnLogic.DownloadCallback
                public final void onC2CDownloadCompleted(String str, CdnLogic.C2CDownloadResult c2CDownloadResult) {
                    AppMethodBeat.i(230556);
                    if (!(c2CDownloadResult == null || c2CDownloadResult.cronetTaskResult == null || c2CDownloadResult.cronetTaskResult.performance == null)) {
                        Log.i("MicroMsg.PkgNetworkOpt", "preConnectHost, task end, url:%s, statusCode:%d, profile:%s", str, Integer.valueOf(c2CDownloadResult.cronetTaskResult.statusCode), c2CDownloadResult.cronetTaskResult.performance);
                    }
                    abf abf = new abf();
                    abf.eiy.event = 2;
                    abf.eiy.eiz = c2CDownloadResult;
                    EventCenter.instance.asyncPublish(abf, Looper.getMainLooper());
                    long nowMilliSecond = Util.nowMilliSecond();
                    synchronized (aa.kLF) {
                        try {
                            aa.kLF.put(str.hashCode(), nowMilliSecond);
                        } finally {
                            AppMethodBeat.o(230556);
                        }
                    }
                }
            });
        }
    }
}
