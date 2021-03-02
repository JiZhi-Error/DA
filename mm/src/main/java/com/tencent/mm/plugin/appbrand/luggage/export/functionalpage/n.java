package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/GetSycConfigTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
public final class n implements k<IPCString, AppBrandSysConfigWC> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ AppBrandSysConfigWC invoke(IPCString iPCString) {
        AppMethodBeat.i(50879);
        AppBrandSysConfigWC b2 = b(iPCString);
        AppMethodBeat.o(50879);
        return b2;
    }

    private static AppBrandSysConfigWC b(IPCString iPCString) {
        AppBrandSysConfigWC Xu;
        AppMethodBeat.i(50878);
        Log.i("MicroMsg.AppBrand.FunctionalConfigAssembler", "invoke GetSycConfigTask with ".concat(String.valueOf(iPCString)));
        if (iPCString == null) {
            try {
                p.hyc();
            } catch (Exception e2) {
                AppMethodBeat.o(50878);
                return null;
            }
        }
        if (!g.aAf().azp() || (Xu = y.Xu(iPCString.value)) == null) {
            AppMethodBeat.o(50878);
            return null;
        }
        Xu.czd = AppBrandGlobalSystemConfig.bzP();
        AppMethodBeat.o(50878);
        return Xu;
    }
}
