package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.protocal.protobuf.dvu;
import com.tencent.mm.protocal.protobuf.dvv;
import com.tencent.mm.sdk.platformtools.Log;

public final class ai extends aa {
    private String JWL;
    private int cmdId = 0;

    public ai(String str, String str2) {
        AppMethodBeat.i(31060);
        d.a aVar = new d.a();
        aVar.iLN = new dvu();
        aVar.iLO = new dvv();
        aVar.uri = "/cgi-bin/micromsg-bin/setappsetting";
        aVar.funcId = 396;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        dvu dvu = (dvu) this.hhm.iLK.iLR;
        dvu.hik = str;
        dvu.MWF = 0;
        dvu.MWG = str2;
        this.JWL = str2;
        AppMethodBeat.o(31060);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        dvv dvv;
        AppMethodBeat.i(31061);
        Log.i("MicroMsg.NetSceneSetAppSetting", "errType = " + i3 + ", errCode = " + i4);
        if (i3 == 0 && i3 == 0 && (dvv = (dvv) this.hhm.iLL.iLR) != null) {
            j eAX = a.C1616a.eAZ().eAX();
            g o = h.o(dvv.hik, false, false);
            if (o != null) {
                o.field_authFlag = dvv.KKl;
                Log.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + eAX.a(o, new String[0]) + ", appId = " + dvv.hik);
            }
        }
        AppMethodBeat.o(31061);
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final byte[] gmB() {
        AppMethodBeat.i(31062);
        try {
            byte[] protoBuf = ((d.b) this.hhm.getReqObj()).toProtoBuf();
            AppMethodBeat.o(31062);
            return protoBuf;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + e2.getMessage());
            AppMethodBeat.o(31062);
            return null;
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final void cB(byte[] bArr) {
        AppMethodBeat.i(31063);
        if (bArr == null) {
            Log.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
            AppMethodBeat.o(31063);
            return;
        }
        try {
            this.hhm.iLL.fromProtoBuf(bArr);
            AppMethodBeat.o(31063);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", e2, "", new Object[0]);
            AppMethodBeat.o(31063);
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final int getType() {
        return 2;
    }
}
