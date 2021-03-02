package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.bl;
import com.tencent.mm.plugin.appbrand.platform.window.e;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0014¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/PrivateJsApiSetPageOrientation;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageExtensionBased;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/page/MPPageViewOrientationExtensionImpl;", "()V", "invokeByExt", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "ext", "Companion", "luggage-wechat-full-sdk_release"})
public class ap extends k<d, bl> {
    public static final int CTRL_INDEX = 584;
    public static final String NAME = "private_setPageOrientation";
    @Deprecated
    public static final a mlB = new a((byte) 0);

    static {
        AppMethodBeat.i(147954);
        AppMethodBeat.o(147954);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.d, org.json.JSONObject, int, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.k
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2, bl blVar) {
        AppMethodBeat.i(147953);
        bl blVar2 = blVar;
        p.h(dVar, "env");
        p.h(jSONObject, "data");
        p.h(blVar2, "ext");
        String optString = jSONObject.optString("orientation", null);
        if (optString == null) {
            new c(this, dVar, i2).invoke();
            AppMethodBeat.o(147953);
        } else if (e.b.aeE(optString) == null) {
            new b(this, dVar, i2).invoke();
            AppMethodBeat.o(147953);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(getName(), optString);
            blVar2.r(optString, hashMap);
            dVar.i(i2, Zf("ok"));
            AppMethodBeat.o(147953);
        }
    }

    public ap() {
        super(bl.class);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/PrivateJsApiSetPageOrientation$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wechat-full-sdk_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d lBv;
        final /* synthetic */ int lyo;
        final /* synthetic */ ap mlC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ap apVar, d dVar, int i2) {
            super(0);
            this.mlC = apVar;
            this.lBv = dVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(147952);
            this.lBv.i(this.lyo, this.mlC.Zf("fail:invalid data"));
            x xVar = x.SXb;
            AppMethodBeat.o(147952);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d lBv;
        final /* synthetic */ int lyo;
        final /* synthetic */ ap mlC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ap apVar, d dVar, int i2) {
            super(0);
            this.mlC = apVar;
            this.lBv = dVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(147951);
            this.lBv.i(this.lyo, this.mlC.Zf("fail:invalid data"));
            x xVar = x.SXb;
            AppMethodBeat.o(147951);
            return xVar;
        }
    }
}
