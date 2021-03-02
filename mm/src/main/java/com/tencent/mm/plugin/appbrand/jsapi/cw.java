package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.epq;
import com.tencent.mm.protocal.protobuf.epr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-wechat-full-sdk_release"})
public final class cw extends d<s> {
    public static final int CTRL_INDEX = 313;
    public static final String NAME = "verifyPlugin";
    @Deprecated
    public static final a lCt = new a((byte) 0);

    static {
        AppMethodBeat.i(147901);
        AppMethodBeat.o(147901);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/VerifyPluginResponse;", "kotlin.jvm.PlatformType", "onTerminate"})
    static final class c<T> implements d.b<epr> {
        final /* synthetic */ cw lCu;
        final /* synthetic */ String lCv;
        final /* synthetic */ s lCw;
        final /* synthetic */ int lyo;

        c(cw cwVar, String str, s sVar, int i2) {
            this.lCu = cwVar;
            this.lCv = str;
            this.lCw = sVar;
            this.lyo = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.g.d.b
        public final /* synthetic */ void bz(epr epr) {
            AppMethodBeat.i(147899);
            epr epr2 = epr;
            if (epr2 == null) {
                a unused = cw.lCt;
                Log.e("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.lCv + " null response");
                this.lCw.i(this.lyo, this.lCu.Zf("fail:internal error"));
                AppMethodBeat.o(147899);
            } else if (epr2.BaseResponse.Ret != 0) {
                a unused2 = cw.lCt;
                Log.e("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.lCv + " cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(epr2.BaseResponse.Ret), epr2.BaseResponse.ErrMsg);
                this.lCw.i(this.lyo, this.lCu.Zf("fail cgi fail Ret=" + epr2.BaseResponse.Ret));
                AppMethodBeat.o(147899);
            } else {
                HashMap hashMap = new HashMap();
                try {
                    a unused3 = cw.lCt;
                    Log.i("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.lCv + " cgi ok, dataSize[" + epr2.Nnl.length() + ']');
                    hashMap.put("data", new JSONObject(epr2.Nnl));
                    this.lCw.i(this.lyo, this.lCu.n("ok", hashMap));
                    AppMethodBeat.o(147899);
                } catch (Exception e2) {
                    a unused4 = cw.lCt;
                    Log.e("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.lCv + " cgi ok but get exception[" + e2 + ']');
                    this.lCw.i(this.lyo, this.lCu.Zf("fail:internal error ".concat(String.valueOf(e2))));
                    AppMethodBeat.o(147899);
                }
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147900);
        s sVar2 = sVar;
        p.h(sVar2, "service");
        if (jSONObject == null || !jSONObject.has("data")) {
            sVar2.i(i2, Zf("fail:invalid data"));
            AppMethodBeat.o(147900);
            return;
        }
        String str = "appId[" + sVar2.getAppId() + "] callbackId[" + i2 + ']';
        epq epq = new epq();
        epq.dNI = sVar2.getAppId();
        epq.GaN = jSONObject.optString("data");
        com.tencent.mm.plugin.appbrand.networking.c cVar = (com.tencent.mm.plugin.appbrand.networking.c) sVar2.M(com.tencent.mm.plugin.appbrand.networking.c.class);
        if (cVar == null) {
            new b(this, str, sVar2, i2).invoke();
            AppMethodBeat.o(147900);
            return;
        }
        cVar.a("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", epq, epr.class).a(new c(this, str, sVar2, i2));
        AppMethodBeat.o(147900);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiVerifyPlugin$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ cw lCu;
        final /* synthetic */ String lCv;
        final /* synthetic */ s lCw;
        final /* synthetic */ int lyo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(cw cwVar, String str, s sVar, int i2) {
            super(0);
            this.lCu = cwVar;
            this.lCv = str;
            this.lCw = sVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(147898);
            a unused = cw.lCt;
            Log.e("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.lCv + " NULL cgiService");
            this.lCw.i(this.lyo, this.lCu.Zf("fail:internal error"));
            x xVar = x.SXb;
            AppMethodBeat.o(147898);
            return xVar;
        }
    }
}
