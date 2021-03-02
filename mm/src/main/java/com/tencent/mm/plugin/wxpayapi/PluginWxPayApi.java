package com.tencent.mm.plugin.wxpayapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.wxpayapi.a.a;
import com.tencent.mm.pluginsdk.wallet.b;

public class PluginWxPayApi extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-wxpayapi";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(106596);
        alias(PluginWxPayApi.class);
        AppMethodBeat.o(106596);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(106597);
        gVar.aBb();
        AppMethodBeat.o(106597);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(106598);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(b.class, new com.tencent.mm.plugin.o.a());
        }
        AppMethodBeat.o(106598);
    }
}
