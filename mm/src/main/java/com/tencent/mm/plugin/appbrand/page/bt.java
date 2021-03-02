package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/MonkeyTestAppPageViewRenderer;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRendererWC;", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onCreateCustomScriptProvider", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "plugin-appbrand-integration_release"})
public final class bt extends af {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bt(ag agVar) {
        super(agVar);
        p.h(agVar, "pv");
        AppMethodBeat.i(229246);
        AppMethodBeat.o(229246);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/appbrand/page/MonkeyTestAppPageViewRenderer$onCreateCustomScriptProvider$1", "Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "provideScript", "", "resourceName", "plugin-appbrand-integration_release"})
    public static final class a extends bi {
        final /* synthetic */ bt nuC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(bt btVar, a aVar) {
            super(aVar);
            this.nuC = btVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.page.bi, com.tencent.mm.plugin.appbrand.page.be
        public final String adT(String str) {
            AppMethodBeat.i(229244);
            if (str != null) {
                switch (str.hashCode()) {
                    case -827637304:
                        if (str.equals("WAWebview.js")) {
                            Object S = this.nuC.S(ICommLibReader.class);
                            if (S == null) {
                                p.hyc();
                            }
                            String UM = ((ICommLibReader) S).UM("WAWebview.js");
                            if (UM == null) {
                                p.hyc();
                            }
                            StringBuilder sb = new StringBuilder();
                            ag agVar = (ag) this.nuC.NN();
                            if (agVar == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.page.MonkeyTestAppPageView");
                                AppMethodBeat.o(229244);
                                throw tVar;
                            }
                            String sb2 = sb.append(((bs) agVar).nuB).append("\n\n").append(UM).toString();
                            AppMethodBeat.o(229244);
                            return sb2;
                        }
                        break;
                }
            }
            String adT = super.adT(str);
            AppMethodBeat.o(229244);
            return adT;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.bn, com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.af
    public final be bQu() {
        AppMethodBeat.i(229245);
        a aVar = new a(this, this);
        AppMethodBeat.o(229245);
        return aVar;
    }
}
