package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.sdk.platformtools.MD5Util;

public final class d implements g {
    private String kIg;
    private g.a kIh;

    @Override // com.tencent.mm.plugin.appbrand.service.g
    public final String cp(String str, String str2) {
        AppMethodBeat.i(226292);
        String str3 = n.NL().get(str, str2);
        AppMethodBeat.o(226292);
        return str3;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.g
    public final void UF(String str) {
        AppMethodBeat.i(226293);
        this.kIg = MD5Util.getMD5String(str + String.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(226293);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.g
    public final String bul() {
        return this.kIg;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.g
    public final void a(g.a aVar) {
        this.kIh = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.g
    public final g.a bum() {
        return this.kIh;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.g
    public final void clear() {
        this.kIg = null;
        this.kIh = null;
    }
}
