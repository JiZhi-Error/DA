package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.ae.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/AppBrandPluginHandlerFactoryWC;", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandPluginHandlerFactory;", "()V", "createHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/IExtendPluginHandler;", "type", "", "plugin-appbrand-integration_release"})
public final class a extends d {
    @Override // com.tencent.mm.plugin.appbrand.h.d, com.tencent.luggage.xweb_ext.extendplugin.a.c
    public final b dW(String str) {
        AppMethodBeat.i(229694);
        p.h(str, "type");
        switch (str.hashCode()) {
            case -1960115589:
                if (str.equals("voiproom")) {
                    e eVar = new e();
                    AppMethodBeat.o(229694);
                    return eVar;
                }
                break;
            case 113005369:
                if (str.equals("webgl")) {
                    com.tencent.mm.plugin.appbrand.jsapi.b.a.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.b.a.a();
                    AppMethodBeat.o(229694);
                    return aVar;
                }
                break;
        }
        b dW = super.dW(str);
        AppMethodBeat.o(229694);
        return dW;
    }
}
