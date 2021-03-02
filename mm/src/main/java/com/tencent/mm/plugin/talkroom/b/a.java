package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends f {
    public LinkedList<egs> FQR;
    public int FQw;
    public int FQx;
    public LinkedList<egr> FQz;
    private i callback;
    public int roomId;
    private final d rr;
    private int sceneType = 0;
    private final String yJB;
    public long ypH;

    public a(String str, int i2) {
        AppMethodBeat.i(29549);
        d.a aVar = new d.a();
        this.sceneType = i2;
        aVar.iLN = new ajn();
        aVar.iLO = new ajo();
        aVar.uri = "/cgi-bin/micromsg-bin/entertalkroom";
        aVar.funcId = TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE;
        aVar.iLP = TbsListener.ErrorCode.NEEDDOWNLOAD_8;
        aVar.respCmdId = 1000000147;
        this.rr = aVar.aXF();
        ((ajn) this.rr.iLK.iLR).LsY = str;
        ((ajn) this.rr.iLK.iLR).Scene = i2;
        this.yJB = str;
        AppMethodBeat.o(29549);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29550);
        Log.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", Integer.valueOf(this.sceneType));
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29550);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE;
    }

    @Override // com.tencent.mm.plugin.talkroom.b.f
    public final String fui() {
        return this.yJB;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29551);
        Log.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            ajo ajo = (ajo) this.rr.iLL.iLR;
            Log.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", ajo.toString());
            this.roomId = ajo.LsZ;
            this.ypH = ajo.Lta;
            this.FQw = ajo.Ltb;
            this.FQx = ajo.Ltd;
            this.FQR = bs(ajo.KGQ);
            this.FQz = bt(ajo.KMD);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29551);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29551);
    }

    private static LinkedList<egs> bs(LinkedList<egs> linkedList) {
        AppMethodBeat.i(29552);
        LinkedList<egs> linkedList2 = new LinkedList<>();
        Iterator<egs> it = linkedList.iterator();
        while (it.hasNext()) {
            egs next = it.next();
            if (!Util.isNullOrNil(next.UserName)) {
                linkedList2.add(next);
            }
        }
        AppMethodBeat.o(29552);
        return linkedList2;
    }

    private static LinkedList<egr> bt(LinkedList<egr> linkedList) {
        AppMethodBeat.i(29553);
        LinkedList<egr> linkedList2 = new LinkedList<>();
        Iterator<egr> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add(it.next());
        }
        AppMethodBeat.o(29553);
        return linkedList2;
    }

    @Override // com.tencent.mm.plugin.talkroom.b.f
    public final int fuj() {
        return this.sceneType;
    }
}
