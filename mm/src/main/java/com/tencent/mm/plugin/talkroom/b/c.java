package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends f {
    public LinkedList<egs> FQR;
    public int FQw;
    private i callback;
    private final d rr;
    private int sceneType = 0;
    private final String yJB;

    public c(int i2, long j2, String str, int i3) {
        AppMethodBeat.i(29557);
        this.sceneType = i3;
        d.a aVar = new d.a();
        aVar.iLN = new bvz();
        aVar.iLO = new bwa();
        aVar.uri = "/cgi-bin/micromsg-bin/gettalkroommember";
        aVar.funcId = 336;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bvz bvz = (bvz) this.rr.iLK.iLR;
        bvz.LsZ = i2;
        bvz.Lta = j2;
        this.yJB = str;
        bvz.Scene = i3;
        AppMethodBeat.o(29557);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29558);
        Log.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29558);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 336;
    }

    @Override // com.tencent.mm.plugin.talkroom.b.f
    public final String fui() {
        return this.yJB;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29559);
        Log.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            bwa bwa = (bwa) this.rr.iLL.iLR;
            Log.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", bwa.toString());
            this.FQw = bwa.Ltb;
            this.FQR = bs(bwa.KGQ);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29559);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29559);
    }

    private static LinkedList<egs> bs(LinkedList<egs> linkedList) {
        AppMethodBeat.i(29560);
        LinkedList<egs> linkedList2 = new LinkedList<>();
        Iterator<egs> it = linkedList.iterator();
        while (it.hasNext()) {
            egs next = it.next();
            if (!Util.isNullOrNil(next.UserName)) {
                linkedList2.add(next);
            }
        }
        AppMethodBeat.o(29560);
        return linkedList2;
    }

    @Override // com.tencent.mm.plugin.talkroom.b.f
    public final int fuj() {
        return this.sceneType;
    }
}
