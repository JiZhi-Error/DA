package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;
import java.util.List;

public final class m extends d {
    public long HgX;
    public String xOr;
    public int yvK;

    public m(String str, int i2, long j2, List<a.aq> list) {
        AppMethodBeat.i(199661);
        b.d("MicroMsg.Voip", this.TAG2, "NetSceneSubscribeScreenSharingVideo");
        a.i iVar = new a.i();
        try {
            iVar.groupId = str;
            this.xOr = str;
            iVar.roomId = i2;
            this.yvK = i2;
            iVar.ypH = j2;
            this.HgX = j2;
            int size = list.size();
            a.aq[] aqVarArr = null;
            if (size > 0) {
                a.aq[] aqVarArr2 = new a.aq[size];
                for (int i3 = 0; i3 < size; i3++) {
                    aqVarArr2[i3] = list.get(i3);
                }
                aqVarArr = aqVarArr2;
            }
            iVar.RDD = aqVarArr;
            iVar.timestamp = System.currentTimeMillis();
            b.i("MicroMsg.Voip", "roomId: %d, roomKey: %d, groupId: %s, timestamp: %d, memberCnt: %d", Integer.valueOf(iVar.roomId), Long.valueOf(iVar.ypH), iVar.groupId, Long.valueOf(iVar.timestamp), Integer.valueOf(size));
            this.mNetType = 3;
            this.RCJ = c.hqY().brj(str);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneSubscribeScreenSharingVideo constructor", e2);
        }
        c(259, iVar);
        AppMethodBeat.o(199661);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 802;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ah ahVar;
        AppMethodBeat.i(199662);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                ahVar = (a.ah) e.a(new a.ah(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                ahVar = null;
            }
        } else {
            ahVar = null;
        }
        AppMethodBeat.o(199662);
        return ahVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSSubscribeScreenSharingVideoReq";
    }
}
