package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.ae;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017BY\u0012R\u0010\u0003\u001aN\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012/\u0012-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0007j\b\u0012\u0004\u0012\u00020\t`\r\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\u000e¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002RZ\u0010\u0003\u001aN\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012/\u0012-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0007j\b\u0012\u0004\u0012\u00020\t`\r\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\u000e¢\u0006\u0002\b\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "function", "Lkotlin/Function3;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/ConnectClosePrototype;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class a extends d<f> {
    public static final C0686a mhL = new C0686a((byte) 0);
    private final q<c, String, kotlin.g.a.b<? super e<x>, x>, x> mhK;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.b<e<x>, x> {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ a mhM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, f fVar, int i2) {
            super(1);
            this.mhM = aVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e<x> eVar) {
            AppMethodBeat.i(207112);
            e<x> eVar2 = eVar;
            p.h(eVar2, "result");
            Log.d("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "transceive, result: ".concat(String.valueOf(eVar2)));
            if (eVar2 instanceof e.b) {
                this.lyn.i(this.lyo, this.mhM.Zf("ok"));
            } else if (eVar2 instanceof e.a) {
                this.lyn.i(this.lyo, this.mhM.n("fail:" + ((e.a) eVar2).errMsg, ae.g(s.U("errCode", Integer.valueOf(((e.a) eVar2).errCode)))));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(207112);
            return xVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.g.a.q<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c, ? super java.lang.String, ? super kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<kotlin.x>, kotlin.x>, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(q<? super c, ? super String, ? super kotlin.g.a.b<? super e<x>, x>, x> qVar) {
        p.h(qVar, "function");
        this.mhK = qVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCConnectClose$Companion;", "", "()V", "PARAM_TECH", "", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a$a  reason: collision with other inner class name */
    public static final class C0686a {
        private C0686a() {
        }

        public /* synthetic */ C0686a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, env is null");
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, data is null");
            fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
        } else {
            ai aiVar = (ai) com.tencent.luggage.a.e.M(ai.class);
            if (aiVar == null || aiVar.bEm()) {
                c.a aVar = c.miO;
                c w = c.a.w(fVar);
                if (w == null) {
                    Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, can not get activity");
                    fVar.i(i2, n("fail:unknown", ae.g(s.U("errCode", 13010))));
                    return;
                }
                Log.d("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "invoke, appId: " + fVar.getAppId() + ", data: " + jSONObject);
                try {
                    String string = jSONObject.getString("tech");
                    q<c, String, kotlin.g.a.b<? super e<x>, x>, x> qVar = this.mhK;
                    p.g(string, "tech");
                    qVar.d(w, string, new b(this, fVar, i2));
                } catch (Exception e2) {
                    Log.w("MicroMsg.AppBrand.AbsJsApiNFCConnectClose", "parse tech failed");
                    fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
                }
            } else {
                fVar.i(i2, n("fail:user is not authorized", ae.g(s.U("errCode", 13019))));
            }
        }
    }
}
