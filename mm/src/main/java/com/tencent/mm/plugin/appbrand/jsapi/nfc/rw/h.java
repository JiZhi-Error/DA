package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCGetHistoricalBytes;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/AbsJsApiNFCTechGetAsync;", "()V", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class h extends b {
    public static final int CTRL_INDEX = 842;
    public static final String NAME = "NFCGetHistoricalBytes";
    public static final a mid = new a((byte) 0);

    static {
        AppMethodBeat.i(207137);
        AppMethodBeat.o(207137);
    }

    public h() {
        super(b.ISO_DEP.mhN, "getHistoricalBytes", "histBytes", AnonymousClass1.mie);
        AppMethodBeat.i(207136);
        AppMethodBeat.o(207136);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiNFCGetHistoricalBytes$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "RESULT_HISTORICAL_BYTES", "luggage-commons-jsapi-nfc-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
