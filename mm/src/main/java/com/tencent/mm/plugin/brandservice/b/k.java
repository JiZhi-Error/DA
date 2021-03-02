package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dmy;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;

public final class k extends q implements m {
    private i callback;
    private d rr;

    public k(LinkedList<ot> linkedList, int i2, int i3, int i4, long j2, int i5, int i6) {
        AppMethodBeat.i(194855);
        d.a aVar = new d.a();
        aVar.iLN = new dmy();
        aVar.iLO = new dmz();
        aVar.uri = "/cgi-bin/micromsg-bin/reportshow";
        aVar.funcId = 2645;
        aVar.iLP = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
        aVar.respCmdId = 1000000176;
        this.rr = aVar.aXF();
        dmy dmy = (dmy) this.rr.iLK.iLR;
        dmy.MQm = linkedList;
        dmy.MQn = i2;
        dmy.MQo = i3;
        dmy.KRg = i4;
        dmy.MQp = j2;
        dmy.scene = i5;
        dmy.MQq = i6;
        Log.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d, scene=%d, actType=%d", Integer.valueOf(dmy.MQm.size()), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i6));
        AppMethodBeat.o(194855);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(5585);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(5585);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2645;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(5586);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(5586);
        return dispatch;
    }
}
