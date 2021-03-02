package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.aa.c.f;
import com.tencent.mm.aa.d.a;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.e.b;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONObject;

public class e {
    private static volatile com.tencent.mm.aa.c.e lph;
    private static volatile DebuggerInfo lpi;

    static /* synthetic */ com.tencent.mm.aa.c.e bCr() {
        AppMethodBeat.i(121453);
        com.tencent.mm.aa.c.e bCo = bCo();
        AppMethodBeat.o(121453);
        return bCo;
    }

    public static com.tencent.mm.aa.c.e a(Context context, final WxaWidgetContext wxaWidgetContext, a aVar, Bundle bundle) {
        com.tencent.mm.aa.c.e eVar;
        com.tencent.mm.aa.c.e eVar2;
        String str;
        AppMethodBeat.i(121447);
        synchronized (e.class) {
            try {
                eVar = lph;
                lph = null;
            } catch (Throwable th) {
                AppMethodBeat.o(121447);
                throw th;
            }
        }
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(eVar != null);
        u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", objArr);
        if (eVar == null) {
            eVar2 = bCo();
        } else {
            eVar2 = eVar;
        }
        int i2 = bundle.getInt("widget_type");
        c cVar = new c();
        cVar.gIx = wxaWidgetContext.getId();
        if (i2 == 1) {
            cVar.lnK = new com.tencent.mm.plugin.appbrand.dynamic.i.c(wxaWidgetContext.getAppId(), bundle.getString("search_id"));
        }
        com.tencent.mm.aa.c.c cVar2 = new com.tencent.mm.aa.c.c(context, eVar2, aVar, cVar);
        cVar2.hpj = p.wo(i2);
        eVar2.hpp = cVar2;
        d dVar = eVar2.hpr;
        eVar2.hpq = new f(dVar, com.tencent.mm.plugin.appbrand.dynamic.f.a.wp(i2), aVar);
        eVar2.hpt = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.bBZ();
        WidgetRuntimeConfig bBV = wxaWidgetContext.bBV();
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, "widgetType", Integer.valueOf(bBV.loG));
        b(jSONObject, TPDownloadProxyEnum.USER_PLATFORM, "android");
        b(jSONObject, "debug", Boolean.valueOf(wxaWidgetContext.bBT().lnb));
        if (wxaWidgetContext.bBU() != null) {
            b(jSONObject, "drawMinInterval", Integer.valueOf(wxaWidgetContext.bBU().lda));
        }
        b(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.KyO));
        JSONObject jSONObject2 = new JSONObject();
        b(jSONObject2, "drawMinInterval", Integer.valueOf(bBV.loX));
        b(jSONObject2, "timerEnabled", Boolean.valueOf(bBV.loY));
        b(jSONObject2, "drawLock", Boolean.valueOf(bBV.loZ));
        String format = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", jSONObject2.toString(), jSONObject.toString(), "");
        dVar.evaluateJavascript(format, null);
        Log.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", wxaWidgetContext.getId(), format);
        v.pl(10);
        hr vt = new hr().vt(u.Lv(wxaWidgetContext.getId()));
        vt.eBS = (long) u.Lt(wxaWidgetContext.getId());
        vt.eMi = 5;
        hr vs = vt.vs(wxaWidgetContext.getId());
        vs.eMj = System.currentTimeMillis();
        vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
        String dg = com.tencent.mm.plugin.appbrand.dynamic.j.c.dg(wxaWidgetContext.getId(), "WAWidget.js");
        if (Util.isNullOrNil(dg)) {
            u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
            str = com.tencent.mm.plugin.appbrand.ac.d.convertStreamToString(ay.openRead("WAWidget.js"));
        } else {
            str = dg;
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
        }
        h.INSTANCE.idkeyStat(636, 0, 1, false);
        s.a(dVar, str, new s.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.h.e.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(121443);
                v.pl(11);
                hr vt = new hr().vt(u.Lv(wxaWidgetContext.getId()));
                vt.eBS = (long) u.Lt(wxaWidgetContext.getId());
                vt.eMi = 6;
                vt.eMk = 1;
                hr vs = vt.vs(wxaWidgetContext.getId());
                vs.eMj = System.currentTimeMillis();
                vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                h.INSTANCE.idkeyStat(636, 1, 1, false);
                AppMethodBeat.o(121443);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(121444);
                v.pl(12);
                hr vt = new hr().vt(u.Lv(wxaWidgetContext.getId()));
                vt.eBS = (long) u.Lt(wxaWidgetContext.getId());
                vt.eMi = 6;
                vt.eMk = 2;
                hr vs = vt.vs(wxaWidgetContext.getId());
                vs.eMj = System.currentTimeMillis();
                vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                j.bBN().Yr(wxaWidgetContext.getId());
                h.INSTANCE.idkeyStat(636, 2, 1, false);
                Log.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", str);
                AppMethodBeat.o(121444);
            }
        });
        Log.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", wxaWidgetContext.getId());
        v.pl(13);
        String dg2 = com.tencent.mm.plugin.appbrand.dynamic.j.c.dg(wxaWidgetContext.getId(), "widget.js");
        if (Util.isNullOrNil(dg2)) {
            Log.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.bBJ().bF(wxaWidgetContext.getId(), 2102);
        }
        h.INSTANCE.idkeyStat(636, 3, 1, false);
        s.a(dVar, dg2, new s.a() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.h.e.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(121445);
                v.pl(14);
                hr vt = new hr().vt(u.Lv(wxaWidgetContext.getId()));
                vt.eBS = (long) u.Lt(wxaWidgetContext.getId());
                vt.eMi = 7;
                vt.eMk = 1;
                hr vs = vt.vs(wxaWidgetContext.getId());
                vs.eMj = System.currentTimeMillis();
                vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                h.INSTANCE.idkeyStat(636, 4, 1, false);
                j.bBN().Yr(wxaWidgetContext.getId());
                AppMethodBeat.o(121445);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(121446);
                v.pl(15);
                hr vt = new hr().vt(u.Lv(wxaWidgetContext.getId()));
                vt.eBS = (long) u.Lt(wxaWidgetContext.getId());
                vt.eMi = 7;
                vt.eMk = 2;
                hr vs = vt.vs(wxaWidgetContext.getId());
                vs.eMj = System.currentTimeMillis();
                vs.bfK();
                h.INSTANCE.idkeyStat(636, 5, 1, false);
                Log.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", str);
                AppMethodBeat.o(121446);
            }
        });
        Log.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", wxaWidgetContext.getId());
        dI(context);
        AppMethodBeat.o(121447);
        return eVar2;
    }

    private static void X(final Runnable runnable) {
        AppMethodBeat.i(121448);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.h.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(121441);
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                    /* class com.tencent.mm.plugin.appbrand.dynamic.h.e.AnonymousClass1.AnonymousClass1 */

                    public final boolean queueIdle() {
                        AppMethodBeat.i(121440);
                        Looper.myQueue().removeIdleHandler(this);
                        runnable.run();
                        AppMethodBeat.o(121440);
                        return false;
                    }
                });
                AppMethodBeat.o(121441);
            }
        };
        if (MMHandlerThread.isMainThread()) {
            r0.run();
            AppMethodBeat.o(121448);
            return;
        }
        MMHandlerThread.postToMainThread(r0);
        AppMethodBeat.o(121448);
    }

    public static void dI(final Context context) {
        AppMethodBeat.i(121449);
        com.tencent.mm.plugin.expansions.a.cMr();
        X(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.h.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(121442);
                synchronized (e.class) {
                    try {
                        if (e.lph == null) {
                            u.i("MicroMsg.PreloadOptimizer", "start preload mini jsbridge", new Object[0]);
                            DebuggerInfo unused = e.lpi;
                            com.tencent.mm.aa.c.e bCr = e.bCr();
                            synchronized (e.class) {
                                try {
                                    com.tencent.mm.aa.c.e unused2 = e.lph = bCr;
                                } finally {
                                    AppMethodBeat.o(121442);
                                }
                            }
                        }
                    } finally {
                        AppMethodBeat.o(121442);
                    }
                }
            }
        });
        AppMethodBeat.o(121449);
    }

    private static com.tencent.mm.aa.c.e bCo() {
        AppMethodBeat.i(121450);
        com.tencent.mm.aa.c.e eVar = new com.tencent.mm.aa.c.e();
        eVar.a(a(eVar));
        AppMethodBeat.o(121450);
        return eVar;
    }

    private static d a(com.tencent.mm.aa.c.e eVar) {
        AppMethodBeat.i(121451);
        d cC = b.cC(eVar);
        h.INSTANCE.idkeyStat(639, 2, 1, false);
        Log.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
        h.INSTANCE.idkeyStat(639, 0, 1, false);
        AppMethodBeat.o(121451);
        return cC;
    }

    private static void b(JSONObject jSONObject, String str, Object obj) {
        AppMethodBeat.i(121452);
        try {
            jSONObject.put(str, obj);
            AppMethodBeat.o(121452);
        } catch (Exception e2) {
            Log.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", e2);
            AppMethodBeat.o(121452);
        }
    }
}
