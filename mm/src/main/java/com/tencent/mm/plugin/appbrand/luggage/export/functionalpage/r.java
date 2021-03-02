package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH\u0002J \u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess;", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalAPIInvokeProcess;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "(Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;)V", "CALLBACK_ID", "", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "transitiveData", "", i.NAME, "", "invokeResult", "onCallback", "component", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/IFunctionalComponent;", "callbackId", "data", "onPayAheadCallback", "callbackStr", "performInvoke", "invokeData", "Companion", "plugin-appbrand-integration_release"})
final class r implements o {
    @Deprecated
    public static final a nba = new a((byte) 0);
    private String les;
    private final int naM = (hashCode() & 65535);
    private final l nas;

    static {
        AppMethodBeat.i(228882);
        AppMethodBeat.o(228882);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WebInvokeProcess$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public r(l lVar) {
        p.h(lVar, "runtime");
        AppMethodBeat.i(228881);
        this.nas = lVar;
        AppMethodBeat.o(228881);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013b  */
    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void acv(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 338
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.r.acv(java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    public final void a(p pVar, int i2, String str) {
        AppMethodBeat.i(228878);
        p.h(pVar, "component");
        p.h(str, "data");
        if (this.naM == i2) {
            ep(this.les, str);
        }
        AppMethodBeat.o(228878);
    }

    @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.o
    public final void b(p pVar, int i2, String str) {
        AppMethodBeat.i(228879);
        p.h(pVar, "component");
        p.h(str, "callbackStr");
        Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "onPayAheadCallback, instance(" + hashCode() + ", callbackId(" + i2 + "), callbackStr(" + str + ')');
        ep(this.les, str);
        AppMethodBeat.o(228879);
    }

    private final void ep(String str, String str2) {
        AppMethodBeat.i(228880);
        Log.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager.WebInvokeProcess", "navigateBack, instance(" + hashCode() + "), invokeResult(" + str2 + ')');
        com.tencent.luggage.sdk.launching.a aVar = this.nas.bsC().cyx;
        if (aVar == null) {
            AppMethodBeat.o(228880);
        } else if (aVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.luggage.sdk.launching.OnWXAppResultListener<com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult>");
            AppMethodBeat.o(228880);
            throw tVar;
        } else {
            aVar.b(new ByRuntimeQrcodeResult(str2, str));
            this.nas.bOG();
            AppMethodBeat.o(228880);
        }
    }
}
