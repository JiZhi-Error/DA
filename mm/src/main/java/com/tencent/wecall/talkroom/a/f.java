package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.wecall.talkroom.model.c;

public final class f extends d {
    public f(String str, int i2, long j2, int i3) {
        AppMethodBeat.i(62536);
        b.d("MicroMsg.Voip", this.TAG2, "eixt", str, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3));
        a.f fVar = new a.f();
        try {
            fVar.groupId = str;
            fVar.GXO = i2;
            fVar.GXP = j2;
            fVar.bDZ = i3;
            this.mNetType = 2;
            this.RCJ = c.hqY().brj(str);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneExitVoiceRoom constructor", e2);
        }
        c(TbsListener.ErrorCode.NEEDDOWNLOAD_4, fVar);
        AppMethodBeat.o(62536);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 203;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ad adVar;
        AppMethodBeat.i(62537);
        if (bArr != null) {
            try {
                adVar = (a.ad) e.a(new a.ad(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                adVar = null;
            }
        } else {
            adVar = null;
        }
        AppMethodBeat.o(62537);
        return adVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
    }
}
