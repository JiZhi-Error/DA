package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;
import java.util.List;

public final class k extends d {
    public long HgX;
    public String xOr;
    public int yvK;

    public k(String str, int i2, long j2, List<a.ar> list) {
        AppMethodBeat.i(183709);
        b.d("MicroMsg.Voip", this.TAG2, "NetSceneSubscribeGeneralVideo");
        a.j jVar = new a.j();
        try {
            jVar.groupId = str;
            this.xOr = str;
            jVar.roomId = i2;
            this.yvK = i2;
            jVar.ypH = j2;
            this.HgX = j2;
            int size = list.size();
            a.ar[] arVarArr = null;
            if (size > 0) {
                a.ar[] arVarArr2 = new a.ar[size];
                for (int i3 = 0; i3 < size; i3++) {
                    arVarArr2[i3] = list.get(i3);
                }
                arVarArr = arVarArr2;
            }
            jVar.RDE = arVarArr;
            jVar.timestamp = System.currentTimeMillis();
            b.i("MicroMsg.Voip", "roomId: %d, roomKey: %d, groupId: %s, timestamp: %d, memberCnt: %d", Integer.valueOf(jVar.roomId), Long.valueOf(jVar.ypH), jVar.groupId, Long.valueOf(jVar.timestamp), Integer.valueOf(size));
            this.mNetType = 3;
            this.RCJ = c.hqY().brj(str);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneSubscribeGeneralVideo constructor", e2);
        }
        c(CdnLogic.kAppTypeFestivalImage, jVar);
        AppMethodBeat.o(183709);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 801;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ai aiVar;
        AppMethodBeat.i(183710);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                aiVar = (a.ai) e.a(new a.ai(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                aiVar = null;
            }
        } else {
            aiVar = null;
        }
        AppMethodBeat.o(183710);
        return aiVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSSubscribeGeneralVideoReq";
    }
}
