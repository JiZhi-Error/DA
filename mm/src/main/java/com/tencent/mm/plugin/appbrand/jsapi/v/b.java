package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.r;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/JsApiSaveInitialRenderingCache;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class b extends d<ac> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "saveInitialRenderingCache";
    @Deprecated
    public static final a moW = new a((byte) 0);

    static {
        AppMethodBeat.i(147960);
        AppMethodBeat.o(147960);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rendering_cache/JsApiSaveInitialRenderingCache$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-wechat-full-sdk_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147959);
        ac acVar2 = acVar;
        com.tencent.mm.plugin.appbrand.page.web_renderingcache.a aVar = acVar2 != null ? (com.tencent.mm.plugin.appbrand.page.web_renderingcache.a) acVar2.M(com.tencent.mm.plugin.appbrand.page.web_renderingcache.a.class) : null;
        if (aVar == null) {
            new C0707b(this, acVar2, i2).invoke();
            AppMethodBeat.o(147959);
        } else if (jSONObject == null) {
            new c(this, acVar2, i2).invoke();
            AppMethodBeat.o(147959);
        } else {
            String optString = jSONObject.optString("path", acVar2.getURL());
            try {
                r rVar = new r(jSONObject.getString("content"), jSONObject.optString("webviewData", null), jSONObject.optString("appserviceData", null));
                aVar.i(optString, rVar.first, rVar.second, rVar.SWY);
                acVar2.i(i2, Zf("ok"));
                AppMethodBeat.o(147959);
            } catch (JSONException e2) {
                acVar2.i(i2, Zf("fail:invalid data"));
                AppMethodBeat.o(147959);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.v.b$b  reason: collision with other inner class name */
    static final class C0707b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ac lIn;
        final /* synthetic */ int lyo;
        final /* synthetic */ b moX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0707b(b bVar, ac acVar, int i2) {
            super(0);
            this.moX = bVar;
            this.lIn = acVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(147957);
            ac acVar = this.lIn;
            if (acVar != null) {
                acVar.i(this.lyo, this.moX.Zf("fail:not supported"));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(147957);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ac lIn;
        final /* synthetic */ int lyo;
        final /* synthetic */ b moX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, ac acVar, int i2) {
            super(0);
            this.moX = bVar;
            this.lIn = acVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(147958);
            this.lIn.i(this.lyo, this.moX.Zf("fail:invalid data"));
            x xVar = x.SXb;
            AppMethodBeat.o(147958);
            return xVar;
        }
    }
}
