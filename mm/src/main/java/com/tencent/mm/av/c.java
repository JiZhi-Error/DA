package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.i.d;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.protocal.protobuf.enu;

public final class c extends o.e {
    public String aesKey;
    public d hmq;
    public enu iWW;
    public g iWX;
    public o.a iWY;

    private c() {
    }

    public static c bcn() {
        AppMethodBeat.i(223571);
        c cVar = new c();
        cVar.jec = o.d.CDN_IMAGE;
        AppMethodBeat.o(223571);
        return cVar;
    }

    @Override // com.tencent.mm.modelmulti.o.e
    public final /* bridge */ /* synthetic */ o.e tc(int i2) {
        this.hmk = i2;
        return this;
    }
}
