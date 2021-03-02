package com.tencent.mm.plugin.appbrand.task.preload;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.AppBrandTaskPreloadReceiver;

public class d implements b<Intent, IPCVoid> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Intent intent, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
        AppMethodBeat.i(48510);
        a(intent, dVar);
        AppMethodBeat.o(48510);
    }

    public static void a(Intent intent, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
        AppMethodBeat.i(227541);
        AppBrandTaskPreloadReceiver.c("PreloadIPCTaskImpl", intent);
        dVar.bn(IPCVoid.hnE);
        AppMethodBeat.o(227541);
    }
}
