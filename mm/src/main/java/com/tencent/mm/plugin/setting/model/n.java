package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.cpp;

public final class n extends k.b {
    private cpp CXR;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(boolean z, int i2, int i3) {
        super(31);
        int i4 = 1;
        AppMethodBeat.i(73783);
        this.CXR = new cpp();
        ahm ahm = new ahm();
        ahm.Lrk = z ? 1 : 0;
        ahm.Lrm = z ? 0 : i4;
        ahn ahn = new ahn();
        ahn.Lro = i2;
        ahn.Lrp = i3;
        ahm.Lrl = ahn;
        ahn.Lro = 0;
        ahn.Lrp = 0;
        ahm.Lrn = ahn;
        this.CXR.MvH = ahm;
        this.zqv = this.CXR;
        AppMethodBeat.o(73783);
    }

    public n() {
        this(false, 22, 8);
    }
}
