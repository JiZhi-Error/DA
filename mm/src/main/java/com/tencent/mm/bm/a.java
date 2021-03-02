package com.tencent.mm.bm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bnq;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends q implements m {
    private i callback = null;
    private bnq jDk;
    public bnr jDl;
    public com.tencent.mm.api.i jDm;
    private String jDn = null;
    private d rr;

    public a(com.tencent.mm.api.i iVar) {
        AppMethodBeat.i(114107);
        if (iVar == null) {
            AppMethodBeat.o(114107);
            return;
        }
        this.jDm = iVar;
        Log.i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", iVar.field_cgi, Integer.valueOf(iVar.field_cmdid), iVar.field_functionmsgid);
        d.a aVar = new d.a();
        aVar.iLN = new bnq();
        aVar.iLO = new bnr();
        aVar.funcId = 825;
        aVar.uri = iVar.field_cgi;
        aVar.iLP = iVar.field_cmdid;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.jDk = (bnq) this.rr.iLK.iLR;
        this.jDk.LWd = iVar.field_functionmsgid;
        if (iVar.field_custombuff != null) {
            this.jDk.LWe = iVar.field_custombuff;
        }
        this.jDk.LWf = iVar.field_businessInfo;
        AppMethodBeat.o(114107);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 825;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(114108);
        if (this.jDm != null) {
            Log.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", this.jDm.field_functionmsgid);
            this.jDm.field_status = 1;
        }
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(114108);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(114109);
        this.jDl = (bnr) ((d) sVar).iLL.iLR;
        this.jDn = this.jDl.LWe;
        Log.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(this.jDl.OpCode), Boolean.valueOf(Util.isNullOrNil(this.jDn)), Long.valueOf(this.jDl.LRV));
        if (!Util.isNullOrNil(this.jDn)) {
            this.jDk = (bnq) this.rr.iLK.iLR;
            this.jDk.LWe = this.jDn;
        }
        if (i3 == 0 || i4 == 0) {
            h.INSTANCE.idkeyStat((long) this.jDm.field_reportid, (long) this.jDm.field_successkey, 1, false);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(114109);
        } else if (i3 == 4) {
            Log.i("MicroMsg.NetSceneGetFuncMsg", "server error");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(114109);
        } else {
            Log.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(114109);
        }
    }
}
