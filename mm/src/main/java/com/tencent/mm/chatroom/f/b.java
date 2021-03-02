package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class b extends k.b {
    private dir gsM = new dir();

    public b(String str, String str2) {
        super(16);
        AppMethodBeat.i(12504);
        this.gsM.Lqk = new dqi().bhy(Util.nullAsNil(str));
        this.gsM.KGR = new dqi().bhy(Util.nullAsNil(str2));
        this.zqv = this.gsM;
        AppMethodBeat.o(12504);
    }
}
