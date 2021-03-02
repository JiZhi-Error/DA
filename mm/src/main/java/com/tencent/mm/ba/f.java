package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class f extends k.b {
    private afr jgj = new afr();

    public f(String str, long j2) {
        super(9);
        AppMethodBeat.i(20565);
        this.jgj.Lqk = new dqi().bhy(Util.nullAsNil(str));
        this.jgj.Lqq.add(Integer.valueOf((int) j2));
        this.jgj.oTz = 1;
        this.zqv = this.jgj;
        AppMethodBeat.o(20565);
    }
}
