package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoAsync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class j extends d<com.tencent.mm.plugin.appbrand.d> {
    private static final int CTRL_INDEX = 919;
    private static final String NAME = "getSystemInfoAsync";
    @Deprecated
    public static final a mtX = new a((byte) 0);

    static {
        AppMethodBeat.i(230106);
        AppMethodBeat.o(230106);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetSystemInfoAsync$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wechat-full-sdk_release"})
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
        AppMethodBeat.i(230105);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        p Ze = dVar2 != null ? dVar2.Ze("getSystemInfo") : null;
        if (!(Ze instanceof i)) {
            Ze = null;
        }
        i iVar = (i) Ze;
        if (iVar == null) {
            new b(this, dVar2, i2).invoke();
            AppMethodBeat.o(230105);
            return;
        }
        dVar2.i(i2, n("ok", iVar.a(dVar2)));
        AppMethodBeat.o(230105);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lBv;
        final /* synthetic */ int lyo;
        final /* synthetic */ j mtY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            super(0);
            this.mtY = jVar;
            this.lBv = dVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(230104);
            com.tencent.mm.plugin.appbrand.d dVar = this.lBv;
            if (dVar != null) {
                dVar.i(this.lyo, this.mtY.Zf("fail:not supported"));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(230104);
            return xVar;
        }
    }
}
