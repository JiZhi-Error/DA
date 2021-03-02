package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class j extends d {
    public String xOr;

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 213;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.am amVar;
        AppMethodBeat.i(62530);
        if (bArr != null) {
            try {
                amVar = (a.am) e.a(new a.am(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2);
                amVar = null;
            }
        } else {
            amVar = null;
        }
        AppMethodBeat.o(62530);
        return amVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
    }
}
