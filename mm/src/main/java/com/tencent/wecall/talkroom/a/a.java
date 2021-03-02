package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;

public final class a extends d {
    public long HgX = 0;
    public int RCJ;
    public int SwS;
    public String xOr = null;
    public int yvK = 0;

    public a(String str, int i2, long j2, int i3, int i4) {
        AppMethodBeat.i(62531);
        b.d("MicroMsg.Voip", this.TAG2, "NetSceneAckVoiceGroup");
        a.l lVar = new a.l();
        try {
            lVar.groupId = str;
            this.xOr = str;
            lVar.GXO = i2;
            this.yvK = i2;
            lVar.GXP = j2;
            this.HgX = j2;
            this.SwS = i4;
            this.RCJ = i3;
            a.ap apVar = new a.ap();
            apVar.iLen = 0;
            a.bg bgVar = new a.bg();
            bgVar.type = 3;
            bgVar.RGJ = apVar;
            lVar.RDs = bgVar;
            this.mNetType = 3;
            super.RCJ = i3;
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneAckVoiceGroup constructor", e2);
        }
        c(189, lVar);
        AppMethodBeat.o(62531);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 206;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ak akVar;
        AppMethodBeat.i(62532);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                akVar = (a.ak) e.a(new a.ak(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                akVar = null;
            }
        } else {
            akVar = null;
        }
        AppMethodBeat.o(62532);
        return akVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSVoiceAckReq";
    }
}
