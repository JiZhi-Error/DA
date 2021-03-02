package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.LinkedList;

public final class ac extends q implements m {
    private i callback;
    public final d rr;

    public ac(int i2) {
        AppMethodBeat.i(131102);
        d.a aVar = new d.a();
        aVar.iLN = new cth();
        aVar.iLO = new cti();
        aVar.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
        aVar.funcId = c.CTRL_INDEX;
        aVar.iLP = 23;
        aVar.respCmdId = 1000000023;
        this.rr = aVar.aXF();
        ((cth) this.rr.iLK.iLR).Mjk = i2;
        AppMethodBeat.o(131102);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131103);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131103);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return c.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131104);
        cti cti = (cti) this.rr.iLL.iLR;
        Log.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + cti.xMV.size() + " group:" + cti.GroupList.size());
        HashSet hashSet = new HashSet();
        LinkedList<ctl> linkedList = new LinkedList<>();
        for (int i5 = 0; i5 < cti.Myh; i5++) {
            if (!hashSet.contains(cti.xMV.get(i5).UserName)) {
                linkedList.add(cti.xMV.get(i5));
                hashSet.add(cti.xMV.get(i5).UserName);
            }
        }
        cti.xMV = linkedList;
        cti.Myh = linkedList.size();
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131104);
    }
}
