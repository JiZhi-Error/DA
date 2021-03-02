package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.emh;

@Deprecated
public final class n extends k.b {
    private emh jgr = new emh();

    public n(int i2) {
        super(30);
        AppMethodBeat.i(20568);
        this.jgr.OpCode = i2;
        this.zqv = this.jgr;
        AppMethodBeat.o(20568);
    }
}
