package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.AssetReader;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a;
import com.tencent.mm.plugin.appbrand.media.record.c;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.permission.a.b;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.Iterator;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends q {
    public volatile c naC;
    private a naD;

    public interface a {
        void c(AppBrandInitConfig appBrandInitConfig, Object obj);
    }

    public l(AppBrandRuntimeContainerWC appBrandRuntimeContainerWC) {
        super(appBrandRuntimeContainerWC);
    }

    @Override // com.tencent.mm.plugin.appbrand.q, com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final ab bro() {
        AppMethodBeat.i(47530);
        h hVar = new h(AndroidContextUtil.castActivityOrNull(this.mContext));
        AppMethodBeat.o(47530);
        return hVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.q, com.tencent.mm.plugin.appbrand.AppBrandRuntime
    @SuppressLint({"MissingSuperCall", "SourceLockedOrientationActivity"})
    public final void onCreate() {
        AppMethodBeat.i(47531);
        bsy();
        bsv();
        b.H(this);
        b(b.AbstractC0781b.class, i.nax);
        b(a.b.class, i.nax);
        a(new AppBrandRuntime.b() {
            /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.AppBrandRuntime.b
            public final void prepare() {
                AppMethodBeat.i(47529);
                g.hio().h(new com.tencent.mm.vending.c.a<Void, Void>() {
                    /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.AnonymousClass1.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(Void r3) {
                        AppMethodBeat.i(47528);
                        Void buw = buw();
                        AppMethodBeat.o(47528);
                        return buw;
                    }

                    private Void buw() {
                        AppMethodBeat.i(47527);
                        l.c(l.this);
                        l lVar = l.this;
                        AppBrandInitConfigWC bsC = lVar.bsC();
                        if (bsC == null || bsC.cys == null || bsC.cys.leo != 7) {
                            Log.i("MicroMsg.OpenSdkJsApiProcessor", "initConfig is null or lanunchScene is err, return");
                        } else {
                            String m = aa.m(bsC);
                            Log.d("MicroMsg.OpenSdkJsApiProcessor", "openapiInvokeData:%s", m);
                            try {
                                JSONObject jSONObject = new JSONObject(m);
                                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("args"));
                                i<String> iVar = new i<>();
                                if (lVar.OK().a(iVar) == m.OK) {
                                    Iterator<String> keys = jSONObject2.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        Object obj = jSONObject2.get(next);
                                        if ((obj instanceof String) && aa.afL((String) obj)) {
                                            jSONObject2.put(next, aa.a(lVar, iVar.value, (String) obj));
                                        } else if (obj instanceof JSONArray) {
                                            JSONArray jSONArray = (JSONArray) obj;
                                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                                Object obj2 = jSONArray.get(i2);
                                                if ((obj2 instanceof String) && aa.afL((String) obj2)) {
                                                    jSONArray.put(aa.a(lVar, iVar.value, (String) obj2));
                                                }
                                            }
                                            jSONObject2.put(next, jSONArray);
                                        }
                                    }
                                    jSONObject.put("args", jSONObject2.toString());
                                    String jSONObject3 = jSONObject.toString();
                                    if (!TextUtils.isEmpty(bsC.ldR)) {
                                        bsC.ldR = jSONObject3;
                                    } else {
                                        bsC.cys.ler = jSONObject3;
                                    }
                                    Log.d("MicroMsg.OpenSdkJsApiProcessor", "transfer finish, openapiInvokeData:%s", m);
                                }
                            } catch (JSONException e2) {
                                Log.printInfoStack("MicroMsg.OpenSdkJsApiProcessor", "", e2);
                            }
                        }
                        Void r1 = QZL;
                        AppMethodBeat.o(47527);
                        return r1;
                    }
                }).b(new com.tencent.mm.vending.c.a<Void, Void>() {
                    /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.AnonymousClass1.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(Void r5) {
                        AppMethodBeat.i(47526);
                        l.this.naC = new c(l.this);
                        AnonymousClass1.this.KY();
                        Void r0 = QZL;
                        AppMethodBeat.o(47526);
                        return r0;
                    }
                });
                AppMethodBeat.o(47529);
            }
        });
        a(AssetReader.kKj);
        this.kDi.N(this);
        AndroidContextUtil.castActivityOrNull(this.mContext).setRequestedOrientation(1);
        com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
        c.onCreate();
        com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.s(this);
        com.tencent.mm.plugin.appbrand.backgroundfetch.i.s(this);
        AppMethodBeat.o(47531);
    }

    @Override // com.tencent.mm.plugin.appbrand.q
    public final com.tencent.mm.plugin.appbrand.k.b bsq() {
        return com.tencent.mm.plugin.appbrand.k.b.lvC;
    }

    @Override // com.tencent.mm.plugin.appbrand.q, com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
    @SuppressLint({"MissingSuperCall"})
    public final void onReady() {
        q qVar;
        AppMethodBeat.i(47532);
        c cVar = this.naC;
        String m = aa.m(bsC());
        boolean n = aa.n(bsC());
        p.h(m, "invokeData");
        if (cVar.nas.bsC().cyx != null) {
            qVar = new r(cVar.nas);
        } else if (n) {
            qVar = new NewSDKInvokeProcess(cVar.nas);
        } else {
            qVar = new q(cVar.nas);
        }
        cVar.nar = qVar;
        o oVar = cVar.nar;
        if (oVar == null) {
            p.btv("invokeProcess");
        }
        oVar.acv(m);
        AppMethodBeat.o(47532);
    }

    @Override // com.tencent.mm.plugin.appbrand.q, com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final com.tencent.mm.plugin.appbrand.p.a OR() {
        AppMethodBeat.i(47533);
        a.c cVar = new a.c();
        AppMethodBeat.o(47533);
        return cVar;
    }

    public final k bOH() {
        AppMethodBeat.i(227146);
        k kVar = (k) super.bsz();
        AppMethodBeat.o(227146);
        return kVar;
    }

    public final void a(a aVar) {
        this.naD = aVar;
    }

    @Override // com.tencent.luggage.sdk.d.d, com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final void a(AppBrandInitConfig appBrandInitConfig, Object obj) {
        AppMethodBeat.i(227147);
        super.a(appBrandInitConfig, obj);
        if (this.naD != null) {
            this.naD.c(appBrandInitConfig, obj);
        }
        AppMethodBeat.o(227147);
    }

    /* access modifiers changed from: package-private */
    public final void bOG() {
        AppMethodBeat.i(227145);
        final Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mContext);
        super.R((Runnable) new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(227144);
                if (castActivityOrNull instanceof AppBrandPluginUI) {
                    ((AppBrandPluginUI) castActivityOrNull).finish();
                }
                AppMethodBeat.o(227144);
            }
        });
        AppMethodBeat.o(227145);
    }

    @Override // com.tencent.mm.plugin.appbrand.q
    public final /* bridge */ /* synthetic */ ag bsz() {
        AppMethodBeat.i(227148);
        k kVar = (k) super.bsz();
        AppMethodBeat.o(227148);
        return kVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.q, com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final /* synthetic */ w brx() {
        AppMethodBeat.i(47534);
        j jVar = new j(this);
        AppMethodBeat.o(47534);
        return jVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.q, com.tencent.mm.plugin.appbrand.AppBrandRuntime
    public final /* synthetic */ s brw() {
        AppMethodBeat.i(47535);
        e eVar = new e();
        AppMethodBeat.o(47535);
        return eVar;
    }

    static /* synthetic */ void c(l lVar) {
        AppMethodBeat.i(47536);
        AppBrandSysConfigWC a2 = f.a(lVar);
        if (a2 == null) {
            lVar.finish();
            AppMethodBeat.o(47536);
            return;
        }
        lVar.kAA.add(a2);
        lVar.b(f.b(lVar));
        lVar.cCn = new d(lVar, -1, true);
        lVar.brm();
        lVar.bsG();
        AppMethodBeat.o(47536);
    }
}
