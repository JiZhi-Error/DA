package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import android.nfc.NdefMessage;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import kotlin.a.ae;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "onNFCDiscoveredEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "getOnNFCDiscoveredEvent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "onNFCDiscoveredEvent$delegate", "Lkotlin/Lazy;", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class m extends d<f> {
    public static final int CTRL_INDEX = 789;
    public static final String NAME = "startNFCDiscovery";
    public static final a mio = new a((byte) 0);
    private final kotlin.f mim = g.ah(c.mis);

    static {
        AppMethodBeat.i(183657);
        AppMethodBeat.o(183657);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<e<x>, x> {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ m mip;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c miq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m mVar, f fVar, int i2, com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c cVar) {
            super(1);
            this.mip = mVar;
            this.lyn = fVar;
            this.lyo = i2;
            this.miq = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e<x> eVar) {
            AppMethodBeat.i(183654);
            e<x> eVar2 = eVar;
            p.h(eVar2, "result");
            Log.d("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, result: ".concat(String.valueOf(eVar2)));
            if (eVar2 instanceof e.b) {
                this.lyn.i(this.lyo, this.mip.Zf("ok"));
                this.miq.miA = new kotlin.g.a.q<byte[], List<? extends String>, List<? extends NdefMessage>, x>(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.m.b.AnonymousClass1 */
                    final /* synthetic */ b mir;

                    {
                        this.mir = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
                    @Override // kotlin.g.a.q
                    public final /* synthetic */ x d(byte[] bArr, List<? extends String> list, List<? extends NdefMessage> list2) {
                        AppMethodBeat.i(207142);
                        byte[] bArr2 = bArr;
                        List<? extends String> list3 = list;
                        List<? extends NdefMessage> list4 = list2;
                        p.h(list3, "techs");
                        if (list4 != null) {
                            com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c cVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.mju;
                            HashMap hashMap = new HashMap(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.bE(list4));
                            if (x.b.FAIL_SIZE_EXCEED_LIMIT == com.tencent.mm.plugin.appbrand.utils.x.a(this.mir.lyn.getJsRuntime(), hashMap, (x.a) this.mir.lyn.av(x.a.class))) {
                                Log.w("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, convert NativeBuffer fail");
                            } else {
                                m.a(this.mir.mip).v(this.mir.lyn).a(bArr2, (List<String>) list3, (HashMap<String, Object>) hashMap);
                            }
                        } else {
                            c.a(m.a(this.mir.mip).v(this.mir.lyn), bArr2, list3);
                        }
                        kotlin.x xVar = kotlin.x.SXb;
                        AppMethodBeat.o(207142);
                        return xVar;
                    }
                };
            } else if (eVar2 instanceof e.a) {
                this.lyn.i(this.lyo, this.mip.n("fail:" + ((e.a) eVar2).errMsg, ae.g(s.U("errCode", Integer.valueOf(((e.a) eVar2).errCode)))));
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(183654);
            return xVar;
        }
    }

    public m() {
        AppMethodBeat.i(183659);
        AppMethodBeat.o(183659);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiStartNFCDiscovery$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_REQUIRE_FOREGROUND_DISPATCH", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(183658);
        if (fVar == null) {
            AppMethodBeat.o(183658);
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d.bHY()) {
            fVar.i(i2, n("fail:system NFC switch not opened", ae.g(s.U("errCode", 13001))));
            AppMethodBeat.o(183658);
        } else {
            ai aiVar = (ai) com.tencent.luggage.a.e.M(ai.class);
            if (aiVar == null || aiVar.bEm()) {
                c.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.miO;
                com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c w = c.a.w(fVar);
                if (w == null) {
                    Log.w("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "invoke, can not get activity");
                    fVar.i(i2, n("fail:unknown", ae.g(s.U("errCode", 13010))));
                    AppMethodBeat.o(183658);
                    return;
                }
                if (jSONObject != null) {
                    try {
                        w.hK(jSONObject.getBoolean("requireForegroundDispatch"));
                    } catch (Exception e2) {
                        Log.d("MicroMsg.AppBrand.JsApiStartNFCDiscovery", "parse requireForegroundDispatch failed");
                    }
                }
                b bVar = new b(this, fVar, i2, w);
                p.h(bVar, "callback");
                Log.d("MicroMsg.AppBrand.NFCReadWriteManager", NAME);
                h.RTc.aV(new c.k(w, bVar));
                AppMethodBeat.o(183658);
                return;
            }
            fVar.i(i2, n("fail:user is not authorized", ae.g(s.U("errCode", 13019))));
            AppMethodBeat.o(183658);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<c> {
        public static final c mis = new c();

        static {
            AppMethodBeat.i(183656);
            AppMethodBeat.o(183656);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ c invoke() {
            AppMethodBeat.i(183655);
            c cVar = new c();
            AppMethodBeat.o(183655);
            return cVar;
        }
    }

    public static final /* synthetic */ c a(m mVar) {
        AppMethodBeat.i(183660);
        c cVar = (c) mVar.mim.getValue();
        AppMethodBeat.o(183660);
        return cVar;
    }
}
