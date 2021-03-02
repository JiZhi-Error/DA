package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPredownloadMiniProgramPackage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ck extends d<d> {
    public static final int CTRL_INDEX = 678;
    public static final String NAME = "predownloadMiniProgramPackage";
    @Deprecated
    public static final a lBt = new a((byte) 0);

    static {
        AppMethodBeat.i(50409);
        AppMethodBeat.o(50409);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiPredownloadMiniProgramPackage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50408);
        d dVar2 = dVar;
        if (jSONObject == null) {
            AppMethodBeat.o(50408);
        } else if (dVar2 == null) {
            AppMethodBeat.o(50408);
        } else {
            String optString = jSONObject.optString(ch.COL_USERNAME);
            if (optString == null) {
                new b(this, dVar2, i2).invoke();
                AppMethodBeat.o(50408);
                return;
            }
            XIPCInvoker.a(MainProcessIPCService.dkO, new TaskParamsCallPredownload(optString, jSONObject.optString("path"), jSONObject.optInt("scene", 0)), dd.class, new c(this, dVar2, i2));
            AppMethodBeat.o(50408);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ck lBu;
        final /* synthetic */ d lBv;
        final /* synthetic */ int lyo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ck ckVar, d dVar, int i2) {
            super(0);
            this.lBu = ckVar;
            this.lBv = dVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50406);
            this.lBv.i(this.lyo, this.lBu.Zf("fail:invalid data"));
            x xVar = x.SXb;
            AppMethodBeat.o(50406);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class c<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ ck lBu;
        final /* synthetic */ d lBv;
        final /* synthetic */ int lyo;

        c(ck ckVar, d dVar, int i2) {
            this.lBu = ckVar;
            this.lBv = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(50407);
            this.lBv.i(this.lyo, this.lBu.Zf("ok"));
            AppMethodBeat.o(50407);
        }
    }
}
