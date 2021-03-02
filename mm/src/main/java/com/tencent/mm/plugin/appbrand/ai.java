package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.h;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/IPC_TASK_stashPersistentApp;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/IPC_PARAM_stashPersistentApp;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
public final class ai implements k<IPC_PARAM_stashPersistentApp, IPCVoid> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ IPCVoid invoke(IPC_PARAM_stashPersistentApp iPC_PARAM_stashPersistentApp) {
        AppMethodBeat.i(50157);
        IPC_PARAM_stashPersistentApp iPC_PARAM_stashPersistentApp2 = iPC_PARAM_stashPersistentApp;
        if (iPC_PARAM_stashPersistentApp2 != null) {
            h.bWb().a(iPC_PARAM_stashPersistentApp2.appId, iPC_PARAM_stashPersistentApp2.processName, iPC_PARAM_stashPersistentApp2.kES);
        }
        IPCVoid iPCVoid = IPCVoid.hnE;
        p.g(iPCVoid, "IPCVoid.VOID");
        AppMethodBeat.o(50157);
        return iPCVoid;
    }
}
