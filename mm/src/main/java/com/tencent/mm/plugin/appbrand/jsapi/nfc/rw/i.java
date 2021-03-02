package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCGetMaxTransceiveLength;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class i extends d<f> {
    public static final int CTRL_INDEX = 791;
    public static final String NAME = "NFCGetMaxTransceiveLength";
    public static final a mif = new a((byte) 0);

    static {
        AppMethodBeat.i(183648);
        AppMethodBeat.o(183648);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<e<Integer>, x> {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ i mig;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar, f fVar, int i2) {
            super(1);
            this.mig = iVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e<Integer> eVar) {
            AppMethodBeat.i(183646);
            e<Integer> eVar2 = eVar;
            p.h(eVar2, "result");
            Log.d("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "getMaxTransceiveLength, result: ".concat(String.valueOf(eVar2)));
            if (eVar2 instanceof e.b) {
                this.lyn.i(this.lyo, this.mig.n("ok", ae.g(s.U("length", ((e.b) eVar2).miW))));
            } else if (eVar2 instanceof e.a) {
                this.lyn.i(this.lyo, this.mig.n("fail:" + ((e.a) eVar2).errMsg, ae.g(s.U("errCode", Integer.valueOf(((e.a) eVar2).errCode)))));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(183646);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCGetMaxTransceiveLength$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TECH", "RESULT_LENGTH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(183647);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "invoke, env is null");
            AppMethodBeat.o(183647);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "invoke, data is null");
            fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
            AppMethodBeat.o(183647);
        } else {
            ai aiVar = (ai) com.tencent.luggage.a.e.M(ai.class);
            if (aiVar == null || aiVar.bEm()) {
                c.a aVar = c.miO;
                c w = c.a.w(fVar);
                if (w == null) {
                    Log.w("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "invoke, can not get activity");
                    fVar.i(i2, n("fail:unknown", ae.g(s.U("errCode", 13010))));
                    AppMethodBeat.o(183647);
                    return;
                }
                Log.i("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "invoke, appId: " + fVar.getAppId() + ", data: " + jSONObject);
                try {
                    String string = jSONObject.getString("tech");
                    p.g(string, "tech");
                    b bVar = new b(this, fVar, i2);
                    p.h(string, "techName");
                    p.h(bVar, "callback");
                    Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "getMaxTransceiveLength, techName: ".concat(String.valueOf(string)));
                    h.RTc.b(new c.g(w, bVar, string), "NFC-IO");
                    AppMethodBeat.o(183647);
                } catch (Exception e2) {
                    Log.w("MicroMsg.AppBrand.JsApiNFCGetMaxTransceiveLength", "parse tech failed");
                    fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
                    AppMethodBeat.o(183647);
                }
            } else {
                fVar.i(i2, n("fail:user is not authorized", ae.g(s.U("errCode", 13019))));
                AppMethodBeat.o(183647);
            }
        }
    }
}
