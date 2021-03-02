package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.page.ac;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiHideHomeButton;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wxa-app-jsapi_release"})
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 684;
    public static final String NAME = "hideHomeButton";
    @Deprecated
    public static final a mkn = new a((byte) 0);

    static {
        AppMethodBeat.i(240921);
        AppMethodBeat.o(240921);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(240920);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        ac i3 = df.i(dVar2);
        if (i3 == null) {
            if (dVar2 == null) {
                p.hyc();
            }
            dVar2.i(i2, Zf("fail:page don't exist"));
            AppMethodBeat.o(240920);
            return;
        }
        h.RTc.aV(new b(this, i3, dVar2, i2));
        AppMethodBeat.o(240920);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiHideHomeButton$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wxa-app-jsapi_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lBv;
        final /* synthetic */ int lyo;
        final /* synthetic */ d mko;
        final /* synthetic */ ac mkp;

        b(d dVar, ac acVar, com.tencent.mm.plugin.appbrand.d dVar2, int i2) {
            this.mko = dVar;
            this.mkp = acVar;
            this.lBv = dVar2;
            this.lyo = i2;
        }

        public final void run() {
            AppMethodBeat.i(240919);
            if (this.mkp.bRi() == null) {
                this.mkp.bRE();
            } else {
                this.mkp.bRF();
            }
            com.tencent.mm.plugin.appbrand.d dVar = this.lBv;
            if (dVar == null) {
                p.hyc();
            }
            dVar.i(this.lyo, this.mko.Zf("ok"));
            AppMethodBeat.o(240919);
        }
    }
}
