package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.Log;

public class c implements b<Bundle, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(121435);
        String axZ = g.axZ();
        BaseIPCService Fs = j.aya().Fs(axZ);
        if (Fs != null) {
            Log.i("MicroMsg.IPCInvokeTask_KillAllProcess", "killSelf process(%s)", axZ);
            Fs.eo(true);
        }
        AppMethodBeat.o(121435);
    }
}
