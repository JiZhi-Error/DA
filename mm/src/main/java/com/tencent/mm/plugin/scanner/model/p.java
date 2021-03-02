package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class p extends q implements m {
    private i callback;
    private d rr;

    public p(String str, String str2, int i2, String str3, int i3, int i4) {
        AppMethodBeat.i(51631);
        d.a aVar = new d.a();
        aVar.iLN = new pv();
        aVar.iLO = new pw();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
        aVar.funcId = 1064;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        pv pvVar = (pv) this.rr.iLK.iLR;
        pvVar.hid = com.tencent.mm.protocal.d.KyJ;
        pvVar.hie = com.tencent.mm.protocal.d.KyI;
        pvVar.hif = com.tencent.mm.protocal.d.KyL;
        pvVar.hig = com.tencent.mm.protocal.d.KyM;
        pvVar.hih = LocaleUtil.getApplicationLanguage();
        pvVar.hii = 11294;
        pvVar.hij = null;
        pvVar.CEN = str;
        pvVar.CEM = str2;
        pvVar.type = i2;
        pvVar.value = str3;
        pvVar.count = i3;
        pvVar.AKt = i4;
        Log.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(str2)));
        AppMethodBeat.o(51631);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(51632);
        Log.d("MircoMsg.NetSceneScanProductReport", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(51632);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1064;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(51633);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(51633);
        return dispatch;
    }
}
