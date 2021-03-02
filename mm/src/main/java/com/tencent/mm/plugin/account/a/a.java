package com.tencent.mm.plugin.account.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class a implements n {
    public static volatile m jRt;
    public static volatile l jRu;

    @Override // com.tencent.mm.pluginsdk.n
    public final void a(m mVar) {
        jRt = mVar;
    }

    @Override // com.tencent.mm.pluginsdk.n
    public final void a(l lVar) {
        AppMethodBeat.i(155379);
        Log.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", lVar);
        jRu = lVar;
        AppMethodBeat.o(155379);
    }
}
