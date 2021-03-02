package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class g extends d {
    public String xOr;

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 209;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ae aeVar;
        AppMethodBeat.i(62535);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                aeVar = (a.ae) e.a(new a.ae(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                aeVar = null;
            }
        } else {
            aeVar = null;
        }
        AppMethodBeat.o(62535);
        return aeVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
    }
}
