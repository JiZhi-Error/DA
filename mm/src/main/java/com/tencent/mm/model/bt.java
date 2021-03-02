package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.e;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.Log;

public final class bt extends q implements m {
    private i callback;
    private final d iFd;
    public int iFe = 0;
    public int iFf = 0;
    public int iFg = 0;
    public int type = 0;

    public bt(int i2, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(177084);
        yz yzVar = new yz();
        yzVar.Scene = i2;
        yzVar.LjZ = str;
        yzVar.yiZ = str2;
        yzVar.Lka = str3;
        yzVar.Lke = str4;
        yzVar.Lkd = str5;
        d.a aVar = new d.a();
        aVar.iLN = yzVar;
        aVar.iLO = new za();
        aVar.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
        aVar.funcId = e.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iFd = aVar.aXF();
        this.iFd.option = 1;
        Log.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s] uuid[%s] adid[%s]", Integer.valueOf(i2), yzVar.LjZ, yzVar.yiZ, yzVar.Lka, yzVar.Lke, yzVar.Lkd);
        AppMethodBeat.o(177084);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return e.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(127600);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iFd, this);
        AppMethodBeat.o(127600);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(127601);
        Log.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            za zaVar = (za) this.iFd.iLL.iLR;
            this.iFe = zaVar.Lkh;
            this.iFf = zaVar.Lkg;
            this.type = zaVar.oUv;
            this.iFg = zaVar.Lkf;
            Log.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", Integer.valueOf(zaVar.Lkg), Integer.valueOf(zaVar.Lkf), Integer.valueOf(zaVar.Lkh));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(127601);
    }
}
