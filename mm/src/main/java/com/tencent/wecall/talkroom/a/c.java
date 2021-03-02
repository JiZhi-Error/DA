package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class c extends d {
    public c(String str, int i2, int i3) {
        AppMethodBeat.i(62528);
        b.d("MicroMsg.Voip", this.TAG2, "NetSceneCancelCreateVoiceGroup");
        a.b bVar = new a.b();
        try {
            bVar.RDo = str;
            bVar.bDZ = i2;
            this.mNetType = 3;
            this.RCJ = i3;
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneCancelCreateVoiceGroup constructor", e2);
        }
        c(183, bVar);
        AppMethodBeat.o(62528);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 208;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.aa aaVar;
        AppMethodBeat.i(62529);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                aaVar = (a.aa) e.a(new a.aa(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                aaVar = null;
            }
        } else {
            aaVar = null;
        }
        AppMethodBeat.o(62529);
        return aaVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
    }
}
