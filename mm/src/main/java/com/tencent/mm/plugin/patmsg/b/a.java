package com.tencent.mm.plugin.patmsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.hk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.dpl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends q implements m {
    public hk ARn;
    private i callback;
    private long dZs;
    private d iUB;
    private long msgId;

    public a(String str, long j2, long j3, long j4, String str2) {
        int i2;
        AppMethodBeat.i(206967);
        Object obj = g.aAh().azQ().get(290818, (Object) 0);
        if (obj != null) {
            i2 = Util.getInt(obj.toString(), 0);
        } else {
            i2 = 0;
        }
        d.a aVar = new d.a();
        aVar.iLN = new dpk();
        aVar.iLO = new dpl();
        aVar.uri = "/cgi-bin/micromsg-bin/revokemsg";
        aVar.funcId = 594;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.msgId = j2;
        this.dZs = j3;
        this.iUB = aVar.aXF();
        dpk dpk = (dpk) this.iUB.iLK.iLR;
        dpk.KIz = str;
        dpk.MSH = 0;
        dpk.MSI = 0;
        dpk.MSK = j3;
        dpk.CreateTime = (int) (j4 / 1000);
        dpk.xNH = z.aTY();
        dpk.xNG = str2;
        dpk.MSJ = i2;
        Log.i("MicroMsg.NetSceneRevokePatMsg", "clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", dpk.KIz, Integer.valueOf(dpk.MSH), Integer.valueOf(dpk.MSI), Integer.valueOf(dpk.CreateTime), dpk.xNH, dpk.xNG, Integer.valueOf(dpk.MSJ));
        AppMethodBeat.o(206967);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 594;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(206968);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(206968);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        AppMethodBeat.i(206969);
        Log.i("MicroMsg.NetSceneRevokePatMsg", "onGYNetEnd errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            ((b) g.af(b.class)).ae(this.msgId, this.dZs);
            Object obj = g.aAh().azQ().get(290818, (Object) 0);
            if (obj != null) {
                i5 = Util.getInt(obj.toString(), 0);
            } else {
                i5 = 0;
            }
            g.aAh().azQ().set(290818, Integer.valueOf(i5 + 1));
            if (this.ARn != null) {
                this.ARn.eLW = 2;
                this.ARn.bfK();
                com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
                com.tencent.mm.util.b.a(this.ARn);
            }
        } else if (this.ARn != null) {
            this.ARn.eLW = 1;
            this.ARn.bfK();
            com.tencent.mm.util.b bVar2 = com.tencent.mm.util.b.QYu;
            com.tencent.mm.util.b.a(this.ARn);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(206969);
    }
}
