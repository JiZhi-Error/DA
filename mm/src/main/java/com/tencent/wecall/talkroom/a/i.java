package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class i extends d {
    public i(String str, int i2, long j2, int i3) {
        AppMethodBeat.i(62526);
        b.d("MicroMsg.Voip", this.TAG2, "NetSceneRejectVoiceGroup");
        a.g gVar = new a.g();
        try {
            gVar.groupId = str;
            gVar.GXO = i2;
            gVar.GXP = j2;
            gVar.bDZ = i3;
            this.mNetType = 3;
            this.RCJ = c.hqY().brj(str);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneRejectVoiceGroup constructor", e2);
        }
        c(181, gVar);
        AppMethodBeat.o(62526);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 207;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.af afVar;
        AppMethodBeat.i(62527);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                afVar = (a.af) e.a(new a.af(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                afVar = null;
            }
        } else {
            afVar = null;
        }
        AppMethodBeat.o(62527);
        return afVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
    }
}
