package com.tencent.kinda.framework;

import com.tencent.kinda.framework.api.IPluginWxKindaApi;
import com.tencent.kinda.framework.app.SubCoreKinda;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.y;
import com.tencent.mm.pluginsdk.wallet.a;

public class PluginWxKindaApi extends f implements IPluginWxKindaApi, c {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-wxkindaapi";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(18261);
        alias(PluginWxKindaApi.class);
        AppMethodBeat.o(18261);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(18262);
        if (gVar.aBb()) {
            pin(new y(SubCoreKinda.class));
            com.tencent.mm.kernel.g.b(a.class, new WxCrossServices());
        }
        AppMethodBeat.o(18262);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(18263);
        AppMethodBeat.o(18263);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(214402);
        WxCrossServices.judgeReprot();
        AppMethodBeat.o(214402);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }
}
