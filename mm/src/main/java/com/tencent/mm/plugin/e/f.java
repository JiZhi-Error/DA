package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.sdk.platformtools.Log;

public class f extends a {
    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(133571);
        int aon = m.aon();
        Log.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", Integer.valueOf(aon >> 12));
        getClass().getClassLoader();
        j.Ed("wechatsight_v7a");
        if ((aon >> 12) >= 4) {
            c.Dma = 3;
            c.Dmc = 3;
            c.Dmd = 544000;
            AppMethodBeat.o(133571);
            return;
        }
        c.Dma = 1;
        c.Dmc = 1;
        c.Dmd = 640000;
        AppMethodBeat.o(133571);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.a.c.a
    public String name() {
        return "boot-sight-init";
    }
}
