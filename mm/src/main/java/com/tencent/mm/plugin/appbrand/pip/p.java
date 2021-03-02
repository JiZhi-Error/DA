package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/pip/SetStablePosTask;", "Lcom/tencent/mm/plugin/appbrand/pip/StablePosTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/pip/PipStablePos;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class p extends q implements b<PipStablePos, IPCVoid> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(PipStablePos pipStablePos, d<IPCVoid> dVar) {
        AppMethodBeat.i(229278);
        PipStablePos pipStablePos2 = pipStablePos;
        if (pipStablePos2 == null) {
            Log.w("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "SetStablePosTask#invoke, data is null");
            AppMethodBeat.o(229278);
            return;
        }
        Log.d("MicroMsg.AppBrand.AppBrandPipStablePosLogicWC", "SetStablePosTask#invoke, data: ".concat(String.valueOf(pipStablePos2)));
        bTJ().a(pipStablePos2.appId, pipStablePos2.nDV);
        if (dVar != null) {
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(229278);
            return;
        }
        AppMethodBeat.o(229278);
    }
}
