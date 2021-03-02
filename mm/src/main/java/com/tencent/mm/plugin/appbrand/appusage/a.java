package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/AddCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class a implements k<AppIdentity, IPCInteger> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ IPCInteger invoke(AppIdentity appIdentity) {
        int i2;
        AppMethodBeat.i(50220);
        AppIdentity appIdentity2 = appIdentity;
        if (!g.aAc() || appIdentity2 == null) {
            i2 = -1;
        } else {
            i2 = ((ag) g.af(ag.class)).bg(h.a(appIdentity2), h.b(appIdentity2));
        }
        IPCInteger iPCInteger = new IPCInteger(i2);
        AppMethodBeat.o(50220);
        return iPCInteger;
    }
}
