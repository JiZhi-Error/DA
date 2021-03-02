package com.tencent.mm.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
public final class a extends k.b {
    private cpj gsL = new cpj();

    public a(String str, int i2) {
        super(20);
        AppMethodBeat.i(12503);
        this.gsL.KGR = new dqi().bhy(Util.nullAsNil(str));
        this.gsL.oTW = i2;
        this.zqv = this.gsL;
        AppMethodBeat.o(12503);
    }
}
