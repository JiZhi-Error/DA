package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.sdk.platformtools.Log;

public final class w extends q implements m {
    private i heq = null;
    public d hhm = null;
    String rAz;

    public w(long j2, String str, String str2, long j3, long j4, byte[] bArr, int i2) {
        AppMethodBeat.i(23416);
        Log.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", str, str2, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(bArr.length), Integer.valueOf(i2));
        this.rAz = str2;
        d.a aVar = new d.a();
        aVar.iLN = new dtp();
        aVar.iLO = new dtq();
        aVar.funcId = 538;
        aVar.uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        dtp dtp = (dtp) this.hhm.iLK.iLR;
        cat cat = new cat();
        cat.KLO = str;
        cat.oTH = str2;
        dtp.KPD = cat;
        cax cax = new cax();
        cax.Mgq = j3;
        cax.CreateTime = (int) j4;
        cax.KMS = new SKBuiltinBuffer_t().setBuffer(bArr);
        cax.oUv = i2;
        dtp.MVD = cax;
        if (j2 != 0) {
            dtp.Mgl = new SKBuiltinBuffer_t().setBuffer(u.cLx().r(j2, 2));
            AppMethodBeat.o(23416);
            return;
        }
        b anJ = ad.cKL().anJ(str2);
        if (anJ != null) {
            dtp.Mgl = new SKBuiltinBuffer_t().setBuffer(anJ.field_sessionBuf);
        }
        AppMethodBeat.o(23416);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23417);
        Log.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23417);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 538;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23418);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(23418);
        return dispatch;
    }
}
