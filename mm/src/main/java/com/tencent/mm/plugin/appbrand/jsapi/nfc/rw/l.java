package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class l extends d<f> {
    public static final int CTRL_INDEX = 792;
    public static final String NAME = "NFCTransceive";
    public static final a mik = new a((byte) 0);

    static {
        AppMethodBeat.i(183651);
        AppMethodBeat.o(183651);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<e<byte[]>, x> {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ l mil;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(l lVar, f fVar, int i2) {
            super(1);
            this.mil = lVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e<byte[]> eVar) {
            AppMethodBeat.i(183649);
            e<byte[]> eVar2 = eVar;
            p.h(eVar2, "result");
            Log.d("MicroMsg.AppBrand.JsApiNFCTransceive", "transceive, result: ".concat(String.valueOf(eVar2)));
            if (eVar2 instanceof e.b) {
                this.lyn.i(this.lyo, this.mil.a(this.lyn, "ok", ae.f(s.U("data", com.tencent.mm.plugin.appbrand.utils.x.aP((byte[]) ((e.b) eVar2).miW)))));
            } else if (eVar2 instanceof e.a) {
                this.lyn.i(this.lyo, this.mil.n("fail:" + ((e.a) eVar2).errMsg, ae.g(s.U("errCode", Integer.valueOf(((e.a) eVar2).errCode)))));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(183649);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCTransceive$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_RESULT_DATA", "PARAM_TECH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(183650);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, env is null");
            AppMethodBeat.o(183650);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, data is null");
            fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
            AppMethodBeat.o(183650);
        } else {
            ai aiVar = (ai) com.tencent.luggage.a.e.M(ai.class);
            if (aiVar == null || aiVar.bEm()) {
                c.a aVar = c.miO;
                c w = c.a.w(fVar);
                if (w == null) {
                    Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, can not get activity");
                    fVar.i(i2, n("fail:unknown", ae.g(s.U("errCode", 13010))));
                    AppMethodBeat.o(183650);
                    return;
                }
                Log.d("MicroMsg.AppBrand.JsApiNFCTransceive", "invoke, appId: " + fVar.getAppId() + ", data: " + jSONObject);
                try {
                    String string = jSONObject.getString("tech");
                    try {
                        Object obj = jSONObject.get("data");
                        if (obj == null) {
                            t tVar = new t("null cannot be cast to non-null type java.nio.ByteBuffer");
                            AppMethodBeat.o(183650);
                            throw tVar;
                        }
                        byte[] p = com.tencent.mm.plugin.appbrand.ac.d.p((ByteBuffer) obj);
                        p.g(string, "tech");
                        p.g(p, "reqData");
                        b bVar = new b(this, fVar, i2);
                        p.h(string, "techName");
                        p.h(p, "reqData");
                        p.h(bVar, "callback");
                        StringBuilder append = new StringBuilder("transceive, techName: ").append(string).append(", reqData: ");
                        String arrays = Arrays.toString(p);
                        p.g(arrays, "java.util.Arrays.toString(this)");
                        Log.d("MicroMsg.AppBrand.NFCReadWriteManager", append.append(arrays).toString());
                        h.RTc.b(new c.m(w, bVar, string, p), "NFC-IO");
                        AppMethodBeat.o(183650);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "parse data failed since ".concat(String.valueOf(e2)));
                        fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
                        AppMethodBeat.o(183650);
                    }
                } catch (Exception e3) {
                    Log.w("MicroMsg.AppBrand.JsApiNFCTransceive", "parse tech failed");
                    fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
                    AppMethodBeat.o(183650);
                }
            } else {
                fVar.i(i2, n("fail:user is not authorized", ae.g(s.U("errCode", 13019))));
                AppMethodBeat.o(183650);
            }
        }
    }
}
