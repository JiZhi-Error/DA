package com.tencent.mm.plugin.lite.debug;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class b implements com.tencent.mm.ipcinvoker.b<Bundle, LiteAppDebugIPCCallbackData> {
    b() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<LiteAppDebugIPCCallbackData> dVar) {
        AppMethodBeat.i(198816);
        Bundle bundle2 = bundle;
        Log.i("MicroMsg.LiteAppDebugInvokeTask", "invoke data = " + bundle2.toString());
        ((a) g.af(a.class)).a(MMApplicationContext.getContext(), bundle2, false, null);
        Log.i("MicroMsg.LiteAppDebugInvokeTask", "after start activity");
        LiteAppDebugIPCCallbackData liteAppDebugIPCCallbackData = new LiteAppDebugIPCCallbackData();
        liteAppDebugIPCCallbackData.cqU = "ok";
        dVar.bn(liteAppDebugIPCCallbackData);
        Log.i("MicroMsg.LiteAppDebugInvokeTask", "after callback");
        AppMethodBeat.o(198816);
    }
}
