package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class l extends d {
    public long HgX;
    public String xOr;
    public int yvK;

    public l(String str, int i2, long j2, String str2) {
        AppMethodBeat.i(62540);
        b.d("MicroMsg.Voip", this.TAG2, "NetSceneSubscribeLargeVideo");
        a.h hVar = new a.h();
        try {
            hVar.groupId = str;
            this.xOr = str;
            hVar.roomId = i2;
            this.yvK = i2;
            hVar.ypH = j2;
            this.HgX = j2;
            hVar.gAb = str2;
            hVar.timestamp = System.currentTimeMillis();
            b.i("MicroMsg.Voip", "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(hVar.roomId), Long.valueOf(hVar.ypH), hVar.groupId, hVar.gAb, Long.valueOf(hVar.timestamp));
            this.mNetType = 3;
            this.RCJ = c.hqY().brj(str);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneSwitchVideoGroup constructor", e2);
        }
        c(245, hVar);
        AppMethodBeat.o(62540);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 800;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ag agVar;
        AppMethodBeat.i(62541);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                agVar = (a.ag) e.a(new a.ag(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                agVar = null;
            }
        } else {
            agVar = null;
        }
        AppMethodBeat.o(62541);
        return agVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
    }
}
