package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dwm;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;

public final class aa extends q implements m {
    private i callback;
    public final d rr;

    public aa(String str, String str2, int i2, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(134202);
        d.a aVar = new d.a();
        aVar.iLN = new dwm();
        aVar.iLO = new dwn();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetpasswd";
        aVar.funcId = 383;
        aVar.iLP = TXLiveConstants.RENDER_ROTATION_180;
        aVar.respCmdId = 1000000180;
        this.rr = aVar.aXF();
        dwm dwm = (dwm) this.rr.iLK.iLR;
        dwm.rBz = Util.getCutPasswordMD5(str);
        dwm.Bri = str2;
        dwm.MWL = i2;
        dwm.KKZ = sKBuiltinBuffer_t;
        Log.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", str, str2, Integer.valueOf(i2), Util.dumpHex(z.a(sKBuiltinBuffer_t)));
        AppMethodBeat.o(134202);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(134203);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(134203);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 383;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(134204);
        Log.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(134204);
    }
}
