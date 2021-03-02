package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class y extends q implements m {
    private i callback;
    Object data;
    public d rr;

    public y(String str, int i2, Object obj) {
        AppMethodBeat.i(124126);
        d.a aVar = new d.a();
        aVar.iLN = new bjr();
        aVar.iLO = new bjs();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
        aVar.funcId = 1343;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bjr bjr = (bjr) this.rr.iLK.iLR;
        bjr.KTt = str;
        bjr.LTj = i2;
        bjr.LTk = LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA) ? 2 : 1;
        this.data = obj;
        AppMethodBeat.o(124126);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124127);
        Log.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124127);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1343;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124128);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124128);
        return dispatch;
    }
}
