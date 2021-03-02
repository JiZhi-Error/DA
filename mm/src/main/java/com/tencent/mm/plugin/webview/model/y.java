package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.Log;

public final class y extends q implements m {
    public String IXX;
    public int IXY;
    private i heq;
    public String qFU;
    public String qFV;
    private final d rr;
    public String sign;

    public y(String str, String str2, String str3) {
        AppMethodBeat.i(78912);
        d.a aVar = new d.a();
        aVar.iLN = new ckw();
        aVar.iLO = new ckx();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
        aVar.funcId = 1177;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ckw ckw = (ckw) this.rr.iLK.iLR;
        ckw.app_id = str;
        ckw.GaP = str2;
        ckw.pWm = str3;
        AppMethodBeat.o(78912);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78913);
        Log.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            ckx ckx = (ckx) this.rr.iLL.iLR;
            this.IXX = ckx.IXX;
            this.sign = ckx.sign;
            this.qFV = ckx.qFV;
            this.qFU = ckx.qFU;
            this.IXY = ckx.IXY;
            Log.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", this.IXX, this.sign, this.qFV, this.qFU, Integer.valueOf(this.IXY));
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78913);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1177;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78914);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78914);
        return dispatch;
    }
}
