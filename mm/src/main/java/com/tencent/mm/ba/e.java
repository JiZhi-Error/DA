package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class e extends k.b {
    private afk jgi = new afk();

    public e(String str, long j2) {
        super(8);
        AppMethodBeat.i(20564);
        this.jgi.Lqk = new dqi().bhy(Util.nullAsNil(str));
        this.jgi.Brn = j2;
        this.zqv = this.jgi;
        AppMethodBeat.o(20564);
    }
}
