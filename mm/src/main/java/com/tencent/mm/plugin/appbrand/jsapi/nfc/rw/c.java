package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016JH\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2(\b\u0002\u0010\n\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u0001`\rJ\u0012\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "dispatch", "", "id", "", "techs", "", "", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "setContext", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class c extends bc {
    public static final int CTRL_INDEX = 790;
    public static final String NAME = "onNFCDiscovered";
    public static final a mhU = new a((byte) 0);

    static {
        AppMethodBeat.i(183645);
        AppMethodBeat.o(183645);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bc
    public final /* synthetic */ bc h(f fVar) {
        AppMethodBeat.i(183644);
        c v = v(fVar);
        AppMethodBeat.o(183644);
        return v;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiEventOnNFCDiscovered$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_ID", "PARAM_TECHS", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(c cVar, byte[] bArr, List list) {
        AppMethodBeat.i(207116);
        cVar.a(bArr, list, (HashMap<String, Object>) null);
        AppMethodBeat.o(207116);
    }

    public final void a(byte[] bArr, List<String> list, HashMap<String, Object> hashMap) {
        HashMap<String, Object> e2;
        AppMethodBeat.i(207115);
        p.h(list, "techs");
        if (bArr == null) {
            bArr = new byte[0];
        }
        byte[] encode = Base64.encode(bArr, 2);
        p.g(encode, "Base64.encode(id ?: ByteArray(0), Base64.NO_WRAP)");
        Charset charset = StandardCharsets.UTF_8;
        p.g(charset, "StandardCharsets.UTF_8");
        String str = new String(encode, charset);
        if (hashMap != null) {
            hashMap.put("id", str);
            hashMap.put("techs", list);
            if (hashMap != null) {
                e2 = hashMap;
                L(e2).bEo();
                AppMethodBeat.o(207115);
            }
        }
        e2 = ae.e(s.U("id", str), s.U("techs", list));
        L(e2).bEo();
        AppMethodBeat.o(207115);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.bc
    public final void bEo() {
        AppMethodBeat.i(183642);
        Log.d("MicroMsg.AppBrand.JsApiEventOnNFCDiscovered", "dispatch, data: " + getData());
        super.bEo();
        AppMethodBeat.o(183642);
    }

    public final c v(f fVar) {
        AppMethodBeat.i(183643);
        bc h2 = super.h(fVar);
        if (h2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.JsApiEventOnNFCDiscovered");
            AppMethodBeat.o(183643);
            throw tVar;
        }
        c cVar = (c) h2;
        AppMethodBeat.o(183643);
        return cVar;
    }
}
