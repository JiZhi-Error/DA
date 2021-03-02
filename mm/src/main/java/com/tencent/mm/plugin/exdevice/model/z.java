package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class z extends q implements m {
    private i heq = null;
    d hhm = null;
    private String rAC = "";

    public z(LinkedList<boc> linkedList, String str, String str2) {
        AppMethodBeat.i(23424);
        this.rAC = str2;
        d.a aVar = new d.a();
        aVar.iLN = new bod();
        aVar.iLO = new boe();
        aVar.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
        aVar.funcId = 543;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bod bod = (bod) this.hhm.iLK.iLR;
        if (!Util.isNullOrNil(str)) {
            bob bob = new bob();
            bob.KOR = str;
            bod.LWu = bob;
        }
        bod.LWt = linkedList;
        AppMethodBeat.o(23424);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 543;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23425);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(23425);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23426);
        Log.i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(23426);
    }
}
