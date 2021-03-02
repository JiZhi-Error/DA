package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/QueryIsWeChatNFCEnabledTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class ae implements b<IPCVoid, IPCBoolean> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(IPCVoid iPCVoid, d<IPCBoolean> dVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(229595);
        Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "QueryIsWeChatNFCEnabledTask#invoke");
        e aAh = g.aAh();
        p.g(aAh, "MMKernel\n            .storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, (Object) 0);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(229595);
            throw tVar;
        }
        int intValue = ((Integer) obj).intValue();
        Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "QueryIsWeChatNFCEnabledTask#invoke, userSwitch: ".concat(String.valueOf(intValue)));
        if (intValue == 0) {
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel\n                .storage()");
            Object obj2 = aAh2.azQ().get(ar.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, (Object) 2);
            if (obj2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(229595);
                throw tVar2;
            }
            int intValue2 = ((Integer) obj2).intValue();
            Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "QueryIsWeChatNFCEnabledTask#invoke, defaultSwitch: ".concat(String.valueOf(intValue2)));
            if (dVar != null) {
                if (1 == intValue2) {
                    z = true;
                } else {
                    z = false;
                }
                dVar.bn(new IPCBoolean(z));
                AppMethodBeat.o(229595);
                return;
            }
            AppMethodBeat.o(229595);
        } else if (dVar != null) {
            if (1 != intValue) {
                z2 = false;
            }
            dVar.bn(new IPCBoolean(z2));
            AppMethodBeat.o(229595);
        } else {
            AppMethodBeat.o(229595);
        }
    }
}
