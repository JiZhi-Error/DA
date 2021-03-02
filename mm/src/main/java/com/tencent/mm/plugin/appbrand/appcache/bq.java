package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.protocal.protobuf.byz;

public final class bq implements a {
    @Override // com.tencent.mm.plugin.appbrand.widget.a.a
    public final c<byz> a(String str, int i2, String str2, int i3) {
        AppMethodBeat.i(226370);
        h hVar = new h(str, i2, str2, i3, (byte) 0);
        AppMethodBeat.o(226370);
        return hVar;
    }
}
