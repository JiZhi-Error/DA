package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.webkit.ValueCallback;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.ad.g;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.jsapi.ae;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.m.n;
import com.tencent.mm.plugin.appbrand.m.r;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class s extends d {
    private volatile boolean kDZ = false;
    public volatile boolean kEa = false;
    public c kEb = new o();
    public volatile AppBrandRuntime kEc;
    private final Object kEd = new byte[0];
    private volatile x kEe;
    private final Object kEf = new byte[0];
    private volatile LinkedList<ae> kEg;
    a kEh;
    g kEi;
    private volatile boolean mDestroyed = false;
    private volatile boolean mInitialized = false;

    public s() {
        AppMethodBeat.i(134576);
        synchronized (this.kEf) {
            try {
                this.kEg = new LinkedList<>();
            } finally {
                AppMethodBeat.o(134576);
            }
        }
    }

    public void b(c cVar) {
        this.kEb = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.d
    public final c getWindowAndroid() {
        return this.kEb;
    }

    public final void YU() {
        AppMethodBeat.i(134577);
        bEb();
        bsZ();
        l.a(this, bte());
        this.kDZ = true;
        MD();
        if (getJsRuntime().R(r.class) != null) {
            getJsRuntime().R(r.class);
        }
        AppMethodBeat.o(134577);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final boolean bsV() {
        return this.kEa;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.l
    public final boolean bsW() {
        AppMethodBeat.i(134578);
        if (getRuntime() != null || this.mDestroyed) {
            AppMethodBeat.o(134578);
            return false;
        }
        AppMethodBeat.o(134578);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.l
    public final boolean bsX() {
        return this.kDZ;
    }

    /* access modifiers changed from: protected */
    public void MD() {
    }

    public void d(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134579);
        this.kEc = appBrandRuntime;
        b(appBrandRuntime.getWindowAndroid());
        t tVar = t.a.kEr;
        int componentId = getComponentId();
        Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", Integer.valueOf(componentId));
        synchronized (tVar) {
            try {
                List<t.b> list = tVar.kEp.get(componentId);
                if (list == null) {
                    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
                    tVar.kEq.put(componentId, 1);
                    return;
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    list.get(i2).btg();
                }
                AppMethodBeat.o(134579);
            } finally {
                AppMethodBeat.o(134579);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void Mx() {
        AppMethodBeat.i(134580);
        if (!isRunning()) {
            Log.w("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", getAppId());
            AppMethodBeat.o(134580);
            return;
        }
        new n().ae(this.kEc);
        AppMethodBeat.o(134580);
    }

    /* access modifiers changed from: protected */
    public void bX(boolean z) {
        String currentUrl;
        AppMethodBeat.i(134581);
        if (!isRunning()) {
            Log.w("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", getAppId(), Boolean.valueOf(z));
            AppMethodBeat.o(134581);
            return;
        }
        com.tencent.mm.plugin.appbrand.page.o bsY = bsY();
        AppBrandRuntime appBrandRuntime = this.kEc;
        HashMap hashMap = new HashMap();
        JSONObject NF = appBrandRuntime.OU().NF();
        if (NF != null) {
            hashMap.put("referrerInfo", NF);
        }
        hashMap.put("relaunch", Boolean.valueOf(z));
        hashMap.put("reLaunch", Boolean.valueOf(z));
        if (z) {
            currentUrl = appBrandRuntime.brs();
        } else {
            currentUrl = appBrandRuntime.brh().getCurrentUrl();
        }
        hashMap.put("rawPath", currentUrl);
        hashMap.put("path", com.tencent.luggage.h.l.dM(currentUrl));
        hashMap.put(SearchIntents.EXTRA_QUERY, com.tencent.luggage.h.l.dN(currentUrl));
        Log.i("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", hashMap.get("path"), hashMap.get(SearchIntents.EXTRA_QUERY), hashMap.get("relaunch"), currentUrl);
        e.m(hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        bsY.a(appBrandRuntime, z, jSONObject);
        bsY.Zg(jSONObject.toString()).g(appBrandRuntime.NY()).bEo();
        AppMethodBeat.o(134581);
    }

    /* access modifiers changed from: protected */
    public com.tencent.mm.plugin.appbrand.page.o bsY() {
        AppMethodBeat.i(176539);
        com.tencent.mm.plugin.appbrand.page.o oVar = new com.tencent.mm.plugin.appbrand.page.o();
        AppMethodBeat.o(176539);
        return oVar;
    }

    private void bsZ() {
        AppMethodBeat.i(134582);
        synchronized (this.kEd) {
            try {
                if (this.kEe == null) {
                    this.kEe = Ox();
                }
            } finally {
                AppMethodBeat.o(134582);
            }
        }
    }

    /* access modifiers changed from: protected */
    public x Ox() {
        AppMethodBeat.i(134583);
        x xVar = new x(this);
        AppMethodBeat.o(134583);
        return xVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final void init() {
        AppMethodBeat.i(134584);
        super.init();
        bsZ();
        this.mInitialized = true;
        f(this.kEc.kAA);
        MC();
        this.kEa = false;
        AppMethodBeat.o(134584);
    }

    /* access modifiers changed from: protected */
    public void MC() {
        AppMethodBeat.i(134585);
        Os();
        bta();
        AppMethodBeat.o(134585);
    }

    /* access modifiers changed from: protected */
    public final void bta() {
        LinkedList linkedList = null;
        AppMethodBeat.i(134586);
        synchronized (this.kEf) {
            try {
                if (this.kEg != null) {
                    linkedList = new LinkedList(this.kEg);
                }
                this.kEg = null;
            } finally {
                AppMethodBeat.o(134586);
            }
        }
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ae aeVar = (ae) it.next();
                super.c(aeVar.event, aeVar.data, aeVar.src);
            }
        }
    }

    @Deprecated
    public final void ck(String str, String str2) {
        AppMethodBeat.i(134587);
        super.c(str, str2, 0);
        AppMethodBeat.o(134587);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final void b(String str, String str2, int[] iArr) {
        AppMethodBeat.i(134589);
        if (!isRunning()) {
            AppMethodBeat.o(134589);
            return;
        }
        this.kEc.brh().c(str, str2, iArr);
        AppMethodBeat.o(134589);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.d
    public final boolean isRunning() {
        AppMethodBeat.i(134590);
        if (!this.mInitialized || this.mDestroyed || !super.isRunning()) {
            AppMethodBeat.o(134590);
            return false;
        }
        AppMethodBeat.o(134590);
        return true;
    }

    public ac getCurrentPageView() {
        AppMethodBeat.i(134591);
        ac ax = ax(ac.class);
        AppMethodBeat.o(134591);
        return ax;
    }

    public final <T extends ac> T ax(Class<T> cls) {
        AppMethodBeat.i(134592);
        if (this.kEc == null) {
            AppMethodBeat.o(134592);
            return null;
        } else if (this.kEc.brh() == null) {
            AppMethodBeat.o(134592);
            return null;
        } else if (this.kEc.brh() == null) {
            Log.w("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", getAppId());
            if (!this.kEc.bry()) {
                IllegalStateException illegalStateException = new IllegalStateException("getCurrentPageView NULL PageContainer");
                AppMethodBeat.o(134592);
                throw illegalStateException;
            }
            AppMethodBeat.o(134592);
            return null;
        } else {
            com.tencent.mm.plugin.appbrand.page.t currentPage = this.kEc.brh().getCurrentPage();
            if (currentPage == null) {
                Log.w("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", getAppId());
                AppMethodBeat.o(134592);
                return null;
            }
            T t = (T) currentPage.getCurrentPageView();
            if (cls.isInstance(t)) {
                AppMethodBeat.o(134592);
                return t;
            }
            AppMethodBeat.o(134592);
            return null;
        }
    }

    public final Activity btb() {
        AppMethodBeat.i(259545);
        Activity ay = ay(Activity.class);
        AppMethodBeat.o(259545);
        return ay;
    }

    public final <T extends Activity> T ay(Class<T> cls) {
        Context context;
        AppMethodBeat.i(134593);
        if (getCurrentPageView() == null) {
            context = getContext();
        } else {
            context = getCurrentPageView().getContext();
        }
        if (cls.isInstance(context)) {
            T t = (T) ((Activity) context);
            AppMethodBeat.o(134593);
            return t;
        }
        AppMethodBeat.o(134593);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k
    public AppBrandRuntime getRuntime() {
        return this.kEc;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public i Oo() {
        AppMethodBeat.i(134594);
        com.tencent.mm.plugin.appbrand.m.c cVar = new com.tencent.mm.plugin.appbrand.m.c((byte) 0);
        AppMethodBeat.o(134594);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public Map<String, p> Op() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public void cleanup() {
        AppMethodBeat.i(134595);
        this.mInitialized = false;
        this.mDestroyed = true;
        this.kEc = null;
        super.cleanup();
        synchronized (this.kEd) {
            try {
                if (this.kEe != null) {
                    x xVar = this.kEe;
                    for (m mVar : xVar.kEz.dqZ.values()) {
                        mVar.dpQ.quit();
                    }
                    xVar.kAr = null;
                    this.kEe = null;
                }
            } finally {
                AppMethodBeat.o(134595);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final String btc() {
        return "AppBrandService";
    }

    public final x btd() {
        x xVar;
        synchronized (this.kEd) {
            xVar = this.kEe;
        }
        return xVar;
    }

    static class a {
        Object iMa;
        String kEm;
        long kEn;
        long kEo;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final int getComponentId() {
        AppMethodBeat.i(219269);
        int componentId = super.getComponentId();
        AppMethodBeat.o(219269);
        return componentId;
    }

    /* access modifiers changed from: protected */
    public void Os() {
        AppMethodBeat.i(134596);
        JSONObject Or = Or();
        String str = this.kEc.getAppConfig().lcc;
        Log.i("MicroMsg.AppBrandService", "injectConfig start, hash=%d", Integer.valueOf(getComponentId()));
        if (getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.n.class) != null) {
            final String jSONObject = Or.toString();
            ((com.tencent.mm.plugin.appbrand.m.n) getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.n.class)).a("__native_custom_event__wxConfig_inject", jSONObject, 0, "", new n.a() {
                /* class com.tencent.mm.plugin.appbrand.s.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.m.n.a
                public final void a(n.b bVar) {
                    AppMethodBeat.i(176536);
                    Log.i("MicroMsg.AppBrandService", "injectConfig end by AddonDirectEvaluation, cost=%dms, hash=%d", Long.valueOf(bVar.dql - bVar.dqk), Integer.valueOf(s.this.getComponentId()));
                    s.this.kEh = new a((byte) 0);
                    s.this.kEh.kEm = jSONObject;
                    s.this.kEh.kEn = bVar.dqk;
                    s.this.kEh.kEo = bVar.dql;
                    s.this.kEh.iMa = bVar;
                    AppMethodBeat.o(176536);
                }
            });
            AppMethodBeat.o(134596);
            return;
        }
        final long nowMilliSecond = Util.nowMilliSecond();
        final String jSONObject2 = Or.toString();
        String format = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", jSONObject2, str);
        if (getJsRuntime().R(v.class) != null) {
            ((v) getJsRuntime().R(v.class)).a(null, null, null, 0, format, new m.b() {
                /* class com.tencent.mm.plugin.appbrand.s.AnonymousClass2 */

                @Override // com.tencent.mm.appbrand.v8.m.b
                public final void a(String str, m.c cVar) {
                    AppMethodBeat.i(176537);
                    Log.i("MicroMsg.AppBrandService", "injectConfig end by AddonV8, cost=%dms, hash=%d", Long.valueOf(cVar.dql - cVar.dqk), Integer.valueOf(s.this.getComponentId()));
                    s.this.kEh = new a((byte) 0);
                    s.this.kEh.kEm = jSONObject2;
                    s.this.kEh.kEn = cVar.dqk;
                    s.this.kEh.kEo = cVar.dql;
                    s.this.kEh.iMa = cVar;
                    AppMethodBeat.o(176537);
                }
            });
            AppMethodBeat.o(134596);
            return;
        }
        getJsRuntime().evaluateJavascript(format, new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.appbrand.s.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(176538);
                long nowMilliSecond = Util.nowMilliSecond();
                Log.i("MicroMsg.AppBrandService", "injectConfig end by evaluateJavascript, cost=%dms, hash=%d", Long.valueOf(nowMilliSecond - nowMilliSecond), Integer.valueOf(s.this.getComponentId()));
                s.this.kEh = new a((byte) 0);
                s.this.kEh.kEm = jSONObject2;
                s.this.kEh.kEn = nowMilliSecond;
                s.this.kEh.kEo = nowMilliSecond;
                s.this.kEh.iMa = null;
                AppMethodBeat.o(176538);
            }
        });
        AppMethodBeat.o(134596);
    }

    /* access modifiers changed from: protected */
    public void a(String str, long j2, long j3, Object obj) {
    }

    public JSONObject Or() {
        JSONObject jSONObject;
        AppMethodBeat.i(134597);
        JSONObject jSONObject2 = new JSONObject();
        d(jSONObject2);
        com.tencent.mm.plugin.appbrand.config.l OT = this.kEc.OT();
        b appConfig = this.kEc.getAppConfig();
        if (OT == null || appConfig == null) {
            JSONObject jSONObject3 = new JSONObject();
            AppMethodBeat.o(134597);
            return jSONObject3;
        }
        if (!b.isDarkMode() || appConfig.lbX == null || appConfig.lbX.length() == 0) {
            jSONObject = appConfig.lbW;
        } else {
            jSONObject = appConfig.lbX;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.putOpt(next, jSONObject.opt(next));
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandService", e2.getMessage());
            }
        }
        c(jSONObject2, "env", new JSONObject());
        JSONObject jSONObject4 = new JSONObject();
        c(jSONObject4, "zIndex", (Object) 1000);
        c(jSONObject4, "viewId", (Object) 1);
        c(jSONObject2, "menuButtonInfo", jSONObject4);
        AppMethodBeat.o(134597);
        return jSONObject2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.l
    public final JSONObject bte() {
        AppMethodBeat.i(134598);
        JSONObject bte = super.bte();
        AppMethodBeat.o(134598);
        return bte;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.l
    public void d(JSONObject jSONObject) {
        AppMethodBeat.i(134599);
        super.d(jSONObject);
        if (getJsRuntime() != null) {
            c(jSONObject, "nativeBufferEnabled", Boolean.valueOf(getJsRuntime().R(k.class) != null));
        }
        AppMethodBeat.o(134599);
    }

    public String Ou() {
        return "";
    }

    public String Ot() {
        return "";
    }

    public String dG(String str) {
        return "";
    }

    public final void btf() {
        AppMethodBeat.i(219270);
        if (this.kEi != null) {
            g gVar = this.kEi;
            Log.i("MicroMsg.AppBrandServiceAdComponentView[AppBrandSplashAd]", "destroy view containers");
            if (gVar.kGU != null) {
                gVar.kGU.clear();
                gVar.kGU = null;
            }
            if (gVar.kGV != null) {
                gVar.kGV.removeAllViews();
                gVar.kGV = null;
            }
            this.kEi = null;
        }
        AppMethodBeat.o(219270);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public void c(String str, String str2, int i2) {
        AppMethodBeat.i(134588);
        if (!this.kEa || com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.ad.k.class) == null || !((com.tencent.mm.plugin.appbrand.ad.k) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.ad.k.class)).Ux(str)) {
            if (this.kEg != null) {
                synchronized (this.kEf) {
                    try {
                        if (this.kEg != null) {
                            this.kEg.add(new ae(str, str2, i2));
                            return;
                        }
                    } finally {
                        AppMethodBeat.o(134588);
                    }
                }
            }
            super.c(str, str2, i2);
            AppMethodBeat.o(134588);
            return;
        }
        Log.i("MicroMsg.AppBrandService", "dispatch, ad related event:%s", str);
        super.c(str, str2, i2);
        AppMethodBeat.o(134588);
    }
}
