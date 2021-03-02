package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.ab;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "plugin-appbrand-integration_release"})
public final class a extends d<com.tencent.mm.plugin.appbrand.service.c> {
    public static final int CTRL_INDEX = -1;
    public static final String NAME = "hideSplashScreenshot";
    public static final C0660a lUf = new C0660a((byte) 0);

    static {
        AppMethodBeat.i(228398);
        AppMethodBeat.o(228398);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiHideSplashScreenshot$Constants;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.a$a  reason: collision with other inner class name */
    public static final class C0660a {
        private C0660a() {
        }

        public /* synthetic */ C0660a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, int i2) {
        q runtime;
        AppMethodBeat.i(228397);
        com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        if (cVar2 == null || (runtime = cVar2.getRuntime()) == null) {
            new c(this, cVar2, i2).invoke();
            AppMethodBeat.o(228397);
            return;
        }
        runtime.P(new b(this, runtime, cVar2, i2));
        AppMethodBeat.o(228397);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ q kAi;
        final /* synthetic */ a lUg;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.service.c lUh;
        final /* synthetic */ int lyo;

        b(a aVar, q qVar, com.tencent.mm.plugin.appbrand.service.c cVar, int i2) {
            this.lUg = aVar;
            this.kAi = qVar;
            this.lUh = cVar;
            this.lyo = i2;
        }

        public final void run() {
            AppMethodBeat.i(228395);
            ab brK = this.kAi.brK();
            if (brK == null) {
                this.lUh.i(this.lyo, this.lUg.Zf("fail: timeout"));
                AppMethodBeat.o(228395);
            } else if (brK instanceof aa) {
                this.kAi.brr();
                this.lUh.i(this.lyo, this.lUg.Zf("ok"));
                AppMethodBeat.o(228395);
            } else {
                this.lUh.i(this.lyo, this.lUg.Zf("fail: screenshot invalid"));
                AppMethodBeat.o(228395);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ a lUg;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.service.c lUh;
        final /* synthetic */ int lyo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, com.tencent.mm.plugin.appbrand.service.c cVar, int i2) {
            super(0);
            this.lUg = aVar;
            this.lUh = cVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(228396);
            com.tencent.mm.plugin.appbrand.service.c cVar = this.lUh;
            if (cVar != null) {
                cVar.i(this.lyo, this.lUg.Zf("fail:internal error"));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(228396);
            return xVar;
        }
    }
}
