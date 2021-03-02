package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import android.nfc.NdefMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class o extends d<f> {
    public static final int CTRL_INDEX = 793;
    public static final String NAME = "writeNdefMessage";
    public static final a miv = new a((byte) 0);

    static {
        AppMethodBeat.i(183668);
        AppMethodBeat.o(183668);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<e<x>, x> {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ o miw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o oVar, f fVar, int i2) {
            super(1);
            this.miw = oVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e<x> eVar) {
            AppMethodBeat.i(183666);
            e<x> eVar2 = eVar;
            p.h(eVar2, "result");
            Log.d("MicroMsg.AppBrand.JsApiWriteNdefMessage", "writeNdefMessage, result: ".concat(String.valueOf(eVar2)));
            if (eVar2 instanceof e.b) {
                this.lyn.i(this.lyo, this.miw.Zf("ok"));
            } else if (eVar2 instanceof e.a) {
                this.lyn.i(this.lyo, this.miw.n("fail:" + ((e.a) eVar2).errMsg, ae.g(s.U("errCode", Integer.valueOf(((e.a) eVar2).errCode)))));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(183666);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TEXTS", "PARAM_URIS", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(183667);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
            AppMethodBeat.o(183667);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
            fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
            AppMethodBeat.o(183667);
        } else {
            ai aiVar = (ai) com.tencent.luggage.a.e.M(ai.class);
            if (aiVar == null || aiVar.bEm()) {
                c.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.miO;
                com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c w = c.a.w(fVar);
                if (w == null) {
                    Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
                    fVar.i(i2, n("fail:unknown", ae.g(s.U("errCode", 13010))));
                    AppMethodBeat.o(183667);
                    return;
                }
                b bVar = new b(this, fVar, i2);
                Log.d("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, appId: " + fVar.getAppId() + ", data: " + jSONObject);
                if (jSONObject.has("uris")) {
                    try {
                        Object obj = jSONObject.get("uris");
                        if (obj == null) {
                            t tVar = new t("null cannot be cast to non-null type org.json.JSONArray");
                            AppMethodBeat.o(183667);
                            throw tVar;
                        }
                        JSONArray jSONArray = (JSONArray) obj;
                        ArrayList arrayList = new ArrayList(jSONArray.length());
                        int length = jSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            Object obj2 = jSONArray.get(i3);
                            p.g(obj2, "get(index)");
                            arrayList.add(obj2.toString());
                        }
                        com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c cVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.mju;
                        NdefMessage bF = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.bF(arrayList);
                        if (bF == null) {
                            fVar.i(i2, n("fail:parse NdefMessage failed", ae.g(s.U("errCode", 13012))));
                            AppMethodBeat.o(183667);
                            return;
                        }
                        w.a(bF, bVar);
                        AppMethodBeat.o(183667);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse uris failed since ".concat(String.valueOf(e2)));
                        fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
                        AppMethodBeat.o(183667);
                    }
                } else if (jSONObject.has("texts")) {
                    try {
                        Object obj3 = jSONObject.get("texts");
                        if (obj3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type org.json.JSONArray");
                            AppMethodBeat.o(183667);
                            throw tVar2;
                        }
                        JSONArray jSONArray2 = (JSONArray) obj3;
                        ArrayList arrayList2 = new ArrayList(jSONArray2.length());
                        int length2 = jSONArray2.length();
                        for (int i4 = 0; i4 < length2; i4++) {
                            Object obj4 = jSONArray2.get(i4);
                            p.g(obj4, "get(index)");
                            if (!(obj4 instanceof JSONObject)) {
                                obj4 = null;
                            }
                            JSONObject jSONObject2 = (JSONObject) obj4;
                            if (jSONObject2 == null) {
                                Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since convert jsonObject failed");
                                fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
                                AppMethodBeat.o(183667);
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            Iterator<String> keys = jSONObject2.keys();
                            p.g(keys, "keys()");
                            while (keys.hasNext()) {
                                String next = keys.next();
                                p.g(next, LocaleUtil.ITALIAN);
                                Object obj5 = jSONObject2.get(next);
                                p.g(obj5, "get(it)");
                                hashMap.put(next, obj5.toString());
                            }
                            arrayList2.add(hashMap);
                        }
                        com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c cVar2 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.mju;
                        NdefMessage bG = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.bG(arrayList2);
                        if (bG == null) {
                            fVar.i(i2, n("fail:parse NdefMessage failed", ae.g(s.U("errCode", 13012))));
                            AppMethodBeat.o(183667);
                            return;
                        }
                        w.a(bG, bVar);
                        AppMethodBeat.o(183667);
                    } catch (Exception e3) {
                        Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since ".concat(String.valueOf(e3)));
                        fVar.i(i2, n("fail:invalid parameter", ae.g(s.U("errCode", 13011))));
                        AppMethodBeat.o(183667);
                    }
                } else {
                    Map<String, Object> a2 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b.a.a(jSONObject, c.mix);
                    com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c cVar3 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.mju;
                    NdefMessage Q = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.Q(a2);
                    if (Q == null) {
                        fVar.i(i2, n("fail:parse NdefMessage failed", ae.g(s.U("errCode", 13012))));
                        AppMethodBeat.o(183667);
                        return;
                    }
                    w.a(Q, bVar);
                    AppMethodBeat.o(183667);
                }
            } else {
                fVar.i(i2, n("fail:user is not authorized", ae.g(s.U("errCode", 13019))));
                AppMethodBeat.o(183667);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
    static final class c extends q implements kotlin.g.a.b<Object, Object> {
        public static final c mix = new c();

        static {
            AppMethodBeat.i(207144);
            AppMethodBeat.o(207144);
        }

        c() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final Object invoke(Object obj) {
            AppMethodBeat.i(207143);
            p.h(obj, LocaleUtil.ITALIAN);
            AppMethodBeat.o(207143);
            return obj;
        }
    }
}
