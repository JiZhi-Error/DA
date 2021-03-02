package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.wecall.talkroom.model.c;

public final class o extends d {
    public long HgX;
    public String xOr;
    public int yvK;

    public o(String str, int i2, long j2, int i3, int i4) {
        AppMethodBeat.i(62547);
        b.d("MicroMsg.Voip", this.TAG2, "hello", str, Integer.valueOf(i2), Long.valueOf(j2));
        a.n nVar = new a.n();
        nVar.RDH = i4;
        nVar.GXO = i2;
        this.yvK = i2;
        nVar.GXP = j2;
        this.HgX = j2;
        nVar.groupId = str;
        this.xOr = str;
        nVar.qrD = i3;
        this.mNetType = 3;
        try {
            this.RCJ = c.hqY().brj(str);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneVoiceRoomHello constructor", e2);
        }
        c(TbsListener.ErrorCode.NEEDDOWNLOAD_8, nVar);
        AppMethodBeat.o(62547);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 205;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ao aoVar;
        AppMethodBeat.i(62548);
        if (bArr != null) {
            try {
                aoVar = (a.ao) e.a(new a.ao(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                aoVar = null;
            }
        } else {
            aoVar = null;
        }
        AppMethodBeat.o(62548);
        return aoVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
    }
}
