package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.a.b;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static volatile d ltQ;
    public boolean hasInit = false;
    public q kGW;
    public m ltR;
    public a ltS;
    public com.tencent.mm.plugin.appbrand.appstorage.q ltT;
    public c ltU;
    public CopyOnWriteArrayList<String> ltV = new CopyOnWriteArrayList<>();
    public boolean ltW = false;
    public boolean ltX = false;
    public AtomicInteger ltY;
    public AtomicInteger ltZ;
    public AtomicInteger lua;
    public AtomicInteger lub;

    static /* synthetic */ void b(d dVar) {
        AppMethodBeat.i(45293);
        dVar.bDv();
        AppMethodBeat.o(45293);
    }

    private d() {
        AppMethodBeat.i(45286);
        AppMethodBeat.o(45286);
    }

    public static d bDu() {
        AppMethodBeat.i(45287);
        if (ltQ == null) {
            synchronized (d.class) {
                try {
                    if (ltQ == null) {
                        ltQ = new d();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(45287);
                    throw th;
                }
            }
        }
        d dVar = ltQ;
        AppMethodBeat.o(45287);
        return dVar;
    }

    public static void x(q qVar) {
        AppMethodBeat.i(226634);
        synchronized (d.class) {
            try {
                if (ltQ != null && ltQ.kGW == qVar) {
                    if (ltQ.ltR != null) {
                        m mVar = ltQ.ltR;
                        synchronized (mVar.nhU) {
                            try {
                                Iterator<b> it = mVar.nhU.iterator();
                                while (it.hasNext()) {
                                    it.next().isRunning = false;
                                }
                                mVar.nhU.clear();
                            } finally {
                                AppMethodBeat.o(226634);
                            }
                        }
                        synchronized (mVar.niS) {
                            try {
                                Iterator<b> it2 = mVar.niS.iterator();
                                while (it2.hasNext()) {
                                    it2.next().isRunning = false;
                                }
                                mVar.niS.clear();
                            } finally {
                                AppMethodBeat.o(226634);
                            }
                        }
                        synchronized (mVar.niR) {
                            try {
                                mVar.niR.clear();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        ltQ.ltR = null;
                        ltQ.ltU = null;
                        ltQ.ltS = null;
                        ltQ.ltT = null;
                        ltQ.kGW = null;
                    }
                    ltQ.hasInit = false;
                }
            } finally {
                AppMethodBeat.o(226634);
            }
        }
    }

    public final void bu(List<String> list) {
        AppMethodBeat.i(226635);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(226635);
            return;
        }
        this.ltV.addAll(list);
        for (String str : list) {
            m mVar = this.ltR;
            String bjl = bjl();
            JSONObject jSONObject = new JSONObject();
            Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "doDownloadFileNoCheck taskId:%s url:%s", bjl, str);
            try {
                jSONObject.put("url", str);
            } catch (JSONException e2) {
            }
            mVar.a(jSONObject, 60000, new HashMap(), null, 50, new b.a(str) {
                /* class com.tencent.mm.plugin.appbrand.s.m.AnonymousClass1 */
                final /* synthetic */ String val$url;

                {
                    this.val$url = r2;
                }

                @Override // com.tencent.mm.plugin.appbrand.s.b.a
                public final void a(int i2, String str, String str2, int i3, long j2, Map map) {
                    AppMethodBeat.i(207102);
                    if (i2 == b.FAILED) {
                        AppMethodBeat.o(207102);
                        return;
                    }
                    synchronized (m.this.niR) {
                        try {
                            m.this.niR.put(this.val$url, new a(str2, str, this.val$url, i3, j2));
                        } finally {
                            AppMethodBeat.o(207102);
                        }
                    }
                }

                @Override // com.tencent.mm.plugin.appbrand.s.b.a
                public final void h(int i2, long j2, long j3) {
                }

                @Override // com.tencent.mm.plugin.appbrand.s.b.a
                public final void ah(int i2, String str) {
                }

                @Override // com.tencent.mm.plugin.appbrand.s.b.a
                public final void J(JSONObject jSONObject) {
                    AppMethodBeat.i(144426);
                    AppMethodBeat.o(144426);
                }
            }, bjl, APMidasPayAPI.ENV_TEST);
        }
        AppMethodBeat.o(226635);
    }

    public final boolean YQ(String str) {
        AppMethodBeat.i(226636);
        synchronized (this.ltV) {
            try {
                if (this.ltV == null || !this.ltV.contains(str)) {
                    boolean booleanValue = this.ltR.adi(str).booleanValue();
                    AppMethodBeat.o(226636);
                    return booleanValue;
                }
                Log.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", str, Integer.valueOf(this.ltV.size()));
                this.lub.addAndGet(1);
                return true;
            } finally {
                AppMethodBeat.o(226636);
            }
        }
    }

    public static String bjl() {
        AppMethodBeat.i(45289);
        StringBuilder sb = new StringBuilder();
        c.bPx();
        String sb2 = sb.append(c.bPw()).toString();
        AppMethodBeat.o(45289);
        return sb2;
    }

    public final void bDv() {
        AppMethodBeat.i(45290);
        if (this.ltV != null && this.ltV.size() == 0) {
            if (this.kGW == null || this.kGW.getAppConfig() == null) {
                Log.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
                AppMethodBeat.o(45290);
                return;
            }
            ArrayList<String> arrayList = this.kGW.getAppConfig().lbU;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            Log.i("MicroMsg.WAGamePreloadManager", "predownload subPackage size:%d", objArr);
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    final String next = it.next();
                    Log.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", next);
                    q qVar = this.kGW;
                    if (qVar == null || qVar.bsB() == null) {
                        Log.e("MicroMsg.WAGamePreloadManager", "runtime(%s) or sysConfig null", qVar.mAppId);
                    } else if (qVar.SO || qVar.isDestroyed()) {
                        Log.e("MicroMsg.WAGamePreloadManager", "runtime(%s) finishing", qVar.mAppId);
                    } else {
                        bg.L(qVar);
                        String cv = qVar.bsB().leE.cv(qVar.mAppId, next);
                        s.bhK(next);
                        if (e.c.ngP == null) {
                            Log.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
                        } else {
                            e j2 = e.c.ngP.j(qVar, cv);
                            j2.a(new e.b() {
                                /* class com.tencent.mm.plugin.appbrand.game.preload.d.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.p.e.a
                                public final void YR(String str) {
                                    AppMethodBeat.i(45282);
                                    Log.i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", next, str);
                                    d.this.lua.addAndGet(1);
                                    AppMethodBeat.o(45282);
                                }

                                @Override // com.tencent.mm.plugin.appbrand.p.e.a
                                public final void a(com.tencent.mm.plugin.appbrand.p.c cVar) {
                                    AppMethodBeat.i(45283);
                                    Log.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", cVar);
                                    AppMethodBeat.o(45283);
                                }

                                @Override // com.tencent.mm.plugin.appbrand.p.e.b
                                public final void a(android.arch.a.c.a<AppBrandRuntime, Boolean> aVar) {
                                    AppMethodBeat.i(226633);
                                    Log.i("MicroMsg.WAGamePreloadManager", "onResultCustomAction, module(%s)", next);
                                    d.this.lua.addAndGet(1);
                                    AppMethodBeat.o(226633);
                                }
                            });
                            j2.start();
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(45290);
    }

    public static void hf(boolean z) {
        AppMethodBeat.i(45291);
        e.bDw().lul = z;
        AppMethodBeat.o(45291);
    }

    static /* synthetic */ void a(d dVar, String str) {
        AppMethodBeat.i(45292);
        if (!Util.isNullOrNil(str)) {
            synchronized (dVar.ltV) {
                try {
                    if (dVar.ltV != null) {
                        Iterator<String> it = dVar.ltV.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (str.equals(it.next())) {
                                    dVar.ltV.remove(str);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(45292);
                }
            }
            return;
        }
        AppMethodBeat.o(45292);
    }
}
