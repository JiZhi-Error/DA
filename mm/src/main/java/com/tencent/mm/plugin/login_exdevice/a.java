package com.tencent.mm.plugin.login_exdevice;

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
        AppMethodBeat.i(231725);
        Log.i("MicroMsg.LoginAsExDeviceApplication", "regitMMModelCallback %s", lVar);
        jRu = lVar;
        AppMethodBeat.o(231725);
    }
}
