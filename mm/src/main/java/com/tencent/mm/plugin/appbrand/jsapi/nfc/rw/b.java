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

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\u0002`\n¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\u0002`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "techName", "", "function", "resultKey", "retConverter", "Lkotlin/Function1;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/RetConverter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public abstract class b extends d<f> {
    public static final a mhR = new a((byte) 0);
    private final String mhN;
    private final String mhO;
    private final String mhP;
    private final kotlin.g.a.b<Object, Object> mhQ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b$b  reason: collision with other inner class name */
    static final class C0688b extends q implements kotlin.g.a.b<e<Object>, x> {
        final /* synthetic */ f lyn;
        final /* synthetic */ int lyo;
        final /* synthetic */ b mhT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0688b(b bVar, f fVar, int i2) {
            super(1);
            this.mhT = bVar;
            this.lyn = fVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(e<Object> eVar) {
            AppMethodBeat.i(207114);
            e<Object> eVar2 = eVar;
            p.h(eVar2, "result");
            Log.d("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, result: ".concat(String.valueOf(eVar2)));
            if (eVar2 instanceof e.b) {
                this.lyn.i(this.lyo, this.mhT.n("ok", ae.g(s.U(this.mhT.mhP, this.mhT.mhQ.invoke(((e.b) eVar2).miW)))));
            } else if (eVar2 instanceof e.a) {
                this.lyn.i(this.lyo, this.mhT.n("fail:" + ((e.a) eVar2).errMsg, ae.g(s.U("errCode", Integer.valueOf(((e.a) eVar2).errCode)))));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(207114);
            return xVar;
        }
    }

    public /* synthetic */ b(String str, String str2, String str3) {
        this(str, str2, str3, AnonymousClass1.mhS);
    }

    public b(String str, String str2, String str3, kotlin.g.a.b<Object, ? extends Object> bVar) {
        p.h(str, "techName");
        p.h(str2, "function");
        p.h(str3, "resultKey");
        p.h(bVar, "retConverter");
        this.mhN = str;
        this.mhO = str2;
        this.mhP = str3;
        this.mhQ = bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync$Companion;", "", "()V", "TAG", "", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, env is null");
            return;
        }
        ai aiVar = (ai) com.tencent.luggage.a.e.M(ai.class);
        if (aiVar == null || aiVar.bEm()) {
            c.a aVar = c.miO;
            c w = c.a.w(fVar);
            if (w == null) {
                Log.w("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, can not get activity");
                fVar.i(i2, Zf("fail:unknown"));
                return;
            }
            Log.i("MicroMsg.AppBrand.AbsJsApiNFCTechGetAsync", "invoke, appId: " + fVar.getAppId());
            String str = this.mhN;
            String str2 = this.mhO;
            C0688b bVar = new C0688b(this, fVar, i2);
            p.h(str, "techName");
            p.h(str2, "function");
            p.h(bVar, "callback");
            Log.d("MicroMsg.AppBrand.NFCReadWriteManager", "execTechLogicAsync, techName: " + str + ", function: " + str2 + ", params: " + ((Object) null));
            h.RTc.b(new c.f(w, bVar, str, str2), "NFC-IO");
            return;
        }
        fVar.i(i2, n("fail:user is not authorized", ae.g(s.U("errCode", 13019))));
    }
}
