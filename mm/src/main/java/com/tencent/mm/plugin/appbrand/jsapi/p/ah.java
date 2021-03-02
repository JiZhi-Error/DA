package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiShowNavigationBar;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class ah extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 577;
    public static final String NAME = "showNavigationBar";
    @Deprecated
    public static final a mlt = new a((byte) 0);

    static {
        AppMethodBeat.i(138290);
        AppMethodBeat.o(138290);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiShowNavigationBar$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app-jsapi_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138289);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(138289);
            return;
        }
        b bVar = new b(this, dVar2, i2);
        if ((dVar2 instanceof ac) || !dVar2.getRuntime().bry()) {
            bVar.run();
            AppMethodBeat.o(138289);
            return;
        }
        dVar2.getRuntime().O(bVar);
        AppMethodBeat.o(138289);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lBv;
        final /* synthetic */ int lyo;
        final /* synthetic */ ah mlu;

        b(ah ahVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.mlu = ahVar;
            this.lBv = dVar;
            this.lyo = i2;
        }

        public final void run() {
            ac acVar;
            AppMethodBeat.i(138288);
            com.tencent.mm.plugin.appbrand.d dVar = this.lBv;
            if (dVar instanceof ac) {
                acVar = (ac) this.lBv;
            } else if (dVar instanceof s) {
                acVar = ((s) this.lBv).getCurrentPageView();
            } else {
                acVar = null;
            }
            if (acVar == null) {
                new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.p.ah.b.AnonymousClass1 */
                    final /* synthetic */ b mlv;

                    {
                        this.mlv = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(138287);
                        this.mlv.lBv.i(this.mlv.lyo, this.mlv.mlu.Zf("fail:page don't exist"));
                        x xVar = x.SXb;
                        AppMethodBeat.o(138287);
                        return xVar;
                    }
                }.invoke();
                AppMethodBeat.o(138288);
                return;
            }
            acVar.bRu();
            this.lBv.i(this.lyo, this.mlu.Zf("ok"));
            AppMethodBeat.o(138288);
        }
    }
}
