package com.tencent.mm.plugin.wxpaysdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.wxpaysdk.api.a;

public class PluginWxPaySdk extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-wxpaysdk";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(91306);
        alias(PluginWxPaySdk.class);
        AppMethodBeat.o(91306);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(91307);
        gVar.aBb();
        AppMethodBeat.o(91307);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(91308);
        gVar.aBb();
        AppMethodBeat.o(91308);
    }
}
