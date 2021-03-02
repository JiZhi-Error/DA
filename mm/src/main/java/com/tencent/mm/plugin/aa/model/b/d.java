package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.e;
import com.tencent.mm.plugin.aa.model.f;
import com.tencent.mm.plugin.aa.model.l;
import com.tencent.mm.plugin.aa.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.app.a;

public final class d extends a {
    m jTX = new m();
    f jTY = new f();

    public d() {
        AppMethodBeat.i(63443);
        AppMethodBeat.o(63443);
    }

    @Override // com.tencent.mm.vending.app.a
    public final void onCreate() {
        AppMethodBeat.i(63444);
        super.onCreate();
        Log.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
        l bmn = this.jTX.bmn();
        g.aAi();
        g.aAg().hqi.a(1624, bmn);
        g.aAi();
        g.aAg().hqi.a(1655, bmn);
        g.aAi();
        g.aAg().hqi.a(2831, bmn);
        e bmj = this.jTY.bmj();
        Log.i("MicroMsg.AAOperationData", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        g.aAi();
        g.aAg().hqi.a(1698, bmj);
        AppMethodBeat.o(63444);
    }

    @Override // com.tencent.mm.vending.app.a
    public final void onDestroy() {
        AppMethodBeat.i(63445);
        super.onDestroy();
        Log.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
        l bmn = this.jTX.bmn();
        g.aAi();
        g.aAg().hqi.b(1624, bmn);
        g.aAi();
        g.aAg().hqi.b(1655, bmn);
        g.aAi();
        g.aAg().hqi.b(2831, bmn);
        e bmj = this.jTY.bmj();
        Log.i("MicroMsg.AAOperationData", "uninit");
        g.aAi();
        g.aAg().hqi.b(1698, bmj);
        AppMethodBeat.o(63445);
    }
}
