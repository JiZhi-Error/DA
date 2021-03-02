package com.tencent.mm.plugin.appbrand.h;

import android.content.Context;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONObject;

public final class b implements a {
    public JSONObject lnV;
    public int lqe;
    public p lqf;
    public f lqg;
    private i.d lqh;
    private i.b lqi;
    private i.c lqj;

    public b(int i2, JSONObject jSONObject, f fVar, p pVar) {
        this.lqe = i2;
        this.lnV = jSONObject;
        this.lqg = fVar;
        this.lqf = pVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final String getAppId() {
        AppMethodBeat.i(139385);
        if (this.lqg != null) {
            String appId = this.lqg.getAppId();
            AppMethodBeat.o(139385);
            return appId;
        }
        AppMethodBeat.o(139385);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final Context getContext() {
        AppMethodBeat.i(139386);
        if (this.lqg != null) {
            Context context = this.lqg.getContext();
            AppMethodBeat.o(139386);
            return context;
        }
        AppMethodBeat.o(139386);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final boolean Pr() {
        return this.lqf instanceof ab;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final JSONObject Ps() {
        AppMethodBeat.i(139387);
        if (this.lnV != null) {
            JSONObject jSONObject = this.lnV;
            AppMethodBeat.o(139387);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        AppMethodBeat.o(139387);
        return jSONObject2;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final String Pt() {
        AppMethodBeat.i(139388);
        if (this.lqf != null) {
            String name = this.lqf.getName();
            AppMethodBeat.o(139388);
            return name;
        }
        AppMethodBeat.o(139388);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final String dP(String str) {
        AppMethodBeat.i(139389);
        if (!(this.lqg == null || this.lqf == null)) {
            this.lqg.i(this.lqe, this.lqf.h(str, null));
        }
        AppMethodBeat.o(139389);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final String f(String str, Map<String, ? extends Object> map) {
        AppMethodBeat.i(139390);
        if (!(this.lqg == null || this.lqf == null)) {
            this.lqg.i(this.lqe, this.lqf.n(str, map));
        }
        AppMethodBeat.o(139390);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final void a(final a.AbstractC0188a aVar) {
        AppMethodBeat.i(139391);
        if (this.lqg instanceof h) {
            Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "addLifecycleListener");
            h hVar = (h) this.lqg;
            this.lqh = new i.d() {
                /* class com.tencent.mm.plugin.appbrand.h.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
                public final void onForeground() {
                    AppMethodBeat.i(139382);
                    Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "onForeground");
                    if (aVar != null) {
                        aVar.onForeground();
                    }
                    AppMethodBeat.o(139382);
                }
            };
            this.lqi = new i.b() {
                /* class com.tencent.mm.plugin.appbrand.h.b.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                public final void onBackground() {
                    AppMethodBeat.i(139383);
                    Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "onBackground");
                    if (aVar != null) {
                        aVar.hU(com.tencent.mm.plugin.appbrand.jsapi.ag.b.abL(b.this.lqg.getAppId()));
                    }
                    AppMethodBeat.o(139383);
                }
            };
            this.lqj = new i.c() {
                /* class com.tencent.mm.plugin.appbrand.h.b.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                public final void onDestroy() {
                    AppMethodBeat.i(139384);
                    if (aVar != null) {
                        aVar.onDestroy();
                    }
                    AppMethodBeat.o(139384);
                }
            };
            hVar.a(this.lqh);
            hVar.a(this.lqi);
            hVar.a(this.lqj);
        }
        AppMethodBeat.o(139391);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final void Pu() {
        AppMethodBeat.i(139392);
        if (this.lqg instanceof h) {
            Log.i("MicroMsg.AppBrand.AppBrandInvokeContext", "removeLifecycleListener");
            h hVar = (h) this.lqg;
            if (this.lqh != null) {
                hVar.b(this.lqh);
                this.lqh = null;
            }
            if (this.lqi != null) {
                hVar.b(this.lqi);
                this.lqi = null;
            }
            if (this.lqj != null) {
                hVar.b(this.lqj);
                this.lqj = null;
            }
        }
        AppMethodBeat.o(139392);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final void b(a.AbstractC0188a aVar) {
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a
    public final f NN() {
        return this.lqg;
    }

    public final JSONObject KX() {
        return this.lnV;
    }

    public final int bCw() {
        return this.lqe;
    }

    public final p bCx() {
        return this.lqf;
    }
}
