package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.a;
import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.m.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f<Service extends d> extends a.AbstractC0178a<Service> implements com.tencent.mm.plugin.appbrand.p.f {
    final a cBl = new a(new a.AbstractC0181a((g) NN()) {
        /* class com.tencent.luggage.sdk.b.a.c.f.AnonymousClass1 */

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final void resumeLoopTasks() {
            AppMethodBeat.i(229854);
            if (f.this.NN() == null) {
                Log.e("Luggage.BaseAppBrandServiceLogic", "hy: component released when resumeLoopTasks");
                AppMethodBeat.o(229854);
                return;
            }
            q a2 = f.a(f.this);
            if (a2 == null) {
                Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
                AppMethodBeat.o(229854);
                return;
            }
            a2.resumeLoopTasks();
            AppMethodBeat.o(229854);
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final boolean doInnerLoopTask() {
            AppMethodBeat.i(229855);
            if (f.this.NN() == null) {
                Log.e("Luggage.BaseAppBrandServiceLogic", "hy: component released when doInnerLoopTask");
                AppMethodBeat.o(229855);
                return false;
            }
            q a2 = f.a(f.this);
            if (a2 == null) {
                Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js thread handler not installed");
                AppMethodBeat.o(229855);
                return false;
            }
            boolean doInnerLoopTask = a2.doInnerLoopTask();
            AppMethodBeat.o(229855);
            return doInnerLoopTask;
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b, com.tencent.luggage.sdk.b.a.c.a.AbstractC0181a
        public final boolean syncInitModule(String str, String str2) {
            JSONObject jSONObject;
            AppMethodBeat.i(229856);
            if (!Util.isNullOrNil(str2)) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("Luggage.BaseAppBrandServiceLogic", e2, "hy: param is not in json format", new Object[0]);
                }
                boolean d2 = f.this.d(str, jSONObject);
                AppMethodBeat.o(229856);
                return d2;
            }
            jSONObject = null;
            boolean d22 = f.this.d(str, jSONObject);
            AppMethodBeat.o(229856);
            return d22;
        }
    });

    /* access modifiers changed from: protected */
    public abstract void MC();

    /* access modifiers changed from: protected */
    public abstract void MD();

    public abstract boolean Mj();

    public f(Service service) {
        super(service);
    }

    /* access modifiers changed from: protected */
    public boolean d(String str, JSONObject jSONObject) {
        return false;
    }

    public final String getAppId() {
        return ((d) NN()).getAppId();
    }

    public final com.tencent.luggage.sdk.d.d NP() {
        if (NN() == null) {
            return null;
        }
        return ((d) NN()).NP();
    }

    @Override // com.tencent.luggage.sdk.b.a.a.AbstractC0178a
    public final <T> T S(Class<T> cls) {
        if (ICommLibReader.class.equals(cls)) {
            return cls.cast(((d) NN()).bqZ());
        }
        return cls.isInstance(this) ? cls.cast(this) : (T) super.S(cls);
    }

    public final a Oz() {
        return this.cBl;
    }

    public final void Om() {
        ((d) NN()).Om();
    }

    /* access modifiers changed from: protected */
    public final AppBrandCommonBindingJniParams OA() {
        v vVar = (v) U(v.class);
        if (vVar == null) {
            Log.e("Luggage.BaseAppBrandServiceLogic", "add on v8 not ready!");
            return null;
        }
        AppBrandCommonBindingJniParams appBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
        appBrandCommonBindingJniParams.jsContext = vVar.XK();
        appBrandCommonBindingJniParams.jsEngine = vVar.getIsolatePtr();
        appBrandCommonBindingJniParams.uvLoop = vVar.getUVLoopPtr();
        appBrandCommonBindingJniParams.wasmCachePath = OB();
        return appBrandCommonBindingJniParams;
    }

    /* access modifiers changed from: package-private */
    public final <T extends j> T U(Class<T> cls) {
        if (NN() != null && ((d) NN()).getJsRuntime() != null) {
            return (T) ((d) NN()).getJsRuntime().R(cls);
        }
        Log.w("Luggage.BaseAppBrandServiceLogic", "hy: js runtime not ready");
        return null;
    }

    /* access modifiers changed from: protected */
    public i Mk() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void Ml() {
        Log.i("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created");
        j(new Runnable() {
            /* class com.tencent.luggage.sdk.b.a.c.f.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(229858);
                Log.i("Luggage.BaseAppBrandServiceLogic", "hy: base service js runtime post created run");
                v vVar = (v) f.this.U(v.class);
                if (vVar == null) {
                    Log.e("Luggage.BaseAppBrandServiceLogic", "hy: v8 not ready or released!");
                    AppMethodBeat.o(229858);
                    return;
                }
                f.this.cBl.cAE.notifyCreate(f.this.OA());
                f.this.cBl.cAF.bindTo(vVar.getIsolatePtr(), vVar.XK());
                k kVar = (k) f.this.U(k.class);
                if (kVar != null) {
                    kVar.a(new y() {
                        /* class com.tencent.luggage.sdk.b.a.c.f.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.m.y
                        public final ByteBuffer dI(String str) {
                            AppMethodBeat.i(229857);
                            ByteBuffer dI = f.this.cBl.cAF.dI(str);
                            AppMethodBeat.o(229857);
                            return dI;
                        }
                    });
                    AppMethodBeat.o(229858);
                    return;
                }
                Log.w("Luggage.BaseAppBrandServiceLogic", "hy: buffer url addon not exist!");
                AppMethodBeat.o(229858);
            }
        });
    }

    private void j(Runnable runnable) {
        q qVar = (q) U(q.class);
        if (qVar == null) {
            Log.w("Luggage.BaseAppBrandServiceLogic", "hy: no js thread addon. may be remote debug env");
        } else {
            qVar.post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void c(final AppBrandRuntime appBrandRuntime) {
        j(new Runnable() {
            /* class com.tencent.luggage.sdk.b.a.c.f.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(229859);
                f.this.cBl.cAE.notifyRuntimeReady(f.this.getAppId(), appBrandRuntime.OT().leE.md5);
                AppMethodBeat.o(229859);
            }
        });
    }

    /* access modifiers changed from: protected */
    public String OB() {
        return "";
    }

    /* access modifiers changed from: protected */
    public void MB() {
    }

    /* access modifiers changed from: protected */
    public void Mm() {
        if (NN() == null || ((d) NN()).getJsRuntime() == null) {
            Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js runtime released when destroy");
            return;
        }
        m mVar = (m) U(m.class);
        if (mVar == null) {
            Log.w("Luggage.BaseAppBrandServiceLogic", "hy: no AppBrandJsRuntimeAddonDestroyListener");
        } else {
            mVar.a(new m.a() {
                /* class com.tencent.luggage.sdk.b.a.c.f.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.m.m.a
                public final void onDestroy() {
                    AppMethodBeat.i(229860);
                    Log.i("Luggage.BaseAppBrandServiceLogic", "hy: common binding triggered destroy");
                    f.this.cBl.cAF.destroy();
                    f.this.cBl.cAE.notifyDestroy();
                    AppMethodBeat.o(229860);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void Mn() {
    }

    /* access modifiers changed from: protected */
    public Map<String, p> Nf() {
        return null;
    }

    public void Mx() {
        j(new Runnable() {
            /* class com.tencent.luggage.sdk.b.a.c.f.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(229861);
                f.this.cBl.cAE.notifyPause();
                AppMethodBeat.o(229861);
            }
        });
    }

    public void Mw() {
        j(new Runnable() {
            /* class com.tencent.luggage.sdk.b.a.c.f.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(229862);
                f.this.cBl.cAE.notifyResume();
                AppMethodBeat.o(229862);
            }
        });
    }

    public void c(JSONObject jSONObject) {
    }

    public String dH(String str) {
        return null;
    }

    public boolean j(int i2, String str) {
        return false;
    }

    public boolean d(String str, String str2, int i2) {
        return false;
    }

    public void d(JSONObject jSONObject) {
    }

    static /* synthetic */ q a(f fVar) {
        i jsRuntime = ((d) fVar.NN()).getJsRuntime();
        if (jsRuntime != null) {
            return (q) jsRuntime.R(q.class);
        }
        Log.e("Luggage.BaseAppBrandServiceLogic", "hy: js runtime not installed");
        return null;
    }
}
