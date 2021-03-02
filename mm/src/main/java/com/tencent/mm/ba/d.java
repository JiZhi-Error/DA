package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class d extends k.b {
    private afh jgh;
    public String username;

    public d(String str) {
        this(str, 0);
        this.username = str;
    }

    public d(String str, int i2) {
        super(4);
        AppMethodBeat.i(43053);
        this.jgh = new afh();
        this.jgh.Lqk = new dqi().bhy(Util.nullAsNil(str));
        this.jgh.Lql = i2;
        this.zqv = this.jgh;
        AppMethodBeat.o(43053);
    }
}
