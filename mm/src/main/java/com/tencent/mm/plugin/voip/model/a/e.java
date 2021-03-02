package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.protocal.protobuf.ets;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends n<ets, ett> {
    public e(int i2, long j2, String str) {
        AppMethodBeat.i(115230);
        d.a aVar = new d.a();
        aVar.iLN = new ets();
        aVar.iLO = new ett();
        aVar.uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
        aVar.funcId = 303;
        aVar.iLP = 119;
        aVar.respCmdId = 1000000119;
        this.rr = aVar.aXF();
        ets ets = (ets) this.rr.iLK.iLR;
        ets.LsZ = i2;
        ets.Lta = j2;
        ets.NqS = str;
        ets.oUv = 1;
        ets.NpN = System.currentTimeMillis();
        AppMethodBeat.o(115230);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 303;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final void jC(int i2, int i3) {
        AppMethodBeat.i(115231);
        if (i2 == 0 && i3 == 0) {
            ett ett = (ett) fIJ();
            if (ett != null) {
                Log.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.gsq), Integer.valueOf(ett.NqJ));
            }
            AppMethodBeat.o(115231);
            return;
        }
        Log.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
        AppMethodBeat.o(115231);
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115232);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.e.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115229);
                com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + qVar.getType() + " errType:" + i2 + " errCode:" + i3);
                if (i2 == 0 && i3 == 0 && qVar != null) {
                    ett ett = (ett) e.this.fIJ();
                    if (ett.BaseResponse.Ret == 0 && !c.fFg().GYS.fIq()) {
                        Log.i("MicroMsg.Voip.GetRoomInfo", "doTaskCallin in NetSceneVoipGetRoomInfo, roomid:%d, roomkey:%s, time:%d", Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.CreateTime));
                        c.fFg().c(ett);
                    }
                }
                AppMethodBeat.o(115229);
            }
        };
        AppMethodBeat.o(115232);
        return r0;
    }
}
