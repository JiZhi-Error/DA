package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.b;
import com.tencent.mm.plugin.aa.model.c;
import com.tencent.mm.plugin.aa.model.h;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.app.a;

public class f extends a {
    c jUf = new c();
    h jUg = new h();
    k jUh = new k();

    public f() {
        AppMethodBeat.i(63455);
        AppMethodBeat.o(63455);
    }

    @Override // com.tencent.mm.vending.app.a
    public final void onCreate() {
        AppMethodBeat.i(63456);
        super.onCreate();
        b bmb = this.jUf.bmb();
        Log.i("MicroMsg.AAGetPaylistDetailLogic", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        g.aAi();
        g.aAg().hqi.a(1695, bmb);
        com.tencent.mm.plugin.aa.model.g bmk = this.jUg.bmk();
        g.aAi();
        g.aAg().hqi.a(1629, bmk);
        this.jUh.bmm().init();
        AppMethodBeat.o(63456);
    }

    @Override // com.tencent.mm.vending.app.a
    public final void onDestroy() {
        AppMethodBeat.i(63457);
        super.onDestroy();
        b bmb = this.jUf.bmb();
        Log.i("MicroMsg.AAGetPaylistDetailLogic", "unInit");
        g.aAi();
        g.aAg().hqi.b(1695, bmb);
        com.tencent.mm.plugin.aa.model.g bmk = this.jUg.bmk();
        g.aAi();
        g.aAg().hqi.b(1629, bmk);
        this.jUh.bmm().unInit();
        AppMethodBeat.o(63457);
    }
}
